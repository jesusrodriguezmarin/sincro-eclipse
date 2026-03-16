package ejemplos.condicionales;

import java.util.Scanner;

public class SwitchDiasSemana {

	public static void main(String[] args) {
		
		// Introducimos lector
		Scanner sc = new Scanner(System.in);
		
		
		
			System.out.print("Introduce el puesto en que has quedado: ");
			int puesto = sc.nextInt();
		
			if (puesto>0) {
				try {
			// Introducimos el Switch
			switch (puesto) {
				case 1: System.out.print("Oro"); break;
				case 2: System.out.print("Plata"); break;
				case 3: System.out.print("Bronce"); break;
				case 4: System.out.print("Diploma"); break;
				case 5: System.out.print("Diploma"); break;
				default: System.out.println("Sin premio");
			}
				} catch (Exception e) {
				System.err.println("ERROR!!! tipo de dato no válido");
				}
			} else {
				System.out.println("ERROR!!! el tipo de dato introducido es negativo o igual a 0");
		
		sc.close();
		}
	}
			
}

