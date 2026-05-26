package ejemplos.mac.proveedor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionProveedores {

	// Ruta del fichero adaptada para proveedores
	private static final String FICHERO = "/Users/jesusrodriguezmarin/Documents/BDeclipse/proveedor.dat";

	// Lista que utilizamos para cargar en memoria los proveedores almacenados como variable global
	private static ArrayList<Proveedor> listaProveedores;

	// --- MÉTODOS ---

	/**
	 * Recupera del fichero la lista de proveedores
	 */
	@SuppressWarnings("unchecked")
	public static void leerLista() {
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO));

			// Volcamos los datos directamente en nuestra variable global
			listaProveedores = (ArrayList<Proveedor>) entrada.readObject();
			entrada.close();

		} catch (Exception e) {
			System.out.println(">> Se ha producido un error: " + e.getMessage());
		}
	}

	/**
	 * Guarda el fichero en la lista de proveedores
	 */
	public static void guardarLista() {
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO));

			// Forzamos el limpiado del caché antes de escribir
			salida.reset();

			salida.writeObject(listaProveedores);
			salida.close();
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error al guardar: " + e.getMessage());
		}
	}

	/**
	 * Método que comprueba si ese nombre de proveedor está ya en la lista
	 */
	public static int buscarProveedor(String nombre) {
		// Recorremos la lista buscando por el nombre del proveedor
		for (int i = 0; i < listaProveedores.size(); i++) {
			if (listaProveedores.get(i).getNombre().equalsIgnoreCase(nombre.trim())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Método para añadir un proveedor nuevo en la lista
	 */
	public static void añadirProveedor(String nombre, String ciudad) {
		// Añadimos un nuevo proveedor
		listaProveedores.add(new Proveedor(nombre, ciudad));
	}

	/**
	 * Procedimiento que muestra por pantalla un menú de operaciones
	 */
	private static void menu() {
		System.out.println("\n****************************");
		System.out.println("* GESTIÓN DE PROVEEDORES   *");
		System.out.println("* 1) Añadir proveedor      *");
		System.out.println("* 2) Mostrar proveedores   *");
		System.out.println("* 3) Modificar ciudad      *");
		System.out.println("* 4) Eliminar proveedor    *");
		System.out.println("* 5) Buscar un proveedor   *");
		System.out.println("* 6) Salir                 *");
		System.out.println("****************************");
	}

	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Variables adaptadas al caso de Proveedores
		int opcion;         // Opción del menú elegida por el usuario
		String nombre;      // Nombre del proveedor (Clave única de búsqueda)
		String ciudad;      // Ciudad de procedencia del proveedor

		// Crea la lista que tenemos declarada fuera del main
		listaProveedores = new ArrayList<>();

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

				case 1: // AÑADIR PROVEEDOR
					System.out.println("\n>> AÑADIR PROVEEDOR");
					System.out.print("Introduce el nombre del proveedor: ");
					nombre = teclado.nextLine().trim();

					// Comprobamos si el proveedor ya se encuentra registrado
					if (buscarProveedor(nombre) != -1) {
						System.out.println("El proveedor '" + nombre + "' ya está registrado.");
					} else {
						// Pedimos la ciudad del proveedor
						System.out.print("Introduce la ciudad: ");
						ciudad = teclado.nextLine().trim();
						
						añadirProveedor(nombre, ciudad);

						// Guardamos la lista en el fichero proveedor.dat
						guardarLista();
					}
					break;

				case 2: // LISTAR PROVEEDORES
					System.out.println("\n>> MOSTRAR PROVEEDORES");

					// Si la lista está vacía informamos
					if (listaProveedores.size() == 0) {
						System.out.println("No hay proveedores registrados.");
					} else {
						// Mostramos los objetos almacenados
						for (int i = 0; i < listaProveedores.size(); i++) {
							System.out.println(listaProveedores.get(i));
						}
					}
					break;

				case 3: // MODIFICAR CIUDAD
					System.out.println("\n>> MODIFICAR CIUDAD");
					System.out.print("Introduce el nombre del proveedor a modificar: ");
					nombre = teclado.nextLine().trim();

					// Obtenemos el resultado de existencia para filtrar en el condicional
					int res = buscarProveedor(nombre);

					// Controlamos si se encuentra
					if (res == -1) {
						System.out.println("No se ha encontrado el proveedor '" + nombre + "'.");
					} else {
						// Pedimos la nueva ciudad
						System.out.print("Introduce la NUEVA ciudad: ");
						ciudad = teclado.nextLine().trim();

						listaProveedores.get(res).setCiudad(ciudad);
						System.out.println("La ciudad del proveedor '" + nombre + "' ha sido modificada con éxito.");

						// Guardamos el cambio en el disco duro
						guardarLista();
					}
					break;

				case 4: // ELIMINAR PROVEEDOR
					System.out.println("\n>> ELIMINAR PROVEEDOR");
					System.out.print("Nombre del proveedor a eliminar: ");
					nombre = teclado.nextLine().trim();
					int res2 = buscarProveedor(nombre);

					if (res2 == -1) {
						System.out.println("No se ha encontrado el proveedor '" + nombre + "'.");
					} else {
						listaProveedores.remove(res2);
						System.out.println("El proveedor '" + nombre + "' ha sido eliminado.");
						// Guardamos la lista actualizada
						guardarLista();
					}
					break;

				case 5: // BUSCAR UN PROVEEDOR
					System.out.println("\n>> BUSCAR UN PROVEEDOR");
					System.out.print("Introduce el nombre del proveedor a buscar: ");
					nombre = teclado.nextLine().trim();
					
					// Obtenemos la posición usando el método de búsqueda
					int res3 = buscarProveedor(nombre);
					
					if (res3 == -1) {
						System.out.println("No se ha encontrado el proveedor '" + nombre + "'.");
					} else {
						// Mostramos los datos del objeto encontrado accediendo a su posición
						System.out.println("Proveedor encontrado: " + listaProveedores.get(res3));
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