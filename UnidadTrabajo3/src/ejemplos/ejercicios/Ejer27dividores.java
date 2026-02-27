package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer27dividores {

	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		
		// control
		try {
			// 1. leemos un nº  entero
			int num;
			do {
				System.out.print("Introduce un nº entero positivo: ");
				num = sc.nextInt();
			} while (num < 0);
			
			// 2. mostramos por pantalla sus divisiones
			for (int i = 1; i <= num; i++) {
				if (num %  i == 0)
				System.out.print(i+" ");
			}
			
		}	catch (Exception e) {
			System.err.println("ERROR");
			
		} 
		 
		// cierre
		sc.close();

	}

}
