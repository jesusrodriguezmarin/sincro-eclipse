package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer32mayorDivisorErrores {

	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		
		// control excepciones
		try {
			// declaracion de variables
			int contaC = 0;
			int contaI = 0;

			// pedimos nº entero por teclado
			System.out.print("Introduce un número: ");
			int num = sc.nextInt();
			
			// pedimos nº hasta introducir el 0
			while (num != 0) {
				if (num < 1 || num > 100) {
					System.out.println("ERROR. No has introducido un valor entre 1 y 100");
					contaI++;
				} else {
					System.out.println("--> El mayor divisor de "+num+" es "+Ejer31mayorDivisor.mayordiv(num));
				}
				
				System.out.print("Dime otro nº entero: ");
				num = sc.nextInt();
			}
			System.out.println("Números correctos dentro del rango: "+contaC);
			System.out.println("Números incorrectos dentro del rango: "+contaI);
			
		} catch (Exception e) {
			System.err.println(">>> ERROR!");
			System.err.println("No has introducido un nº entero.");
		}
		
		// cierre lector
		sc.close();

	}

}
