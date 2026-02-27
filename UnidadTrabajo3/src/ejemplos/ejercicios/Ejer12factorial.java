package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer12factorial {

	/**
	 * Función que devuelve el nº factorial de un nº entero positivo pasado por parámetro
	 * @param N - nº entero positivo
	 * @return el nº factorial de un número entero positivo
	 */
	public static int factorial(int N) {
		int res = 1;
		for (int i = 1; i <= N; i++) {
			res *= i;
		} return res;
	}
	public static void main(String[] args) {
		// control de excepciones
		try {
			// lector
			Scanner sc = new Scanner(System.in);
			// pedimos núm por teclado
			System.out.print("Introduce un nº entero positivo: ");
			int num = sc.nextInt();
			// condicional
			if (num > 0) {
			// imprime resultado
			System.out.println("El factorial de ("+num+") es: "+factorial(num));
			} else {
				System.out.println(num+" no es un nº positivo");
			}
			// cierre de lector
			sc.close();
		} catch (Exception e) {
			System.err.println(">>> ERROR: Introduce un valor entero positivo.");
		}

	}

}
