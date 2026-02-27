package ejemplos.ejercicios2;

import java.util.Scanner;

public class Ejer5_clase_boolean {

	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		// control
		try {
			
			// 
			boolean suspenso = false;
			
			// declaramos variable de calificaciones
			final int nCal = 5;
			int nota = 0;
			
			// pedimos calificaciones
			for (int i = 1; i <= nCal; i++) {
				do {
					System.out.print("("+i+") Introduce tu nota entre 0 y 10: ");
					nota = sc.nextInt();
					
					if (nota < 0 || nota > 10) {
						System.out.println("Esa nota no es correcta");
					}
				} while (nota < 0 || nota > 10);
				
				if (nota < 5) {
					suspenso = true;
				}
			}
			// si hay suspensos muestralos, sino muestra que no hay
			if (suspenso) {
				System.out.println("Hay suspensos.");
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
