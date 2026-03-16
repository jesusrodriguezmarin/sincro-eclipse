package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer24paraImpares {

	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		// control
		try {
			int pares = 0; // variable para contar los nº pares introducidos
			int impares = 0; // variable para contar los nº impares introducidos
			
			System.out.print("Introduce un valor entero: ");
			int num = sc.nextInt();
			while (num != 0) {
				// actualizamos valores contadoras
				if (num % 2 == 0)
					pares++;
				else
					impares++;
					
					// pedimos el siguiente nº
					System.out.print("Dime otro valor: ");
					num = sc.nextInt();
				}	
			
			// mostramos resultados
			System.out.println("Pares: "+pares);
			System.out.println("Impares: "+impares);
			
		} catch (Exception e) {
			System.err.println("ERROR");
		}
		
		// cierre
		sc.close();

	}

}
