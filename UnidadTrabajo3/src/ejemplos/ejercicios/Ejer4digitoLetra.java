package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer4digitoLetra {

	/**
	 * Procedimiento que muestra un número entre 1 y 9
	 * @param num - nº entero
	 */
	static void unoAnueve(int num) {
		switch (num) {
		case 1: System.out.println("Uno"); break;
		case 2: System.out.println("Dos"); break;
		case 3: System.out.println("Tres"); break;
		case 4: System.out.println("Cuatro"); break;
		case 5: System.out.println("Cinco"); break;
		case 6: System.out.println("Seis"); break;
		case 7: System.out.println("Siete"); break;
		case 8: System.out.println("Ocho"); break;
		case 9: System.out.println("Nueve"); break;
		default: System.out.println("Error, no es un número de un dígito");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Dime un nº de un dígito: ");
			int n = sc.nextInt();
			
			// Llamada al procedimiento
			unoAnueve(n);
		} catch (Exception e) {
			System.err.println("Error, no es un número de un dígito");
		}
		sc.close();
	}

}
