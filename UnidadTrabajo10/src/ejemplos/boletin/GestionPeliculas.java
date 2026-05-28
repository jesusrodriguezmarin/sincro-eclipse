package ejemplos.boletin;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionPeliculas {

	// Ruta del fichero 
	private static final String FICHERO = "/Users/jesusrodriguezmarin/Documents/BDeclipse/peliculas.dat";

	// Lista que utilizamos para cargar en memoria las películas almacenadas como variable global
	private static ArrayList<Pelicula> listaPeliculas;

	// --- MÉTODOS ---

	/**
	 * Recupera del fichero la lista de películas
	 */
	@SuppressWarnings("unchecked")
	public static void leerLista() {
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO));

			// Volcamos los datos directamente en nuestra variable global
			listaPeliculas = (ArrayList<Pelicula>) entrada.readObject();
			entrada.close();

		} catch (Exception e) {
			System.out.println(">> Se ha producido un error: " + e.getMessage());
		}
	}

	/**
	 * Guarda el fichero en la lista de películas
	 */
	public static void guardarLista() {
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO));

			// Forzamos el limpiado del caché antes de escribir
			salida.reset();

			salida.writeObject(listaPeliculas);
			salida.close();
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error al guardar: " + e.getMessage());
		}
	}

	/**
	 * Método que comprueba si ese título de película está ya en la lista
	 */
	public static int buscarPelicula(String titulo) {
		// Recorremos la lista buscando por el título
		for (int i = 0; i < listaPeliculas.size(); i++) {
			if (listaPeliculas.get(i).getTitulo().equalsIgnoreCase(titulo.trim())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Método para añadir una película nueva en la lista
	 */
	public static void añadirPelicula(String titulo, int anio, String director) {
		// Añadimos una nueva película
		listaPeliculas.add(new Pelicula(titulo, anio, director));
	}

	/**
	 * Procedimiento que muestra por pantalla un menú de operaciones
	 */
	private static void menu() {
		System.out.println("\n****************************");
		System.out.println("*   GESTIÓN DE PELÍCULAS   *");
		System.out.println("*                          *");
		System.out.println("*  1) Añadir película      *");
		System.out.println("*  2) Mostrar películas    *");
		System.out.println("*  3) Modificar título     *");
		System.out.println("*  4) Eliminar película    *");
		System.out.println("*  5) Salir                *");
		System.out.println("*                          *");
		System.out.println("****************************");
	}

	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Variables 
		int opcion;         // Opción del menú elegida por el usuario
		String titulo;      // Título de la película (Clave única de búsqueda)
		int anio;           // Año de estreno de la película
		String director;	// Director de la película

		// Crea la lista que tenemos declarada fuera del main
		listaPeliculas = new ArrayList<>();

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

				case 1: // AÑADIR PELÍCULA
					System.out.println("\n>> AÑADIR PELÍCULA");
					System.out.print("Introduce el título: ");
					titulo = teclado.nextLine().trim();

					// Comprobamos si la película ya se encuentra registrada por su título
					if (buscarPelicula(titulo) != -1) {
						System.out.println("La película '" + titulo + "' ya está registrada.");
					} else {
						// Pedimos el año de estreno
						System.out.print("Introduce el año de estreno: ");
						anio = Integer.parseInt(teclado.nextLine());
						
						System.out.print("Introduce el director: ");
						director = teclado.nextLine();
						
						añadirPelicula(titulo, anio, director);

						// Guardamos la lista en el fichero pelicula.dat
						guardarLista();
					}
					break;

				case 2: // MOSTRAR PELÍCULAS
					System.out.println("\n>> MOSTRAR PELÍCULAS");

					// Si la lista está vacía informamos
					if (listaPeliculas.size() == 0) {
						System.out.println("No hay películas registradas.");
					} else {
						// Mostramos los objetos almacenados
						for (int i = 0; i < listaPeliculas.size(); i++) {
							System.out.println(listaPeliculas.get(i));
						}
					}
					break;

				case 3: // MODIFICAR TÍTULO
					System.out.println("\n>> MODIFICAR TÍTULO");
					System.out.print("Introduce el título de la película a modificar: ");
					titulo = teclado.nextLine().trim();

					// Obtenemos el resultado de existencia para filtrar en el condicional
					int res = buscarPelicula(titulo);

					// Controlamos si se encuentra
					if (res == -1) {
						System.out.println("No se ha encontrado la película '" + titulo + "'.");
					} else {
						// Pedimos el nuevo año
						System.out.print("Nuevo título: ");
						titulo = teclado.nextLine().trim();

						listaPeliculas.get(res).setTitulo(titulo);
						System.out.println("El título de la película: '" + titulo + "' ha sido modificado con éxito.");

						// Guardamos el cambio en el disco duro
						guardarLista();
					}
					break;

				case 4: // ELIMINAR PELÍCULA
					System.out.println("\n>> ELIMINAR PELÍCULA");
					System.out.print("Título de la película a eliminar: ");
					titulo = teclado.nextLine().trim();
					int res2 = buscarPelicula(titulo);

					if (res2 == -1) {
						System.out.println("No se ha encontrado la película '" + titulo + "'.");
					} else {
						listaPeliculas.remove(res2);
						System.out.println("La película '" + titulo + "' ha sido eliminada.");
						// Guardamos la lista actualizada
						guardarLista();
					}
					break;


				case 5: // Salir
					System.out.println("\nHasta luego Lucas...");
					break;
				default:
					System.out.println("\n>> Opción elegida no válida");
				}

			} while (opcion != 5);

			System.out.println("Felíz verano!!!");
			teclado.close();
		} catch (Exception e) {
			System.out.println("ERROR. Valor introducido no válido");
		}
	}
}