package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer14digitos {

	/**
	 * Funcion que calcule la cantidad de digitos de un nº pasado por parámetro
	 * @param N - nº entero positivo
	 * @return nº de digitos de N
	 */
	public static int digitos (int N) {
		int conta = 1;
		while (N / 10 != 0) {
			N /= 10;
			conta++; 
		} return conta;
	}
	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		// control
		try {
			// pedimos el nº por pantalla
			System.out.print("Introduce un valor numérico positivo: ");
			int num = sc.nextInt();
			System.out.println(num+" tiene: "+digitos(num)+" digitos");
			
		} catch (Exception e) {
			System.out.println(">>> ERROR. Introduce un valor numérico positivo.");
		}
		// cierre lector
		sc.close();

	}

}
