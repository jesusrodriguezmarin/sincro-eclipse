package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer8positivoImpares {

	public static void main(String[] args) {
		
		
		try {
			// // Declaramos el lector dentro del try cuando solo pedimos un nº
			Scanner sc = new Scanner(System.in);
			System.out.print("Dime un número positivo");
			int num = sc.nextInt();
			// Cerramos lector
			sc.close();
			
			if (num <= 0) {
				System.out.print("No has introducido un nº post");
			}
			
			for (int conta = 3; conta <= num; conta += 2)
				System.out.print(conta+" ");
			
		} catch (Exception e) {
			System.out.println("ERROR");
		}

	}

}
