package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer1menorDe2 {

	public static void main(String[] args) {
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		// Declaración de variables
	
		// Control de errores
		try {
			// Pedimos un valor de tipo entero
			System.out.print("Dime un valor tipo entero: ");
			int a = sc.nextInt();
			System.out.print("Dime un valor tipo entero: ");
			int b = sc.nextInt();
			
			// Visualizamos el menor
			if (a < b)
				System.out.print("El menor es: "+a);
			else if (a > b)
				System.out.print("El menor es: "+b);
			else 
				System.out.print(a+" y "+b+" son iguales");
			
		} catch (Exception e) {
			System.err.print("ERROR. No has introducido un valor entero");
		}
		// Cerramos el lector
		sc.close();
	}

}
