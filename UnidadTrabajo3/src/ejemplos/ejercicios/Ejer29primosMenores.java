package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer29primosMenores {

	public static void main (String[] argv) {
		// lector
		Scanner sc = new Scanner(System.in);
		// control
		try {
			int num;
			
			// pedimos un nº psitivo
			do {
				System.out.print("Dime un número: ");
				num = sc.nextInt();
			} while (num <= 0);
			
			// bucle para recorrer desde 2 hasta la mitad de num
			for (int i = 2; i <= num/2; i++) {
				
				// declaración de booleano
				boolean primo = true;
				
				// bucle para divisiones
				for (int j = 2; j <= i/2; j++) {
					// si hay divisor comprueba
					if (i % j == 0) {
						primo = false;
					}
				}
				if (primo)
					System.out.print("> Los primos menores de "+num+" son: ");
					System.out.print(i+" ");
				
			}	
			
		} catch (Exception e) {
			System.err.println("ERROR");
		}
		
		// cierre
		sc.close();
		
	}
		

}