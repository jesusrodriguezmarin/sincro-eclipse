package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer28primo {

	/**
	 * Funcion que devuelve si un nº entero es o no primo
	 * Un nº primo es un nº que tiene 
	 * unicamente por divisores el 1 y el propio nº
	 * @param N - nº entero
	 * @return TRUE si N es nº primo y FALSE si no lo es
	 */
	public static boolean esPrimo(int N) {
		if (N <= 1)
			return false;
		else {
			// recorremos los posibles divisores (hasta la mitad)
			for (int i = 2; i <= N/2; i++) {
				if (N % i == 0)
					return false;
			}
			return true;
		}
		
	}
	
	// Programa principal
	public static void main(String[] args) {
		try {
			// Leemos un nº entero
			Scanner sc = new Scanner(System.in);
			System.out.print("Introduce un nº entero: ");
			int num = sc.nextInt();
			sc.close();
			
			// llamamos la función
			System.out.println(esPrimo(num));
			
			// tambien lo ponemos asi
			if (esPrimo(num) == true) {
				System.out.println(num+" es primo.");
			} else {
				System.out.println(num+" no es primo.");
			}
			
		} catch (Exception e) {
			System.err.println("ERROR");
		}

	}

}
