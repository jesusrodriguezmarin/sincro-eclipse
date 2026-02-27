package ejemplos.escaner;

import java.util.Scanner;

public class Contade1aNumPositivo_v2 {

	public static void main(String[] args) {
		// Creamos el lector
		Scanner sc = new Scanner(System.in);
		try {
			// Pedimos un valor de tipo entero
			System.out.println("Dime un valor entero positivo: ");
			int num = sc.nextInt();
			
			// Opcion 1 Comprobamos que se trata de un entero positivo
			if (num <= 0) {
				System.out.print("No has introducido un valor entero positivo");
			} else {
				// Contamos desde 1 a num con un bucle WHILE
				System.out.println("Contamos del 1 al " + num + " con WHILE: ");
				int conta = 1;

				while (conta <= num) {
					System.out.print(conta + " ");
					conta++;
				}
				
				// Contamos desde 1 a num con un bucle DO..WHILE
				System.out.println("\n\nContamos del 1 al " + num + " con DO..WHILE: ");
				conta=1;
				do { 
					System.out.print(conta + " ");	
					conta++;
				} while (conta<=num);
				
				// Contamos desde 1 a num con un bucle FOR
				System.out.println("\n\nContamos del 1 al " + num + " con FOR: ");
				for (conta=1; conta<=num; conta++)
					System.out.print(conta + " ");
			}
			
			/* Opcion 2
			if (num <= 0) {
				System.out.print("No has introducido un valor entero positivo");
			} else {
				System.out.print("Es positivo.");
			}
			*/
				
		} catch (Exception e) {
			System.err.print(">> Error: tipo de dato incorrecto.");
			System.err.print(">> Debes introdocir un entero positivo.");
		}
		
	// Cerramos el lector
	sc.close();

	}

}
