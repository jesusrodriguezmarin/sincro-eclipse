package ejemplos.escaner;

import java.util.Scanner;

public class Contade1aNumPositivo_v1 {

	public static void main(String[] args) {
		// Creamos el lector
		Scanner sc = new Scanner(System.in);
		try {
			// Pedimos un valor de tipo entero
			System.out.println("Dime un valor entero positivo: ");
			int num = sc.nextInt();
			
			if (num <= 0) {
				System.out.print("No has introducido un valor entero positivo");
			} else {
				System.out.print("Es positivo.");
			}
				
		} catch (Exception e) {
			System.err.print(">> Error: tipo de dato incorrecto.");
			System.err.print(">> Debes introdocir un entero positivo.");
		}
		
	// Cerramos el lector
	sc.close();

	}

}
