package ejemplos.mac.libro;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionLibros {

	// Ruta del fichero 
	private static final String FICHERO = "/Users/jesusrodriguezmarin/Documents/BDeclipse/libro.dat";

	// Lista que utilizamos para cargar en memoria los libros almacenados como variable global
	private static ArrayList<Libro> listaLibros;

	// --- MÉTODOS ---

	/**
	 * Recupera del fichero la lista de libros
	 */
	@SuppressWarnings("unchecked")
	public static void leerLista() {
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO));

			// Volcamos los datos directamente en nuestra variable global
			listaLibros = (ArrayList<Libro>) entrada.readObject();
			entrada.close();

		} catch (Exception e) {
			System.out.println(">> Se ha producido un error: " + e.getMessage());
		}
	}

	/**
	 * Guarda el fichero en la lista de libros
	 */
	public static void guardarLista() {
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO));

			// Forzamos el limpiado del caché antes de escribir
			salida.reset();

			salida.writeObject(listaLibros);
			salida.close();
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error al guardar: " + e.getMessage());
		}
	}

	/**
	 * Método que comprueba si ese título de libro está ya en la lista
	 */
	public static int buscarLibro(String titulo) {
		// Recorremos la lista
		for (int i = 0; i < listaLibros.size(); i++) {
			if (listaLibros.get(i).getTitulo().equalsIgnoreCase(titulo.trim())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Método para añadir un libro nuevo en la lista
	 */
	public static void añadirLibro(String titulo, String autor, int paginas) {
		// Añadimos un nuevo libro
		listaLibros.add(new Libro(titulo, autor, paginas));
	}

	/**
	 * Procedimiento que muestra por pantalla un menú de operaciones
	 */
	private static void menu() {
		System.out.println("\n****************************");
		System.out.println("* GESTIÓN DE LIBROS      *");
		System.out.println("* 1) Añadir libro          *");
		System.out.println("* 2) Mostrar libros        *");
		System.out.println("* 3) Modificar páginas     *");
		System.out.println("* 4) Eliminar libro        *");
		System.out.println("* 5) Buscar un libro       *");
		System.out.println("* 6) Salir                 *");
		System.out.println("****************************");
	}

	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Variables 
		int opcion;         // Opción del menú elegida por el usuario
		String titulo;      // Título del libro
		String autor;       // Autor del libro
		int paginas;        // Páginas del libro

		// Crea la lista que tenemos declarada fuera del main
		listaLibros = new ArrayList<>();

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

				case 1: // AÑADIR LIBRO
					System.out.println("\n>> AÑADIR LIBRO");
					System.out.print("Introduce el título: ");
					titulo = teclado.nextLine().trim();

					// Comprobamos si el libro ya se encuentra registrado
					if (buscarLibro(titulo) != -1) {
						System.out.println("El libro '" + titulo + "' ya se encuentra registrado.");
					} else {
						// Pedimos los datos restantes del libro a añadir
						System.out.print("Introduce el autor: ");
						autor = teclado.nextLine().trim();
						
						System.out.print("Introduce las páginas: ");
						paginas = Integer.parseInt(teclado.nextLine());
						
						añadirLibro(titulo, autor, paginas);

						// Guardamos la lista en el fichero libro.dat
						guardarLista();
					}
					break;

				case 2: // LISTAR LIBROS
					System.out.println("\n>> MOSTRAR LIBROS");

					// Si la lista está vacía informamos
					if (listaLibros.size() == 0) {
						System.out.println("No hay libros registrados.");
					} else {
						// Mostramos los objetos almacenados
						for (int i = 0; i < listaLibros.size(); i++) {
							System.out.println(listaLibros.get(i));
						}
					}
					break;

				case 3: // MODIFICAR PÁGINAS
					System.out.println("\n>> MODIFICAR PÁGINAS");
					System.out.print("Introduce el título del libro a modificar: ");
					titulo = teclado.nextLine().trim();

					// Obtenemos el resultado de existencia para filtrar en el condicional
					int res = buscarLibro(titulo);

					// Controlamos si se encuentra
					if (res == -1) {
						System.out.println("No se ha encontrado el libro '" + titulo + "'.");
					} else {
						// Pedimos el nuevo número de páginas
						System.out.print("Nuevo número de páginas: ");
						paginas = Integer.parseInt(teclado.nextLine().trim());

						listaLibros.get(res).setPaginas(paginas);
						System.out.println("El número de páginas de '" + titulo + "' ha sido modificado con éxito.");

						// Guardamos el cambio en el disco duro
						guardarLista();
					}
					break;

				case 4: // ELIMINAR LIBRO
					System.out.println("\n>> ELIMINAR LIBRO");
					System.out.print("Título del libro a eliminar: ");
					titulo = teclado.nextLine().trim();
					int res2 = buscarLibro(titulo);

					if (res2 == -1) {
						System.out.println("No se ha encontrado el libro '" + titulo + "'.");
					} else {
						listaLibros.remove(res2);
						System.out.println("El libro '" + titulo + "' ha sido eliminado.");
						// Guardamos la lista actualizada
						guardarLista();
					}
					break;

				case 5: // BUSCAR UN LIBRO
					System.out.println("\n>> BUSCAR UN LIBRO");
					System.out.print("Introduce el título del libro a buscar: ");
					titulo = teclado.nextLine().trim();
					
					// Obtenemos la posición usando el método de búsqueda
					int res3 = buscarLibro(titulo);
					
					if (res3 == -1) {
						System.out.println("No se ha encontrado el libro '" + titulo + "'.");
					} else {
						// Mostramos los datos del objeto encontrado accediendo a su posición
						System.out.println("Libro encontrado: " + listaLibros.get(res3));
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