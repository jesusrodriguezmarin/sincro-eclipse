package ejemploBoletinUt3;

import java.util.Scanner;



public class Ejer3 {

	/**
	 * función para calcular el factorial de un nº
	 * @param N - nº para calcular
	 * @return
	 */
	public static int factorial(int N) {
		int res = 1;
		for (int i = 1; i <= N; i++) {
			res *= i;
		} return res;
	}
	
	/**
	 * Función que devuelve el mayor divisor de un nº entero
	 * siendo este distinto del propio nº
	 * @param N - un nº entero
	 * @return el mayor divisor de N
	 */
	public static int mayordiv (int N) {
		// convierto N en valor absoluto num
		int num = Math.abs(N);
		
		// inicializo div a 1 porque es el mayor divisor conocido hasta ahora
		int div = 1;
		
		// uso num en vez de N
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0)
				div = i;
		} 
		return div;
	}
	
	// programa pricipal
	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		// control de excepciones
		try {
			// declarcacion de variable para pedir nº
			int num;
			
			// pedimos nota acotando entre 0 y 10
			do {
			System.out.print("Dime un número: ");
			num = sc.nextInt();
				// mostramos mensaje de error
				if (num < 1 || num > 10)
					System.out.println(">> El número introducido no se encuentra entre 1 y 10");
				// salto de linea
				System.out.println();
			} while (num < 1 || num > 10);
			
			// comprobar si es par
			if (num % 2 == 0)
				System.out.println("> "+num+" es PAR.");
			else
				System.out.println("> "+num+" es IMPAR.");
			
			// llamamos a la funcion de factorial
			System.out.println("> "+num+"! = "+factorial(num));
			
			// llamamos a la función de mayor divisor
			System.out.println("> Mayor divisor de "+num+": "+mayordiv(num));
			
			
			
			
			
		} catch (Exception e) {
			System.err.println(">> ERROR. Dato introducido no válido.");
		} finally {
			// cierre lector
			sc.close();
		}
		
	}

}
