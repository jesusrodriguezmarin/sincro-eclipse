package ejemplos.mac.pieza;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionPiezas {

	// Ruta del fichero adaptada para el control de piezas
	private static final String FICHERO = "/Users/jesusrodriguezmarin/Documents/BDeclipse/pieza.dat";

	// Lista que utilizamos para cargar en memoria las piezas almacenadas como variable global
	private static ArrayList<Pieza> listaPiezas;

	// --- MÉTODOS ---

	/**
	 * Recupera del fichero la lista de piezas
	 */
	@SuppressWarnings("unchecked")
	public static void leerLista() {
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO));

			// Volcamos los datos directamente en nuestra variable global
			listaPiezas = (ArrayList<Pieza>) entrada.readObject();
			entrada.close();

		} catch (Exception e) {
			System.out.println(">> Se ha producido un error: " + e.getMessage());
		}
	}

	/**
	 * Guarda el fichero en la lista de piezas
	 */
	public static void guardarLista() {
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO));

			// Forzamos el limpiado del caché antes de escribir
			salida.reset();

			salida.writeObject(listaPiezas);
			salida.close();
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error al guardar: " + e.getMessage());
		}
	}

	/**
	 * Método que comprueba si ese nombre de pieza está ya en la lista
	 */
	public static int buscarPieza(String nombre) {
		// Recorremos la lista buscando por el identificador (nombre de la pieza)
		for (int i = 0; i < listaPiezas.size(); i++) {
			if (listaPiezas.get(i).getNombre().equalsIgnoreCase(nombre.trim())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Método para añadir una pieza nueva en la lista
	 */
	public static void añadirPieza(String nombre, int cantidad) {
		// Añadimos una nueva pieza
		listaPiezas.add(new Pieza(nombre, cantidad));
	}

	/**
	 * Procedimiento que muestra por pantalla un menú de operaciones
	 */
	private static void menu() {
		System.out.println("\n****************************");
		System.out.println("* GESTIÓN DE PIEZAS        *");
		System.out.println("* 1) Añadir pieza          *");
		System.out.println("* 2) Mostrar piezas        *");
		System.out.println("* 3) Modificar cantidad    *");
		System.out.println("* 4) Eliminar pieza        *");
		System.out.println("* 5) Buscar una pieza      *");
		System.out.println("* 6) Salir                 *");
		System.out.println("****************************");
	}

	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Variables adaptadas al caso de Inventario de Piezas
		int opcion;         // Opción del menú elegida por el usuario
		String nombre;      // Nombre de la pieza (Clave única de búsqueda)
		int cantidad;       // Cantidad de piezas en stock

		// Crea la lista que tenemos declarada fuera del main
		listaPiezas = new ArrayList<>();

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

				case 1: // AÑADIR PIEZA
					System.out.println("\n>> AÑADIR PIEZA");
					System.out.print("Introduce el nombre de la pieza: ");
					nombre = teclado.nextLine().trim();

					// Comprobamos si la pieza ya se encuentra registrada por su nombre
					if (buscarPieza(nombre) != -1) {
						System.out.println("La pieza '" + nombre + "' ya está en el inventario.");
					} else {
						// Pedimos la cantidad inicial en stock
						System.out.print("Introduce la cantidad inicial: ");
						cantidad = Integer.parseInt(teclado.nextLine());
						
						añadirPieza(nombre, cantidad);

						// Guardamos la lista en el fichero pieza.dat
						guardarLista();
					}
					break;

				case 2: // LISTAR PIEZAS
					System.out.println("\n>> MOSTRAR PIEZAS");

					// Si la lista está vacía informamos
					if (listaPiezas.size() == 0) {
						System.out.println("No hay piezas en el inventario.");
					} else {
						// Mostramos los objetos almacenados
						for (int i = 0; i < listaPiezas.size(); i++) {
							System.out.println(listaPiezas.get(i));
						}
					}
					break;

				case 3: // MODIFICAR CANTIDAD
					System.out.println("\n>> MODIFICAR CANTIDAD");
					System.out.print("Introduce el nombre de la pieza a modificar: ");
					nombre = teclado.nextLine().trim();

					// Obtenemos el resultado de existencia para filtrar en el condicional
					int res = buscarPieza(nombre);

					// Controlamos si se encuentra
					if (res == -1) {
						System.out.println("No se ha encontrado la pieza '" + nombre + "'.");
					} else {
						// Pedimos la nueva cantidad (usando Integer.parseInt)
						System.out.print("Introduce el nuevo stock: ");
						cantidad = Integer.parseInt(teclado.nextLine().trim());

						listaPiezas.get(res).setCantidad(cantidad);
						System.out.println("El stock de la pieza '" + nombre + "' ha sido actualizado con éxito.");

						// Guardamos el cambio en el disco duro
						guardarLista();
					}
					break;

				case 4: // ELIMINAR PIEZA
					System.out.println("\n>> ELIMINAR PIEZA");
					System.out.print("Nombre de la pieza a eliminar: ");
					nombre = teclado.nextLine().trim();
					int res2 = buscarPieza(nombre);

					if (res2 == -1) {
						System.out.println("No se ha encontrado la pieza '" + nombre + "'.");
					} else {
						listaPiezas.remove(res2);
						System.out.println("La pieza '" + nombre + "' ha sido descatalogada y eliminada.");
						// Guardamos la lista actualizada
						guardarLista();
					}
					break;

				case 5: // BUSCAR UNA PIEZA
					System.out.println("\n>> BUSCAR UNA PIEZA");
					System.out.print("Introduce el nombre de la pieza a buscar: ");
					nombre = teclado.nextLine().trim();
					
					// Obtenemos la posición usando el método de búsqueda
					int res3 = buscarPieza(nombre);
					
					if (res3 == -1) {
						System.out.println("No se ha encontrado la pieza '" + nombre + "'.");
					} else {
						// Mostramos los datos del objeto encontrado accediendo a su posición
						System.out.println("Pieza encontrada: " + listaPiezas.get(res3));
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