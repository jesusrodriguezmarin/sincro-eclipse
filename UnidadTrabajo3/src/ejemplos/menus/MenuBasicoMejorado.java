package ejemplos.menus;

import java.util.Scanner;

public class MenuBasicoMejorado {

	/**
	 * Procedimiento para mostrar un menú de 4 opciones
	 */
	public static void menu() {
		// mostramos el menu
		System.out.println("\n----- MENU -----");
		System.out.println("1) Opcion 1");
		System.out.println("2) Opcion 2");
		System.out.println("3) Opcion 3");
		System.out.println("4) Salir");
	}
	public static void main(String[] args) {
		
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		
		// control excepciones
		try {
			// declaramos opcion
			int opcion;
			
			do {
				// mostramos menu de 
				// llamado del procedimiento
				menu();
				
				do {
					// leemos la opcion que elige el usuario
					System.out.print("Elige una opción: ");
					opcion = sc.nextInt();
					
					// ejecutamos la opcion elegida por el usuario
					switch(opcion) {
						case 1: System.out.println("Has elegido la opción 1"); break;
						case 2: System.out.println("Has elegido la opción 2"); break;
						case 3: System.out.println("Has elegido la opción 3"); break;
						case 4: System.out.println("Fin del programa...Bye bye!"); break;
						default : System.out.println(">> Opción elegida no válida"); break;
					}
				} while (opcion < 1 || opcion > 4);
				
			} while  (opcion != 4);
			
			
		} catch (Exception e) {
			System.err.println("ERROR. Dato no válido.");
			System.err.println("Fin del programa. Bye bye!");
		} finally {
			// cierre lector
			sc.close();
		}
		
	}

}
