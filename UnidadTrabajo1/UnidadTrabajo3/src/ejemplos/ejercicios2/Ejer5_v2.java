package ejemplos.ejercicios2;

import java.util.Scanner;

public class Ejer5_v2 {

	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		// control
		try {
			// declaramos variable de calificaciones
			final int nCal = 5;
			int num = 0;
			int sus = 0;
			
			// pedimos calificaciones
			for (int i = 1; i <= nCal; i++) {
				do {
					System.out.print("("+i+") Introduce tu nota entre 0 y 10: ");
					num = sc.nextInt();
					
					if (num < 0 || num > 10) {
						System.out.println("Esa nota no es correcta");
					} else if (num < 5) {
						sus++;
					}
				} while (num < 0 || num > 10);
				
			}
			// si hay suspensos muestralos, sino muestra que no hay
			if (sus > 0) {
				System.out.println("Hay: "+sus+" suspensos.");
			} else {
				System.out.println("No hay suspensos.");
			}
			
			
		} catch (Exception e) {
			System.err.println("ERROR!");
		} finally {
			// cierre lector
			sc.close();
		}
		
	}

}
