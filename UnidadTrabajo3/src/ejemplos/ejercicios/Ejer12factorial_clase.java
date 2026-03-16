package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer12factorial_clase {

	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		// control
		try {
			// Pedimos un número por pantalla
			System.out.print("Introduce un valor entero positivo: ");
			int num = sc.nextInt();
			
			// Condicional para corregir el fallo
			if (num <= 0) {
				System.out.print("Introduce un valor entero positivo: ");
			}
			
			// Declaración variables
			int conta;
			int facto = 1;
			// Bucle con for
			for (conta = 1; conta <= num; conta++) {
				facto = facto*conta;
			}		
			System.out.println("El factorial de ese número es: "+facto);
		} catch (Exception e) {
			System.err.println(">>> ERROR. Introduce un valor entero");
		}	
		// cierre de lector
		sc.close();
	}

}
