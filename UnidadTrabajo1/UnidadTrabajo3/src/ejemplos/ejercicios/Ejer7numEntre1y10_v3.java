package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer7numEntre1y10_v3 {

	public static void main(String[] args) {
		// Declaramos el lector
		Scanner sc = new Scanner(System.in);
		
		try {
			// Declaramos la variable que iniciañlizaremos con sc.next
			int num;
			// Mientras en nº no estte entre 1 y 10
			do {
				System.out.println("Dime un valor entre 1 y 10");
				num = sc.nextInt();
				if (num < 1 || num > 10)
					System.out.println("No se encuentra entre 1 y 10");
			} while (num < 1 || num > 10);
			
			// Mostar el valor por pantalla
			System.out.println("Has introducido el valor: "+num);

		} catch (Exception e) {
			System.out.println("ERROR");
		}
		// Cerramos lector
		sc.close();

	}

}
