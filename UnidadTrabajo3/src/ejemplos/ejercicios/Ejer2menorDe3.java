package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer2menorDe3 {

	public static int menor3(int a, int b, int c) {
		if (a < b) {
			if (a < c)
				return  a;
			else
				return  c;	
		}
		else if (b < c) {
			return b;
		} else {
			return c;
		}
	}
	
	// Programa principal
	public static void main(String[] args) {
		// Introducimos el lector
		Scanner sc = new Scanner(System.in);
		
		// Control de errores
		try {
			// Pedimos un valor de tipo entero
			System.out.print("Dime un valor tipo entero: ");
			int a = sc.nextInt();
			System.out.print("Dime un valor tipo entero: ");
			int b = sc.nextInt();
			System.out.print("Dime un valor tipo entero: ");
			int c = sc.nextInt();
			
			// Llamamos a la función
			System.out.println("El menor de: "+a+" , "+b+" y "+c+" es: "+menor3(a, b, c));
		} catch (Exception e) {
			System.err.print(">> ERROR. Introduce un número entero");
		}
		sc.close();


	}

}
