package ejemplos.menus;

import java.util.Scanner;

public class MenuBasicoMejoradoOperaciones {

	/**
	 * Procedimiento para mostrar un menú de 6 opciones
	 */
	public static void menu() {
		// mostramos el menu
		System.out.println("\n----- MENU -----");
		System.out.println("Elige una operación aritmética: ");
		System.out.println("1) Suma");
		System.out.println("2) Resta");
		System.out.println("3) Multiplicacion");
		System.out.println("4) Division");
		System.out.println("5) Potencia");
		System.out.println("6) Salir");
	}
	
	/**
	 * Función para calcular una potencia
	 * @param base - base de la potencia
	 * @param exponente - expoenete de la potencia
	 * @return la base elevada al exponente
	 */
	public static int potencia(int base, int exponente) {
		int res = 1;
		for (int i = 1; i <= exponente; i++)
			res *= base;
		return res;
	}
	
	// programa pricipal
	public static void main(String[] args) {
		
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		
		// control excepciones
		try {
			// declaramos opcion
			int opcion;
			
			// declaramos los operandos 
			int a, b;
			
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
						case 1: System.out.println("\nSUMA"); 
							// pedimos los operandos
							System.out.print("Dime el primer sumando: ");
							a = sc.nextInt();
							System.out.print("Dime el segundo sumando: ");
							b = sc.nextInt();
							// mostramos el resulado
							System.out.println(a+" + "+b+" = "+(a + b));
							break;
						case 2: System.out.println("\nRESTA"); 
						// pedimos los operandos
							System.out.print("Dime el minuendo: ");
							a = sc.nextInt();
							System.out.print("Dime el sustraendo: ");
							b = sc.nextInt();
							// mostramos el resulado
							System.out.println(a+" - "+b+" = "+(a - b));
							break;
						case 3: System.out.println("\nMULTIPLICACION"); 
							// pedimos los operandos
							System.out.print("Dime el multiplicando: ");
							a = sc.nextInt();
							System.out.print("Dime el multiplicador: ");
							b = sc.nextInt();
							// mostramos el resulado
							System.out.println(a+" x "+b+" = "+(a * b));
							break;
						case 4: System.out.println("\nDIVISION"); 
							// pedimos los operandos
							System.out.print("Dime el dividendo: ");
							a = sc.nextInt();
							System.out.print("Dime el divisor: ");
							b = sc.nextInt();
							// mostramos el resulado controlando el 0
							if (b != 0)
								System.out.println(a+" / "+b+" = "+((double)a / b));
							else
								System.out.println("No se puede dividir entre 0");
							
							break;
						case 5: System.out.println("\nPOTENCIA");
							// pedimos los operandos
							System.out.print("Dime el primer digito: ");
							a = sc.nextInt();
							System.out.print("Dime el segundo digito: ");
							b = sc.nextInt();
							// mostramos el resulado
							System.out.println(a+" elevado a "+b+" = "+potencia(a, b));
							break;
						case 6: System.out.println("Fin del programa...Bye bye!"); break;
						default : System.out.println(">> Opción elegida no válida"); break;
					}
				} while (opcion < 1 || opcion > 6);
				
			} while  (opcion != 6);
			
			
		} catch (Exception e) {
			System.err.println("ERROR. Dato no válido.");
			System.err.println("Fin del programa. Bye bye!");
		} finally {
			// cierre lector
			sc.close();
		}
		
	}

}
