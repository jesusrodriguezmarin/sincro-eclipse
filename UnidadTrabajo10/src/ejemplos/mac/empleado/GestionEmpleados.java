package ejemplos.mac.empleado;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionEmpleados {

	// Ruta del fichero 
	private static final String FICHERO = "/Users/jesusrodriguezmarin/Documents/BDeclipse/empleado.dat";

	// Lista que utilizamos para cargar en memoria los empleados almacenados como variable global
	private static ArrayList<Empleado> listaEmpleados;

	// --- MÉTODOS ---

	/**
	 * Recupera del fichero la lista de empleados
	 */
	@SuppressWarnings("unchecked")
	public static void leerLista() {
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO));

			// Volcamos los datos directamente en nuestra variable global
			listaEmpleados = (ArrayList<Empleado>) entrada.readObject();
			entrada.close();

		} catch (Exception e) {
			System.out.println(">> Se ha producido un error: " + e.getMessage());
		}
	}

	/**
	 * Guarda el fichero en la lista de empleados
	 */
	public static void guardarLista() {
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO));

			// Forzamos el limpiado del caché antes de escribir
			salida.reset();

			salida.writeObject(listaEmpleados);
			salida.close();
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error al guardar: " + e.getMessage());
		}
	}

	/**
	 * Método que comprueba si ese nombre de empleado está ya en la lista
	 */
	public static int buscarEmpleado(String nombre) {
		// Recorremos la lista
		for (int i = 0; i < listaEmpleados.size(); i++) {
			if (listaEmpleados.get(i).getNombre().equalsIgnoreCase(nombre.trim())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Método para añadir un empleado nuevo en la lista
	 */
	public static void añadirEmpleado(String nombre, double sueldo) {
		// Añadimos un nuevo empleado
		listaEmpleados.add(new Empleado(nombre, sueldo));
	}

	/**
	 * Procedimiento que muestra por pantalla un menú de operaciones
	 */
	private static void menu() {
		System.out.println("\n****************************");
		System.out.println("* GESTIÓN DE EMPLEADOS   *");
		System.out.println("* 1) Añadir empleado     *");
		System.out.println("* 2) Mostrar empleados   *");
		System.out.println("* 3) Modificar sueldo    *");
		System.out.println("* 4) Eliminar empleado   *");
		System.out.println("* 5) Buscar un empleado  *");
		System.out.println("* 6) Salir               *");
		System.out.println("****************************");
	}

	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Variables
		int opcion;         // Opción del menú elegida por el usuario
		String nombre;      // Nombre del empleado
		double sueldo;      // Sueldo del empleado 

		// Crea la lista que tenemos declarada fuera del main
		listaEmpleados = new ArrayList<>();

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

				case 1: // AÑADIR EMPLEADO
					System.out.println("\n>> AÑADIR EMPLEADO");
					System.out.print("Introduce el nombre: ");
					nombre = teclado.nextLine().trim();

					// Comprobamos si el empleado ya se encuentra registrado
					if (buscarEmpleado(nombre) != -1) {
						System.out.println("El empleado " + nombre + " ya se encuentra registrado.");
					} else {
						// Pedimos el sueldo del empleado a añadir
						System.out.print("Introduce el sueldo: ");
						sueldo = Double.parseDouble(teclado.nextLine());
						añadirEmpleado(nombre, sueldo);

						// Guardamos la lista en el fichero empleado.dat
						guardarLista();
					}
					break;

				case 2: // LISTAR EMPLEADOS
					System.out.println("\n>> MOSTRAR EMPLEADOS");

					// Si la lista está vacía informamos
					if (listaEmpleados.size() == 0) {
						System.out.println("No hay empleados registrados.");
					} else {
						// Mostramos los objetos almacenados
						for (int i = 0; i < listaEmpleados.size(); i++) {
							System.out.println(listaEmpleados.get(i));
						}
					}
					break;

				case 3: // MODIFICAR SUELDO
					System.out.println("\n>> MODIFICAR SUELDO");
					System.out.print("Introduce el nombre del empleado a modificar: ");
					nombre = teclado.nextLine().trim();

					// Obtenemos el resultado de existencia para filtrar en el condicional
					int res = buscarEmpleado(nombre);

					// Controlamos si se encuentra
					if (res == -1) {
						System.out.println("No se ha encontrado al empleado '" + nombre + "'.");
					} else {
						// Pedimos el nuevo sueldo 
						System.out.print("Nuevo sueldo: ");
						sueldo = Double.parseDouble(teclado.nextLine().trim());

						listaEmpleados.get(res).setSueldo(sueldo);
						System.out.println("El sueldo de " + nombre + " ha sido modificado a " + sueldo + "€ con éxito.");

						// Guardamos el cambio en el disco duro
						guardarLista();
					}
					break;

				case 4: // ELIMINAR EMPLEADO
					System.out.println("\n>> ELIMINAR EMPLEADO");
					System.out.print("Nombre del empleado a eliminar: ");
					nombre = teclado.nextLine().trim();
					int res2 = buscarEmpleado(nombre);

					if (res2 == -1) {
						System.out.println("No se ha encontrado al empleado '" + nombre + "'.");
					} else {
						listaEmpleados.remove(res2);
						System.out.println("El empleado " + nombre + " ha sido eliminado.");
						// Guardamos la lista actualizada
						guardarLista();
					}
					break;

				case 5: // BUSCAR UN EMPLEADO
					System.out.println("\n>> BUSCAR UN EMPLEADO");
					System.out.print("Introduce el nombre del empleado a buscar: ");
					nombre = teclado.nextLine().trim();
					
					// Obtenemos la posición usando el método de búsqueda
					int res3 = buscarEmpleado(nombre);
					
					if (res3 == -1) {
						System.out.println("No se ha encontrado al empleado '" + nombre + "'.");
					} else {
						// Mostramos los datos del objeto encontrado accediendo a su posición
						System.out.println("Empleado encontrado: " + listaEmpleados.get(res3));
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