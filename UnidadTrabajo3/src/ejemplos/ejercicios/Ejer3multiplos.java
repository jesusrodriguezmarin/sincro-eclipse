package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer3multiplos {

	
	// Programa principal
	public static void main(String[] args) {
		// Introducimos el lector
		Scanner sc = new Scanner(System.in);
		
		// Control de errores
		try {
			// Pedimos un valor de tipo entero
			System.out.print("Dime un valor tipo entero: ");
			// Declaración e inicialización
			int num = sc.nextInt();
			
			// Condicionales
			if (num % 2 == 0)
				System.out.println("El número: "+num+" es par.");
			if (num % 3 == 0)
				System.out.println("El número: "+num+" es multipo de 3.");
			if (num % 5 == 0)
				System.out.println("El número: "+num+" es multiplo de 5.");
			if (num % 7 == 0)
				System.out.println("El número: "+num+" es multiplo de 7.");
			// Si el número cumple alguna de las condiciones, imprimirá y no hará nada mas
			
		} catch (Exception e) {
			
			System.err.print(">> ERROR. Introduce un número entero");
		}
		
		sc.close();
	}

}
