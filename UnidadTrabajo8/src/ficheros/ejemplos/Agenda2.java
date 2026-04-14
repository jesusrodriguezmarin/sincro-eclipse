package ficheros.ejemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Agenda2 {

	// Constante para albergar el fichero
	final static String FICHERO = "C:/BD/miAgenda.txt";

	/**
	 * Procedimiento que muestra por pantalla un men� de operaciones
	 */
	private static void menu() {
		System.out.println("\n****************************");
		System.out.println("*  AGENDA TELEFONICA       *");
		System.out.println("*   1) Nuevo contacto      *");
		System.out.println("*   2) Listar contactos    *");
		System.out.println("*   3) Buscar contacto     *");
		System.out.println("*   4) Salir               *");
		System.out.println("****************************");
	}

	/**
	 * Muestra el contenido de la agenda
	 */
	private static void listarContacto() {
		// Creamos un objeto de la clase File
		File f = new File(FICHERO);

		try {
			// Leemos un archivo linea a línea
			Scanner sc = new Scanner(f);
			String linea;
			int conta = 0;

			// Mientras haya líneas en el fichero
			while (sc.hasNextLine()) {

				// la leemos
				linea = sc.nextLine();
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
		// Creamos un FileWriter
		FileWriter fw = null;

		// Creamos un PrintWriter
		PrintWriter pw = null;

		try {
			// Si el archivo no existe lo crea
			fw = new FileWriter(FICHERO, true);
			pw = new PrintWriter(fw);

			// Escritura de un fichero
			pw.println(nombre + " > " + telefono);

		} catch (Exception e1) {
			System.err.println("Se ha producido un error en el archivo del fichero.");
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (Exception e2) {
				System.err.println("Error en el cierre del archivo.");
			}
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

				// Comprobamos
				String nomAgenda = linea.substring(0, linea.indexOf('>')).trim();
				if (nomAgenda.compareToIgnoreCase(nombre) == 0) {
					String tlf = linea.substring(linea.indexOf('>') + 1).trim();
					encontrado = true;

					// Asignamos el telefono a res
					res = Integer.parseInt(tlf);
				}
			}
			s.close();
			
		} catch (FileNotFoundException e) {
			return 0;
		}
		return res;
	}

	/**
	 * Programa principal
	 */
	public static void main(String[] args) {
		try {
			// Variables
			int opcion; // Opci�n del men� elegida por el usuario
			String nombre; // Nombre del contacto
			int telefono; // Tel�fono del contacto

			// Teclado 
			Scanner teclado = new Scanner(System.in);

			do {
				menu();
				do {
					System.out.print("Elige una opci�n: ");
					opcion = Integer.parseInt(teclado.nextLine());
					
					switch (opcion) {
					case 1: // A�ADIR CONTACTO
						System.out.println("\n>> NUEVO CONTACTO");
						// Pedimos el nombre del contacto a a�adir
						System.out.print(">> Nombre: ");
						nombre = teclado.nextLine().trim();

						// Comprobamos si el contacto ya se encuentra en la agenda
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
							System.out.println("Telefono: "+res);
						
						break;

					case 4: // Salir
						System.out.println("Bye bye");
						break;
					default:
						System.out.println("\n>> Opci�n elegida no v�lida");
					}
				} while (opcion < 1 || opcion > 4);
			} while (opcion != 4);

			System.out.println("Que tengas un buen d�a...");
			teclado.close();
			
		} catch (Exception e) {
			System.out.println("ERROR. Valor introducido no v�lido");
		}
	}
}
