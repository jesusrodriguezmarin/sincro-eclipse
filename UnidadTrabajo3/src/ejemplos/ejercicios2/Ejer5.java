package ejemplos.ejercicios2;

import java.util.Scanner;

public class Ejer5 {

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
				System.out.print("("+i+")Introduce la calificación entre 0 y 10: ");
				num = sc.nextInt();
				
				// si num es menor que 5 suma uno a sus
				if (num >= 0 && num < 5) {
					sus ++;
					
				// sino, si num es menor que 1 o mayor que 10 no cuentes la vuelta
				} else if (num < 0 || num > 10) {
					i--;
				}
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
