package ejemplos.escaner;

import java.util.Scanner;

public class De1aNumyDeNuma1 {

	public static void main(String[] args) {
		try {		
		// Creamos el lector
		Scanner sc = new Scanner(System.in);
		// Pedimos un valor de tipo entero
		System.out.print("Dime un valor entero positivo: ");
		int num = sc.nextInt();
		// Cerramos el lector
		sc.close();
			// Comprobamos que se trata de un entero positivo	
			if (num > 0) {
				// Contamos desde 1 a num con un bucle FOR
				System.out.print("Contamos del 1 al " + num + " con FOR: ");
				for (int conta = 1; conta <= num; conta++)
					System.out.print(conta+" ");	
				}	else {
					System.out.println("Error, introduce un número positivo");
				}
			if (num > 0) {
				// Contamos de num a 1 con bucle for
				System.out.print("\nContamos de "+num+" a 1 con FOR: ");
				for (int conta = num; conta >= 1; conta--)
					System.out.print(conta+" ");
			} else {

			}
			
		} catch (Exception e) {
			System.err.print(">> Error: tipo de dato incorrecto.");
			System.err.print("\n>> Debes introdocir un nº entero positivo.");
		}
				
	}

}
