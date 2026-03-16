package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer20paresMenorMayor {

	/**
	 * Procedimiento que imprime por pantalla los númeroos entre a y b
	 * Requisito: a debe ser menor que b
	 * @param a - entero positivo
	 * @param b - entero positivo debe ser menor que a
	 */
	public static void imprimir (int a, int b) {
		for (int i = a; i <= b; i++) {
			if (i % 2 == 0)
				System.out.println(i+" ");
		}
	}
	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		// control de excepciones
		try {
			int num1;
			// 1. leer un primer nº positivo obligadamente
			do {	
				System.out.print("Introduce un primer nº entero positivo: ");
				num1 = sc.nextInt();
			} while (num1 <= 0);
		
			// 2. leer un segundo nº positivo obligadamente
			int num2;
			// leer un primer nº positivo obligadamente
			do {	
				System.out.print("Introduce un segundo nº entero positivo: ");
				num2 = sc.nextInt();
			} while (num2 <= 0);
			
			// 3. mostrar por pantalla los nºs comprendidos de manera ascendete
			if (num1 < num2) {
					imprimir(num1, num2);
			} else {
					imprimir(num2, num1);
			}
			
		} catch (Exception e) {
			System.err.println(">> ERROR!!!");
			System.err.println("No es un nº entero positivo.");	
		}
		// cierre lector
		sc.close();

	} 

}
