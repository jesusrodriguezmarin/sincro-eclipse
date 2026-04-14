package ficheros.repaso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class AgendaRepaso {

	// Constante para añadir el fichero
	final static String FICHERO = "C:/BD/agendaNueva.txt";
	
	/**
	 * Procedimiento que muestra por pantalla un menú de opciones
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
	 * Procedimiento que escribe un contacto en la agenda
	 * @param nombre - {String} a guardar
	 * @param numero - {int} a guardar
	 */
	private static void add(String nombre, int numero) {
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(FICHERO, true);
			pw = new PrintWriter(fw);
			
			pw.println(nombre+" > "+numero);
			
		} catch (Exception e) {
			System.out.println("Se ha producido un error.");
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (Exception e2) {
				System.out.println("Error en el cierre del archivo");
			}
		}
	}
	
	/**
	 * Procedimiento que muestra el contenido de la agenda
	 */
	private static void listar() {
		File f = new File(FICHERO);
		
		try {
			Scanner s = new Scanner(f);
			String linea;
			int conta = 0;
			
			while (s.hasNextLine()) {
				linea = s.nextLine();
				conta++;
				System.out.println(linea);
			}
			
			if (conta == 0) {
				System.out.println("La agenda está vacía.");
			}
			s.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error. Agenda vacía.");
		}
	}

	/**
	 * Función que devuelve el numero del contacto pasado por parámetro
	 * @param nombre {String} a buscar
	 * @return {int} número de telefono
	 */
	private static int buscar(String nombre) {
		int res = 0;
		File f = new File(FICHERO);
		boolean encontrado = false;
		
		try {
			Scanner s = new Scanner(f);
			String linea;
			
			while (s.hasNextLine() && !encontrado){
				linea = s.nextLine();
				
				String nomAgenda = linea.substring(0, linea.indexOf(">")).trim();
				String numAgenda = linea.substring(linea.indexOf(">")+1).trim();
				
				if (nomAgenda.compareToIgnoreCase(nombre) == 0) {
					encontrado = true;
					
					res = Integer.parseInt(numAgenda);
				}
			}
			s.close();
			
		} catch (Exception e) {
			return 0;
		}
		
		return res;
	}
	
	// Programa principal
	public static void main(String[] args) {

		// Pedimos un número por teclado para seleccionar en menú
		Scanner sc = new Scanner(System.in);

		// Variables para solicitar por teclado
		int opcion;
		String nombre;
		int telefono;

		// Control de excepciones
		try {
			// Mostramos el menú
			do {
				menu();
				do {
					System.out.print("Selecciona una opción: ");
					opcion = Integer.parseInt(sc.nextLine());
					
					switch (opcion) {
					case 1:	// Añadir contacto
						System.out.println("> NUEVO CONTACTO:");
						System.out.print("Introduce tu nombre: ");
						nombre = sc.nextLine().trim();
						
						
						System.out.print("Introduce tu número: ");
						telefono = Integer.parseInt(sc.nextLine());
						
						// Llamamos al método add para guardar los nombres solicitados
						add(nombre, telefono);

						break;
					case 2:	// Listar contacto
						System.out.println("> CONTACTOS: ");
						listar();
						

						break;
					case 3:	// Buscar contacto
						System.out.println("> BUSCAR CONTACTO:");
						System.out.print("Nombre: ");
						
						

						break;
					case 4:	// Salir
						System.out.println(" > Bye, Bye!. Fin del programa");

						break;

					default: System.out.println(" > Opción elegida no válida.");
						break;
					}
				} while (opcion < 1 || opcion > 4);
			} while (opcion != 4);
			
			System.out.println("Hasta pronto!");
			sc.close();

		} catch (Exception e) {
			System.out.println("Error. Dato no válido.");
		}

	}

}
