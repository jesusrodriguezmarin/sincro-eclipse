package ejemplos.mac.alumno;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionAlumnos {

	// Ruta del fichero adaptada para el control de alumnos
	private static final String FICHERO = "/Users/jesusrodriguezmarin/Documents/BDeclipse/alumno.dat";

	// Lista que utilizamos para cargar en memoria los alumnos almacenados como variable global
	private static ArrayList<Alumno> listaAlumnos;

	// --- MÉTODOS ---

	/**
	 * Recupera del fichero la lista de alumnos
	 */
	@SuppressWarnings("unchecked")
	public static void leerLista() {
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO));

			// Volcamos los datos directamente en nuestra variable global
			listaAlumnos = (ArrayList<Alumno>) entrada.readObject();
			entrada.close();

		} catch (Exception e) {
			System.out.println(">> Se ha producido un error: " + e.getMessage());
		}
	}

	/**
	 * Guarda el fichero en la lista de alumnos
	 */
	public static void guardarLista() {
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO));

			// Forzamos el limpiado del caché antes de escribir
			salida.reset();

			salida.writeObject(listaAlumnos);
			salida.close();
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error al guardar: " + e.getMessage());
		}
	}

	/**
	 * Método que comprueba si ese nombre de alumno está ya en la lista
	 */
	public static int buscarAlumno(String nombre) {
		// Recorremos la lista buscando por el identificador (nombre del alumno)
		for (int i = 0; i < listaAlumnos.size(); i++) {
			if (listaAlumnos.get(i).getNombre().equalsIgnoreCase(nombre.trim())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Método para añadir un alumno nuevo en la lista
	 */
	public static void añadirAlumno(String nombre, double nota) {
		// Añadimos un nuevo alumno
		listaAlumnos.add(new Alumno(nombre, nota));
	}

	/**
	 * Procedimiento que muestra por pantalla un menú de operaciones
	 */
	private static void menu() {
		System.out.println("\n****************************");
		System.out.println("* GESTIÓN DE ALUMNOS       *");
		System.out.println("* 1) Añadir alumno         *");
		System.out.println("* 2) Mostrar alumnos       *");
		System.out.println("* 3) Modificar nota        *");
		System.out.println("* 4) Eliminar alumno       *");
		System.out.println("* 5) Buscar un alumno      *");
		System.out.println("* 6) Salir                 *");
		System.out.println("****************************");
	}

	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Variables adaptadas al caso de Calificaciones de Alumnos
		int opcion;         // Opción del menú elegida por el usuario
		String nombre;      // Nombre del alumno (Clave única de búsqueda)
		double nota;        // Nota final del alumno

		// Crea la lista que tenemos declarada fuera del main
		listaAlumnos = new ArrayList<>();

		// Carga la lista desde el fichero
		leerLista();

		// Creamos lector
		Scanner teclado = new Scanner(System.in);

		// Control de errores
		try {
			// Repetimos el menú de opciones
			do {
				// Mostramos el menú
				menu();

				// Pedimos la opción al usuario
				System.out.print("Elige una opción: ");

				// Pedimos como String y parseamos para no tener problemas con scanner
				opcion = Integer.parseInt(teclado.nextLine());

				// Aplicamos el filtro selector de la opción elegida
				switch (opcion) {

				case 1: // AÑADIR ALUMNO
					System.out.println("\n>> AÑADIR ALUMNO");
					System.out.print("Introduce el nombre del alumno: ");
					nombre = teclado.nextLine().trim();

					// Comprobamos si el alumno ya se encuentra registrado
					if (buscarAlumno(nombre) != -1) {
						System.out.println("El alumno '" + nombre + "' ya está registrado.");
					} else {
						// Pedimos la nota inicial (usando Double.parseDouble)
						System.out.print("Introduce la nota final: ");
						nota = Double.parseDouble(teclado.nextLine());
						
						añadirAlumno(nombre, nota);

						// Guardamos la lista en el fichero alumno.dat
						guardarLista();
					}
					break;

				case 2: // LISTAR ALUMNOS
					System.out.println("\n>> MOSTRAR ALUMNOS");

					// Si la lista está vacía informamos
					if (listaAlumnos.size() == 0) {
						System.out.println("No hay alumnos registrados.");
					} else {
						// Mostramos los objetos almacenados
						for (int i = 0; i < listaAlumnos.size(); i++) {
							System.out.println(listaAlumnos.get(i));
						}
					}
					break;

				case 3: // MODIFICAR NOTA
					System.out.println("\n>> MODIFICAR NOTA");
					System.out.print("Introduce el nombre del alumno a modificar: ");
					nombre = teclado.nextLine().trim();

					// Obtenemos el resultado de existencia para filtrar en el condicional
					int res = buscarAlumno(nombre);

					// Controlamos si se encuentra
					if (res == -1) {
						System.out.println("No se ha encontrado al alumno '" + nombre + "'.");
					} else {
						// Pedimos la nueva nota (usando Double.parseDouble)
						System.out.print("Introduce la nueva nota: ");
						nota = Double.parseDouble(teclado.nextLine().trim());

						listaAlumnos.get(res).setNota(nota);
						System.out.println("La nota de '" + nombre + "' ha sido actualizada con éxito.");

						// Guardamos el cambio en el disco duro
						guardarLista();
					}
					break;

				case 4: // ELIMINAR ALUMNO
					System.out.println("\n>> ELIMINAR ALUMNO");
					System.out.print("Nombre del alumno a eliminar: ");
					nombre = teclado.nextLine().trim();
					int res2 = buscarAlumno(nombre);

					if (res2 == -1) {
						System.out.println("No se ha encontrado al alumno '" + nombre + "'.");
					} else {
						listaAlumnos.remove(res2);
						System.out.println("El alumno '" + nombre + "' ha sido eliminado del sistema.");
						// Guardamos la lista actualizada
						guardarLista();
					}
					break;

				case 5: // BUSCAR UN ALUMNO
					System.out.println("\n>> BUSCAR UN ALUMNO");
					System.out.print("Introduce el nombre del alumno a buscar: ");
					nombre = teclado.nextLine().trim();
					
					// Obtenemos la posición usando el método de búsqueda
					int res3 = buscarAlumno(nombre);
					
					if (res3 == -1) {
						System.out.println("No se ha encontrado al alumno '" + nombre + "'.");
					} else {
						// Mostramos los datos del objeto encontrado accediendo a su posición
						System.out.println("Alumno encontrado: " + listaAlumnos.get(res3));
					}
					break;

				case 6: // Salir
					System.out.println("Bye bye");
					break;
				default:
					System.out.println("\n>> Opción elegida no válida");
				}

			} while (opcion != 6);

			System.out.println("Que tengas un buen día...");
			teclado.close();
		} catch (Exception e) {
			System.out.println("ERROR. Valor introducido no válido");
		}
	}
}