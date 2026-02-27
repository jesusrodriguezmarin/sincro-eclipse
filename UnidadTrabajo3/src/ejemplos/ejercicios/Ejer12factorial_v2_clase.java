package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer12factorial_v2_clase {

	/**
	 * Funcion que calcula el factorial de un nº entero positivo
	 * @param n - nº enterio positivo
	 * @return factorial de un nº entero positivo
	 */
	private static int factorial(int n) {
		int resultado = 1;
		for (int i = 1; i <= n; i++)
			resultado*= i;
		return resultado;
	}
	
	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		// control
		try {
			// Pedimos un número por pantalla
			System.out.print("Introduce un valor entero positivo: ");
			int num = sc.nextInt();
			
			// Condicional para corregir el fallo, informar que el nº no es positivo
			if (num <= 0) {
				System.out.println("No has introducido un valor positivo!");
				while (num <= 0) {
				System.out.print("Introduce un valor entero positivo: ");
				num = sc.nextInt();
				}
			} else {
				// si el nº es positivo imprimimos el factorial
				System.out.println("Factorial("+num+") es: "+factorial(num));
			}
			
		} catch (Exception e) {
			System.err.println(">>> ERROR. Introduce un valor entero");
		}	
		// cierre de lector
		sc.close();
	}

}
