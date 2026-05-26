package ejemplos.mac.asignatura;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionAsignaturas {

	// Ruta del fichero 
	private static final String FICHERO = "/Users/jesusrodriguezmarin/Documents/BDeclipse/asignatura.dat";

	// Lista que utilizamos para cargar en memoria las asignaturas almacenadas como variable global
	private static ArrayList<Asignatura> listaAsignaturas;

	// --- MÉTODOS ---

	/**
	 * Recupera del fichero la lista de asignaturas
	 */
	@SuppressWarnings("unchecked")
	public static void leerLista() {
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO));

			// Volcamos los datos directamente en nuestra variable global
			listaAsignaturas = (ArrayList<Asignatura>) entrada.readObject();
			entrada.close();

		} catch (Exception e) {
			System.out.println(">> Se ha producido un error: " + e.getMessage());
		}
	}

	/**
	 * Guarda el fichero en la lista de asignaturas
	 */
	public static void guardarLista() {
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO));

			// Forzamos el limpiado del caché antes de escribir
			salida.reset();

			salida.writeObject(listaAsignaturas);
			salida.close();
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error al guardar: " + e.getMessage());
		}
	}

	/**
	 * Método que comprueba si ese nombre de asignatura está ya en la lista
	 */
	public static int buscarAsignatura(String nombre) {
		// Recorremos la lista buscando por el nombre
		for (int i = 0; i < listaAsignaturas.size(); i++) {
			if (listaAsignaturas.get(i).getNombre().equalsIgnoreCase(nombre.trim())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Método para añadir una asignatura nueva en la lista
	 */
	public static void añadirAsignatura(String nombre, int horas) {
		// Añadimos una nueva asignatura
		listaAsignaturas.add(new Asignatura(nombre, horas));
	}

	/**
	 * Procedimiento que muestra por pantalla un menú de operaciones
	 */
	private static void menu() {
		System.out.println("\n****************************");
		System.out.println("* GESTIÓN DE ASIGNATURAS   *");
		System.out.println("* 1) Añadir asignatura     *");
		System.out.println("* 2) Mostrar asignaturas   *");
		System.out.println("* 3) Modificar horas       *");
		System.out.println("* 4) Eliminar asignatura   *");
		System.out.println("* 5) Buscar una asignatura *");
		System.out.println("* 6) Salir                 *");
		System.out.println("****************************");
	}

	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Variables 
		int opcion;         // Opción del menú elegida por el usuario
		String nombre;      // Nombre de la asignatura (Clave única de búsqueda)
		int horas;          // Horas lectivas de la asignatura

		// Crea la lista que tenemos declarada fuera del main
		listaAsignaturas = new ArrayList<>();

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

				case 1: // AÑADIR ASIGNATURA
					System.out.println("\n>> AÑADIR ASIGNATURA");
					System.out.print("Introduce el nombre de la asignatura: ");
					nombre = teclado.nextLine().trim();

					// Comprobamos si la asignatura ya se encuentra registrada por su nombre
					if (buscarAsignatura(nombre) != -1) {
						System.out.println("La asignatura '" + nombre + "' ya está registrada.");
					} else {
						// Pedimos las horas lectivas
						System.out.print("Introduce las horas lectivas: ");
						horas = Integer.parseInt(teclado.nextLine());
						
						añadirAsignatura(nombre, horas);

						// Guardamos la lista en el fichero asignatura.dat
						guardarLista();
					}
					break;

				case 2: // LISTAR ASIGNATURAS
					System.out.println("\n>> MOSTRAR ASIGNATURAS");

					// Si la lista está vacía informamos
					if (listaAsignaturas.size() == 0) {
						System.out.println("No hay asignaturas registradas.");
					} else {
						// Mostramos los objetos almacenados
						for (int i = 0; i < listaAsignaturas.size(); i++) {
							System.out.println(listaAsignaturas.get(i));
						}
					}
					break;

				case 3: // MODIFICAR HORAS
					System.out.println("\n>> MODIFICAR HORAS");
					System.out.print("Introduce el nombre de la asignatura a modificar: ");
					nombre = teclado.nextLine().trim();

					// Obtenemos el resultado de existencia para filtrar en el condicional
					int res = buscarAsignatura(nombre);

					// Controlamos si se encuentra
					if (res == -1) {
						System.out.println("No se ha encontrado la asignatura '" + nombre + "'.");
					} else {
						// Pedimos el nuevo número de horas
						System.out.print("Nuevo número de horas lectivas: ");
						horas = Integer.parseInt(teclado.nextLine().trim());

						listaAsignaturas.get(res).setHoras(horas);
						System.out.println("Las horas de la asignatura '" + nombre + "' han sido modificadas con éxito.");

						// Guardamos el cambio en el disco duro
						guardarLista();
					}
					break;

				case 4: // ELIMINAR ASIGNATURA
					System.out.println("\n>> ELIMINAR ASIGNATURA");
					System.out.print("Nombre de la asignatura a eliminar: ");
					nombre = teclado.nextLine().trim();
					int res2 = buscarAsignatura(nombre);

					if (res2 == -1) {
						System.out.println("No se ha encontrado la asignatura '" + nombre + "'.");
					} else {
						listaAsignaturas.remove(res2);
						System.out.println("La asignatura '" + nombre + "' ha sido eliminada.");
						// Guardamos la lista actualizada
						guardarLista();
					}
					break;

				case 5: // BUSCAR UNA ASIGNATURA
					System.out.println("\n>> BUSCAR UNA ASIGNATURA");
					System.out.print("Introduce el nombre de la asignatura a buscar: ");
					nombre = teclado.nextLine().trim();
					
					// Obtenemos la posición usando el método de búsqueda
					int res3 = buscarAsignatura(nombre);
					
					if (res3 == -1) {
						System.out.println("No se ha encontrado la asignatura '" + nombre + "'.");
					} else {
						// Mostramos los datos del objeto encontrado accediendo a su posición
						System.out.println("Asignatura encontrada: " + listaAsignaturas.get(res3));
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