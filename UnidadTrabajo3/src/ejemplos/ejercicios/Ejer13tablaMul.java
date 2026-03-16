package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer13tablaMul {
	
	/**
	 * Procedimiento para cálcular la tabla de multiplicar de un nº pasado por parámetro
	 * @param N - nº entero positivo
	 */
	public static void tabla(int N) {
		System.out.println(N+" X 1 : "+N*1);
		System.out.println(N+" X 2 : "+N*2);
		System.out.println(N+" X 3 : "+N*3);
		System.out.println(N+" X 4 : "+N*4);
		System.out.println(N+" X 5 : "+N*5);
		System.out.println(N+" X 6 : "+N*6);
		System.out.println(N+" X 7 : "+N*7);
		System.out.println(N+" X 8 : "+N*8);
		System.out.println(N+" X 9 : "+N*9);
		System.out.println(N+" X 10 : "+N*10);
	}
	public static void main(String[] args) {
		// Abrimos lector
		Scanner sc = new Scanner(System.in);
		// Control de excepciones
		try {
			// Pedimos un número por teclado
			System.out.print("Introduc un nº entero positivo: ");
			int num = sc.nextInt();
			// Llamamos programa
			tabla(num);
		} catch (Exception e) {
			System.err.println(">>> ERROR. Introduce un valor numérico.");
		}
		// Cerramos lector
		sc.close();
	}

}
