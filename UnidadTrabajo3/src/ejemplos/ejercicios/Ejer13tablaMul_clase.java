package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer13tablaMul_clase {

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
		try {
			// pedimos un valor entero
			System.out.print("Introduce un valor numérico entero positivo entre 1 y 10: ");
			// registramos el valor pedido por pantalla
			int num = sc.nextInt();
			// si el valor no esta entre 1 y 10 volvemos a pedirlo
			while (num < 1 || num > 10) {
				System.out.print("Introduce un valor numérico entero positivo entre 1 y 10: ");
				// registramos el valor pedido por pantalla
				num = sc.nextInt();
			}
			
			// llamada del programa
			tabla(num);
		} catch (Exception e) {
			System.err.println("Introduce un valor numérico entero positivo.");
		}
		// cerramos lector
		sc.close();
	}

}
