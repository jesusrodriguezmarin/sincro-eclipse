package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer12factorial_v2 {

	/**
	 * Función que calcula el factorial de un número pasado por parámetro
	 * @param N - nº entero positivo
	 * @return el nº factorial de un nº entero positivo
	 */
	public static int factorial(int N) {
		int res = 1;
		for (int i = 1; i <= N; i++) {
			res *= i;
		} return res;
	}
	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		// control de excepciones
		try {
			// pedimos núm por teclado
			System.out.print("Introduce un nº entero positivo: ");
			int num = sc.nextInt();
			// bucle para atrapar al usuario
			while (num <= 0) {
			System.out.println(num+" no es un nº positivo.");
			System.out.print("Introduce un nº entero positivo: ");
			num = sc.nextInt();
			} 
			System.out.println("El factorial de ("+num+") es: "+factorial(num));
		} catch (Exception e) {
			System.err.println(">>> ERROR: Introduce un valor entero positivo.");
		}
		// cierre de lector
		sc.close();
	}

}
