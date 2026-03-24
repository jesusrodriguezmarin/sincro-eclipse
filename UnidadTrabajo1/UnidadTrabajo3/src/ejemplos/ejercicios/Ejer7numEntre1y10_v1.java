package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer7numEntre1y10_v1 {

	public static void main(String[] args) {
		// Declaramos el lector
		Scanner sc = new Scanner(System.in);
		
		try {
			// Pedimos al usuario que introduzca el primer valor y lo leemos
			System.out.println("Dime un valor entre 1 y 10:");
			int num = sc.nextInt();
			
			// Mientras el númeror no se encuentre enre5r 1 y 10, seguimops pidiendo
			while (num < 1 || num > 10) {
				System.out.println("No se encuentra entre 1 y 10");
				System.out.println("Dime un valor entre 1 y 10");
				num = sc.nextInt();
				
			// Mostar el valor por pantalla
			System.out.println("Has introducido el valor: "+num);
			}
			
		} catch (Exception e) {
			System.out.println("ERROR");
		}
		
		sc.close();

	}

}
