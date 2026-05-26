package ejemplos.mac.wordlist;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionWordlist {

	// Ruta del fichero adaptada para el diccionario de traducción
	private static final String FICHERO = "/Users/jesusrodriguezmarin/Documents/BDeclipse/wordlist.dat";

	// Lista que utilizamos para cargar en memoria los términos almacenados como variable global
	private static ArrayList<Wordlist> listaPalabras;

	// --- MÉTODOS ---

	/**
	 * Recupera del fichero la lista de palabras
	 */
	@SuppressWarnings("unchecked")
	public static void leerLista() {
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO));

			// Volcamos los datos directamente en nuestra variable global
			listaPalabras = (ArrayList<Wordlist>) entrada.readObject();
			entrada.close();

		} catch (Exception e) {
			System.out.println(">> Se ha producido un error: " + e.getMessage());
		}
	}

	/**
	 * Guarda el fichero en la lista de palabras
	 */
	public static void guardarLista() {
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO));

			// Forzamos el limpiado del caché antes de escribir
			salida.reset();

			salida.writeObject(listaPalabras);
			salida.close();
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error al guardar: " + e.getMessage());
		}
	}

	/**
	 * Método que comprueba si la palabra en español está ya en la lista
	 */
	public static int buscarPalabra(String espanol) {
		// Recorremos la lista buscando por el término original en español
		for (int i = 0; i < listaPalabras.size(); i++) {
			if (listaPalabras.get(i).getEspanol().equalsIgnoreCase(espanol.trim())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Método para añadir un nuevo par de traducción en la lista
	 */
	public static void añadirPalabra(String espanol, String traducida) {
		// Añadimos un nuevo objeto Wordlist
		listaPalabras.add(new Wordlist(espanol, traducida));
	}

	/**
	 * Procedimiento que muestra por pantalla un menú de operaciones
	 */
	private static void menu() {
		System.out.println("\n****************************");
		System.out.println("* GESTIÓN DE WORDLIST      *");
		System.out.println("* 1) Añadir traducción     *");
		System.out.println("* 2) Mostrar wordlist      *");
		System.out.println("* 3) Modificar traducción  *");
		System.out.println("* 4) Eliminar traducción   *");
		System.out.println("* 5) Buscar una traducción *");
		System.out.println("* 6) Salir                 *");
		System.out.println("****************************");
	}

	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Variables adaptadas al caso de Wordlist de Traducción
		int opcion;           // Opción del menú elegida por el usuario
		String espanol;       // Palabra original en español (Clave única de búsqueda)
		String traducida;     // Equivalente traducido de la palabra

		// Crea la lista que tenemos declarada fuera del main
		listaPalabras = new ArrayList<>();

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

				case 1: // AÑADIR TRADUCCIÓN
					System.out.println("\n>> AÑADIR TRADUCCIÓN");
					System.out.print("Introduce la palabra en español: ");
					espanol = teclado.nextLine().trim();

					// Comprobamos si la palabra ya tiene una traducción registrada
					if (buscarPalabra(espanol) != -1) {
						System.out.println("La palabra '" + espanol + "' ya se encuentra registrada en la wordlist.");
					} else {
						// Pedimos el término traducido correspondiente
						System.out.print("Introduce la palabra traducida: ");
						traducida = teclado.nextLine().trim();
						
						añadirPalabra(espanol, traducida);

						// Guardamos la lista en el fichero wordlist.dat
						guardarLista();
					}
					break;

				case 2: // LISTAR WORDLIST
					System.out.println("\n>> MOSTRAR WORDLIST");

					// Si la lista está vacía informamos
					if (listaPalabras.size() == 0) {
						System.out.println("La wordlist está vacía.");
					} else {
						// Mostramos los objetos almacenados
						for (int i = 0; i < listaPalabras.size(); i++) {
							System.out.println(listaPalabras.get(i));
						}
					}
					break;

				case 3: // MODIFICAR TRADUCCIÓN
					System.out.println("\n>> MODIFICAR TRADUCCIÓN");
					System.out.print("Introduce la palabra en español a modificar: ");
					espanol = teclado.nextLine().trim();

					// Obtenemos el resultado de existencia para filtrar en el condicional
					int res = buscarPalabra(espanol);

					// Controlamos si se encuentra
					if (res == -1) {
						System.out.println("No se ha encontrado la palabra '" + espanol + "'.");
					} else {
						// Pedimos la nueva palabra traducida
						System.out.print("Introduce la NUEVA palabra traducida: ");
						traducida = teclado.nextLine().trim();

						listaPalabras.get(res).setTraducida(traducida);
						System.out.println("La traducción de '" + espanol + "' ha sido modificada con éxito.");

						// Guardamos el cambio en el disco duro
						guardarLista();
					}
					break;

				case 4: // ELIMINAR TRADUCCIÓN
					System.out.println("\n>> ELIMINAR TRADUCCIÓN");
					System.out.print("Palabra en español a eliminar: ");
					espanol = teclado.nextLine().trim();
					int res2 = buscarPalabra(espanol);

					if (res2 == -1) {
						System.out.println("No se ha encontrado la palabra '" + espanol + "'.");
					} else {
						listaPalabras.remove(res2);
						System.out.println("La traducción de '" + espanol + "' ha sido eliminada de la wordlist.");
						// Guardamos la lista actualizada
						guardarLista();
					}
					break;

				case 5: // BUSCAR UNA TRADUCCIÓN
					System.out.println("\n>> BUSCAR UNA TRADUCCIÓN");
					System.out.print("Introduce la palabra en español a buscar: ");
					espanol = teclado.nextLine().trim();
					
					// Obtenemos la posición usando el método de búsqueda
					int res3 = buscarPalabra(espanol);
					
					if (res3 == -1) {
						System.out.println("No se ha encontrado la palabra '" + espanol + "'.");
					} else {
						// Mostramos los datos del objeto encontrado accediendo a su posición
						System.out.println("Traducción encontrada: " + listaPalabras.get(res3));
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