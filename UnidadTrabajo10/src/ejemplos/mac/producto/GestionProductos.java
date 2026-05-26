package ejemplos.mac.producto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionProductos {

	// Ruta del fichero 
	private static final String FICHERO = "/Users/jesusrodriguezmarin/Documents/BDeclipse/producto.dat";

	// Lista que utilizamos para cargar en memoria los productos almacenados como variable global
	private static ArrayList<Producto> listaProductos;

	// --- MÉTODOS ---

	/**
	 * Recupera del fichero la lista de productos
	 */
	@SuppressWarnings("unchecked")
	public static void leerLista() {
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO));

			// Volcamos los datos directamente en nuestra variable global
			listaProductos = (ArrayList<Producto>) entrada.readObject();
			entrada.close();

		} catch (Exception e) {
			System.out.println(">> Se ha producido un error: " + e.getMessage());
		}
	}

	/**
	 * Guarda el fichero en la lista de productos
	 */
	public static void guardarLista() {
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO));

			// Forzamos el limpiado del caché antes de escribir
			salida.reset();

			salida.writeObject(listaProductos);
			salida.close();
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error al guardar: " + e.getMessage());
		}
	}

	/**
	 * Método que comprueba si ese nombre de producto está ya en la lista
	 */
	public static int buscarProducto(String nombre) {
		// Recorremos la lista
		for (int i = 0; i < listaProductos.size(); i++) {
			if (listaProductos.get(i).getNombre().equalsIgnoreCase(nombre.trim())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Método para añadir un producto nuevo en la lista
	 */
	public static void añadirProducto(String nombre, double precio) {
		// Añadimos un nuevo producto
		listaProductos.add(new Producto(nombre, precio));
	}

	/**
	 * Procedimiento que muestra por pantalla un menú de operaciones
	 */
	private static void menu() {
		System.out.println("\n****************************");
		System.out.println("* GESTIÓN DE PRODUCTOS     *");
		System.out.println("* 1) Añadir producto       *");
		System.out.println("* 2) Mostrar productos     *");
		System.out.println("* 3) Modificar precio      *");
		System.out.println("* 4) Eliminar producto     *");
		System.out.println("* 5) Buscar un producto    *");
		System.out.println("* 6) Salir                 *");
		System.out.println("****************************");
	}

	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Variables 
		int opcion;         // Opción del menú elegida por el usuario
		String nombre;      // Nombre del producto
		double precio;      // Precio del producto

		// Crea la lista que tenemos declarada fuera del main
		listaProductos = new ArrayList<>();

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

				case 1: // AÑADIR PRODUCTO
					System.out.println("\n>> AÑADIR PRODUCTO");
					System.out.print("Introduce el nombre: ");
					nombre = teclado.nextLine().trim();

					// Comprobamos si el producto ya se encuentra registrado
					if (buscarProducto(nombre) != -1) {
						System.out.println("El producto " + nombre + " ya se encuentra registrado.");
					} else {
						// Pedimos el precio del producto a añadir (usando Double.parseDouble)
						System.out.print("Introduce el precio: ");
						precio = Double.parseDouble(teclado.nextLine());
						añadirProducto(nombre, precio);

						// Guardamos la lista en el fichero producto.dat
						guardarLista();
					}
					break;

				case 2: // LISTAR PRODUCTOS
					System.out.println("\n>> MOSTRAR PRODUCTOS");

					// Si la lista está vacía informamos
					if (listaProductos.size() == 0) {
						System.out.println("No hay productos registrados.");
					} else {
						// Mostramos los objetos almacenados
						for (int i = 0; i < listaProductos.size(); i++) {
							System.out.println(listaProductos.get(i));
						}
					}
					break;

				case 3: // MODIFICAR PRECIO
					System.out.println("\n>> MODIFICAR PRECIO");
					System.out.print("Introduce el nombre del producto a modificar: ");
					nombre = teclado.nextLine().trim();

					// Obtenemos el resultado de existencia para filtrar en el condicional
					int res = buscarProducto(nombre);

					// Controlamos si se encuentra
					if (res == -1) {
						System.out.println("No se ha encontrado el producto '" + nombre + "'.");
					} else {
						// Pedimos el nuevo precio (usando Double.parseDouble)
						System.out.print("Nuevo precio: ");
						precio = Double.parseDouble(teclado.nextLine().trim());

						listaProductos.get(res).setPrecio(precio);
						System.out.println("El precio de " + nombre + " ha sido modificado a " + precio + "€ con éxito.");

						// Guardamos el cambio en el disco duro
						guardarLista();
					}
					break;

				case 4: // ELIMINAR PRODUCTO
					System.out.println("\n>> ELIMINAR PRODUCTO");
					System.out.print("Nombre del producto a eliminar: ");
					nombre = teclado.nextLine().trim();
					int res2 = buscarProducto(nombre);

					if (res2 == -1) {
						System.out.println("No se ha encontrado el producto '" + nombre + "'.");
					} else {
						listaProductos.remove(res2);
						System.out.println("El producto " + nombre + " ha sido eliminado.");
						// Guardamos la lista actualizada
						guardarLista();
					}
					break;

				case 5: // BUSCAR UN PRODUCTO
					System.out.println("\n>> BUSCAR UN PRODUCTO");
					System.out.print("Introduce el nombre del producto a buscar: ");
					nombre = teclado.nextLine().trim();
					
					// Obtenemos la posición usando el método de búsqueda
					int res3 = buscarProducto(nombre);
					
					if (res3 == -1) {
						System.out.println("No se ha encontrado el producto '" + nombre + "'.");
					} else {
						// Mostramos los datos del objeto encontrado accediendo a su posición
						System.out.println("Producto encontrado: " + listaProductos.get(res3));
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