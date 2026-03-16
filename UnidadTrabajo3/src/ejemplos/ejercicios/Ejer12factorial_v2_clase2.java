package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer12factorial_v2_clase2 {
	
	/**
	 * funcion recursiva que calcula el factorial de un nº enterio positivo
	 * @param n - nº enterio positivo
	 * @return factorial de un nº entero positivo
	 */
	private static int fact(int n) {
		if (n == 1)
			return 1;
		else {
			return n*fact(n-1);
		}
	}
	
	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		// control
		try {
			// declaramos variable para pedir en el bucle
			int num;
			
			// bucle do while para pedir un nº positivo tantas veces necesarias y procesrar				
			// si el nº es positivo imprimimos el factorial
			do {
				System.out.print("Introduce un nº entero positivo: ");
				num = sc.nextInt();
				if (num <= 0) {
					System.out.println("El nº no es positivo.");
				}
			} while (num <= 0);
			
			// al salir del bucle imprime esto
			System.out.println("Factorial("+num+") es: "+fact(num));
			
			
		} catch (Exception e) {
			System.err.println(">>> ERROR. Introduce un valor entero");
		}	
		// cierre de lector
		sc.close();
	}

}
