package ficheros.ejemplos;

import java.util.Scanner;

public class Agenda {
	
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
	 * Programa principal
	 */
	public static void main(String[] args) {
		try {
			// Variables
			int opcion;			// Opci�n del men� elegida por el usuario
			String nombre;		// Nombre del contacto
			int telefono;		// Tel�fono del contacto
			
			Scanner teclado = new Scanner(System.in);
			
			do {
				menu();				
				do {
					System.out.print("Elige una opci�n: ");
					opcion=Integer.parseInt(teclado.nextLine());				
					switch (opcion) {
						case 1: // A�ADIR CONTACTO
								System.out.println("\n>> NUEVO CONTACTO");
								// Pedimos el nombre del contacto a a�adir
								// Comprobamos si el contacto ya se encuentra en la agenda				
								// Pedimos el tel�fono del contacto a a�adir
								break;
								
						case 2: // LISTAR CONTACTO
								System.out.println("\n>> CONTACTOS");
								break;							
							
						case 3: // BUSCAR CONTACTO	
							    System.out.println("\n>> BUSCAR CONTACTO");
						 		// Pedimos el nombre del contacto a buscar
								break;					
								
						case 4: // Salir
								System.out.println("Bye bye"); break;
						default: System.out.println("\n>> Opci�n elegida no v�lida");
					}
				} while (opcion<1 || opcion>4);				
			} while (opcion!=4);			
			
			System.out.println("Que tengas un buen d�a...");
			teclado.close();
		} catch (Exception e) {
			System.out.println("ERROR. Valor introducido no v�lido");
		}
	}
}
