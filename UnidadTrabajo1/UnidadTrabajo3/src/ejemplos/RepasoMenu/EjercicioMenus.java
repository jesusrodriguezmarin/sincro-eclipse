package ejemplos.RepasoMenu;

import java.util.Scanner;

public class EjercicioMenus {

	/**
	 * Procedimiento para mostrar un menú de 6 opciones
	 */
	public static void menu() {
		// mostramos el menu
		System.out.println("\n----- MENU -----");
		System.out.println("Elige una opción: ");
		System.out.println("1) Introducir un número N");
		System.out.println("2) Mostrar el número introducido N");
		System.out.println("3) Contar desde 1 hasta N");
		System.out.println("4) Mostrar los divisores de N");
		System.out.println("5) Mostrar la tabla de multiplicar de N");
		System.out.println("6) Salir");
	}
	
	/**
	 * Procedimiento para contar desde 1 hasta un número introducido
	 * @param N - número introducido por parámetro
	 */
	public static void contar(int N) {
		for (int i = 1; i <= N; i++)
			System.out.print(i+" ");
	}
	
	/**
	 * Procedimiento para multiplicar un nº 
	 * @param N - nº introducido para multiplicar
	 */
	public static void tablaMul(int N) {
		for (int i = 1; i <= 10; i++)
			System.out.println(N+" x "+i+" = "+(N * i));
	}
	
	/**
	 * procedimiento para calcular los divisores de un número
	 * @param N - el número del que se muestran los divisores
	 */
	public static void divisores(int N) {
		for (int i = 1; i <= N; i++)
			if (N % i == 0)
				System.out.print(i+" ");
	}
	
	// programa princial
	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		// control
		try {
			// declaramos la opcion para el switch
			int opcion;
			
			// declaramos N para pedir al usuario
			int N = 0;
			
			// declaramos variable para cuando N sea introducido
			boolean introducido;
			
			introducido = false; // false mientras no se haya introducido N 
			
			do {
				// mostramos menú mientras no se introduzca opcion 6) salir
				menu();
				
				// leemos opcion mientras sea menor que 0
				do {
					// leemos la opcion que elige el usuario
					System.out.print("Elige una opción: ");
					opcion = sc.nextInt();
					
					// ejecutamos la opcion elegida por el usuario
					switch(opcion) {
						case 1: // pedimos el nº N hasta que N sea un nº entero positivo
							do {
								System.out.print("Dime un número entero positivo: ");
								N = sc.nextInt();
								if (N <= 0)
									System.out.println(">> Debe ser un nº entero positivo.");
							} while (N <= 0);
							introducido = true;
							break;
						case 2: // mostramos el nº N 
							if (introducido)
								System.out.print("\nEl valor introducido es: "+N);
							else
								System.out.println("\nPrimero debes introducir el valor de N.");
							break;
						case 3: // contamos desde 1 hasta N					
							if (introducido)
								contar(N);
							else
								System.out.println("\nPrimero debes introducir el valor de N.");	
							break;
						case 4: // mostramos sus divisores de N
							if (introducido)
								divisores(N);
							else
								System.out.println("\nPrimero debes introducir el valor de N.");
							break;
						case 5: // tabla de multiplicar de N
							if (introducido)
								tablaMul(N);
							else
								System.out.println("\nPrimero debes introducir el valor de N.");
							break;
						case 6: System.out.println("Fin del programa...Bye bye!"); break;
						default : System.out.println(">> Opción elegida no válida"); break;
					}
				} while (opcion < 0);
				
			} while (opcion != 6);
			
			
			
		} catch (Exception e) {
			System.err.println(">> ERROR. Tipo de dato no válido.");
		} finally {
			// cierre lector
			sc.close();
		}
		
	}

}
