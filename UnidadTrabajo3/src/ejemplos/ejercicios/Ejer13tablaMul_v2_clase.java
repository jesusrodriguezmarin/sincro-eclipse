package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer13tablaMul_v2_clase {

	/**
	 * Programa que calcula la tabla de multiplicar de un nº pasadp por parámetro
	 * @param N - nº entero positivo
	 */
	public static void tabla (int N) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(N+" x "+i+" : "+(N*i));
		}
	}
	
	// Programa principal
	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		// control
		try {
			int num;
			do {
				System.out.print("Introduce un valor entre 1 y 10: ");
				num = sc.nextInt();
			} while (num < 1 || num > 10);
			
			// llamada del programa
			tabla(num);
		} catch (Exception e) {
			System.err.println("Introduce un valor numérico entero positivo.");
		}
		// cerramos lector
		sc.close();
	}

}
