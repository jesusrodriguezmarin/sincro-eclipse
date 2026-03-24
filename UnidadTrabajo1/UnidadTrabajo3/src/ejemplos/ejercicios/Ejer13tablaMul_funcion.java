package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer13tablaMul_funcion {
	/**
	 * Programa que devuelve la tabla de multiplicar de un nº pasado por parámetro
	 * @param N - nº entero positivo
	 */
	public static void tabla (int N) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(N+" X "+i+" : "+(N*i));
		}
			
	}
	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		// control
		try {
			// solicitamos un nº por teclado
			System.out.print("Introduce un nº entero positivo: ");
			int num = sc.nextInt();
			tabla(num);
		} catch (Exception e) {
			System.err.println("ERROR");
		}
		// cierre lector
		sc.close();
	}

}
