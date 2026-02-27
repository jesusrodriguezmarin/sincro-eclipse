package ejemplos.escaner;

import java.util.Scanner;

public class funcionAleatorioDe1a5juego {

	public static void main(String[] args) {
		final int limite = 5;
		// Generamos un número aleatorio
		int aleatorio = (int)(Math.random()*limite+1);
		
		// Control de excepcions
		try {
		// Lector	
		Scanner sc = new Scanner(System.in);
		// Pedimos un nº entero
		System.out.print("Introduce un nº de 1 a 5: ");
		int intro = sc.nextInt();
		
		
		// Condicional
		if (intro <= 5) {
			if (intro == aleatorio) {
				System.out.println("Eureka, es el: "+intro);
			} else {
				while (intro != aleatorio) {
					System.out.println("Sorry!!! prueba de nuevo");
					System.out.print("Introduce un nº entre 1 y 5: ");
					intro = sc.nextInt();
				}
				
			}
		} else {
			while (intro < 1 || intro > 5) {
				System.out.print("Introduce un nº entre 1 y 5: ");
				intro = sc.nextInt();
			}
		}
		
		// Cerramos lector
		sc.close();
		} catch (Exception e) {
			System.err.print("ERROR");
		}
		
	}

}
