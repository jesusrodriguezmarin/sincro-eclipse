package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer31mayorDivisor {

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
	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		// control
		try {
			int num;
			System.out.print("Introduce un nº entero: ");
			num = sc.nextInt();
			
			System.out.println("El mayor divisor de "+num+" es: "+mayordiv(num));
			
		} catch (Exception e) {
			System.err.println("ERROR");
		}
		
		// cierre
		sc.close();

	}

}
