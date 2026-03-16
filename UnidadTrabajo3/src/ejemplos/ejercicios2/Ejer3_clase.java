package ejemplos.ejercicios2;

import java.util.Scanner;

public class Ejer3_clase {

	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		// control
		try {
			// declaracion de variable para nota
			int nota;
			
			// pedimos nota
			do {
				System.out.print("Introduce la nota entre 1 y 10: ");
				nota = sc.nextInt();
			} while (nota < 1 || nota > 10);
			
			switch (nota) {
			case 1: 
			case 2: 
			case 3: 
			case 4: System.out.println("Insuficiente"); break;
			case 5: System.out.println("Suficiente"); break;
			case 6: 
			case 7: System.out.println("Bien"); break;
			case 8: 
			case 9: System.out.println("Notable"); break;
			case 10: System.out.println("Sobresaliente"); break;
			}
			
		} catch (Exception e) {
			System.err.println("ERROR!");
		} finally {
			// cierre
			sc.close();
		}
		
	}

}
