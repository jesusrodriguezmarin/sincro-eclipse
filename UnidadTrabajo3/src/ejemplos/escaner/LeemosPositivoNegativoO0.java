package ejemplos.escaner;

import java.util.Scanner;

public class LeemosPositivoNegativoO0 {

	// Leemos un número y decimos si es positivo, negativo o 0
	public static void main(String[] args) {
		// Introducimos el lector
		Scanner sc = new Scanner(System.in);
		
		// Metemos el control de excepciones
		try {
			System.out.println("Dime un valor entero: ");
			int num = sc.nextInt();
			
			// Mostramos por pantalla
			if (num>0)
			System.out.println(num+" es positivo");
			else if (num<0)
				System.out.println(num+" es negativo");
			else
				System.out.println(" es cero");
		} catch (Exception e) {
			System.err.println("ERROR");
		} 
		
		// Cerramos el lector
		sc.close();

	}

}
