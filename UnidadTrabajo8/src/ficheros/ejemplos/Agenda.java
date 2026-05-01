package ficheros.ejemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Agenda {

	// Constante para albergar el fichero
	final static String FICHERO = "/Users/jesusrodriguezmarin/Documents/ficherosEclipse/MiAgenda.txt";
	final static String AUX = "/Users/jesusrodriguezmarin/Documents/ficherosEclipse/MiAgendaAux.txt";

	/**
	 * Procedimiento que muestra por pantalla un men� de operaciones
	 */
	private static void menu() {
		System.out.println("\n****************************");
		System.out.println("*                          *");
		System.out.println("*   AGENDA TELEFONICA      *");
		System.out.println("*   1) Nuevo contacto      *");
		System.out.println("*   2) Listar contactos    *");
		System.out.println("*   3) Buscar contacto     *");
		System.out.println("*   4) Eliminar contacto   *");
		System.out.println("*   5) Salir               *");
		System.out.println("*                          *");
		System.out.println("****************************");
	}

	/**
	 * Muestra el contenido de la agenda
	 */
	private static void listarContacto() {
		// Creamos un objeto de la clase File
		File f = new File(FICHERO);

		try {
			// Leemos el archivo linea a línea
			Scanner sc = new Scanner(f);

			// Declaramos una variable para leer la línea
			String linea;

			// Contador para mostrar mensaje si estña vacío
			int conta = 0;

			// Mientras haya líneas en el fichero
			while (sc.hasNextLine()) {

				// la leemos
				linea = sc.nextLine();

				// Incrementamos el contador
				conta++;

				// la mostramos
				System.out.println(linea);
			}
			sc.close();
			if (conta == 0)
				System.out.println("La agenda está vacía");

		} catch (FileNotFoundException x) {
			System.err.println("Error: agenda vacía.");
		}
	}

	/**
	 * Procedimiento que añade un contacto a la agenda
	 * 
	 * @param nombre
	 * @param telefono
	 */
	private static void addContacto(String nombre, int telefono) {
		// Creamos un FileWriter para escribir en un archivo
		FileWriter fw = null;

		// Creamos un PrintWriter
		PrintWriter pw = null;

		// Control de excepciones
		try {
			// Si el archivo no existe lo crea, usamos true para que no sobreescriba
			fw = new FileWriter(FICHERO, true);
			// Nos ayudamos de PrintWriter para usar métodos que no tiene FileWriter
			pw = new PrintWriter(fw);

			// Escritura de un fichero, método de PrintWriter
			pw.println(nombre + " > " + telefono);

		} catch (Exception e1) {
			System.err.println("Se ha producido un error en el archivo del fichero.");
		} finally {
			// Control de excepciones
			try {
				// Si el archivo se ha escrito podemos cerrarlo
				if (fw != null) {
					fw.close();
				}
			} catch (Exception e2) {
				System.err.println("Error en el cierre del archivo.");
			}
		}
	}

	/**
	 * Procedimiento que elimina un contacto de la agenda
	 * 
	 * @param nombre - contacto a eliminar
	 */
	public static void borrarContacto(String nombreBorrar) {

		// Creamos un objeto sobre el fichero original
		File original = new File(FICHERO);

		// Creamos un objeto con un fichero auxiliar
		File auxiliar = new File(AUX);

		// Declaramos un escritor PrintWriter
		PrintWriter escritor = null;

		// Control de errores para inicializar los objetos
		try {
			// Leemos el original
			Scanner sc = new Scanner(original);

			// Inicializamos el PrinWriter
			escritor = new PrintWriter(new FileWriter(auxiliar));

			// Escribimos con condición de excepción
			while (sc.hasNextLine()) {

				// Capturamos la línea
				String linea = sc.nextLine().trim();
				String upper = linea.toUpperCase();

				// Condicionamos
				if (!upper.contains(nombreBorrar.toUpperCase())) {
					escritor.println(linea);
				}
			}
			// Cerramos lector y escritor
			sc.close();
			escritor.close();

			// Intercambiamos archivos
			original.delete();
			auxiliar.renameTo(original);

		} catch (Exception e) {
			System.err.println("Error en el proceso de borrado.");
		}

	}

	/**
	 * Busca un contacto en una agenda por su nombre
	 * 
	 * @param nombre a buscar
	 * @return {int} el telefono del contacto
	 */
	private static int buscarContacto(String nombre) {
		int res = 0;

		File f = new File(FICHERO);

		// Declaramos una variable para encontrar
		boolean encontrado = false;

		try {
			// Creamos scanner
			Scanner s = new Scanner(f);
			String linea;

			while (s.hasNextLine() && !encontrado) {
				linea = s.nextLine();

				// Separamos en la línea solo la primera parte referente al nombre
				String nomAgenda = linea.substring(0, linea.indexOf('>')).trim();

				// Comparamos el nombre de la línea extraido con el nombre introducido
				if (nomAgenda.compareToIgnoreCase(nombre) == 0) {

					// Extraemos el teléfono de la línea
					String tlf = linea.substring(linea.indexOf('>') + 1).trim();
					encontrado = true;

					// Convertimos el teléfono a int y guardamos en la variable res
					res = Integer.parseInt(tlf);
				}
			}
			s.close();

		} catch (FileNotFoundException e) {
			return 0;
		}
		// Devuelve el teléfono encontrado
		return res;
	}

	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Control de errores
		try {
			// Variables
			int opcion; // Opci�n del men� elegida por el usuario
			String nombre; // Nombre del contacto
			int telefono; // Tel�fono del contacto

			// Teclado
			Scanner teclado = new Scanner(System.in);

			do {
				// Mostramos el menú de información
				menu();
				do {
					System.out.print("\nElige una opci�n: ");
					opcion = Integer.parseInt(teclado.nextLine().trim());

					// Filtramos la opción elegida
					switch (opcion) {
					case 1: // A�ADIR CONTACTO
						System.out.println("\n>> NUEVO CONTACTO");

						// Pedimos el nombre del contacto a a�adir
						System.out.print(">> Nombre: ");
						nombre = teclado.nextLine().trim();

						// Comprobamos si el contacto ya se encuentra en la agenda
						// Si el contacto no existe es 0
						if (buscarContacto(nombre) != 0) {
							System.out.println("El contacto está en la agenda.");
						} else {
							// Pedimos el tel�fono del contacto a a�adir
							System.out.print(">> Teléfono: ");
							telefono = Integer.parseInt(teclado.nextLine().trim());

							// Añadimos el contacto al fichero
							addContacto(nombre, telefono);
						}
						break;

					case 2: // LISTAR CONTACTO
						System.out.println("\n>> CONTACTOS");
						listarContacto();
						break;

					case 3: // BUSCAR CONTACTO
						System.out.println("\n>> BUSCAR CONTACTO");

						// Pedimos el nombre del contacto a buscar
						System.out.print("> Nombre: ");
						String nom = teclado.nextLine().trim();
						int res = buscarContacto(nom);

						if (res == 0)
							System.out.println("No se ha encontrado.");
						else
							System.out.println("Telefono: " + res);
						break;

					case 4: // ELIMINAR CONTACTO
						System.out.println("\n>> ELIMINAR CONTACTO");

						// Pedimos el nombre del contacto a eliminar
						System.out.print("> Nombre: ");
						nombre = teclado.nextLine().trim();
						int existe = buscarContacto(nombre);

						// Comprobamos si existe
						if (existe != 0) {
							borrarContacto(nombre);
							System.out.println("Contacto eliminado.");
						} else {
							System.out.println("Contacto no existente.");
						}

						break;

					case 5: // Salir
						System.out.println("Bye bye");
						break;
					default:
						System.out.println("\n>> Opci�n elegida no v�lida");
					}
				} while (opcion < 1 || opcion > 5);
			} while (opcion != 5);

			System.out.println("\nQue tengas un buen d�a...");
			teclado.close();

		} catch (Exception e) {
			System.out.println("ERROR. Valor introducido no v�lido");
		}
	}
}
