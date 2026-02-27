package ejemplos.ejercicios2;

import java.util.Scanner;

public class Ejer3 {

	public static void main(String[] args) {
		// abrimos scaner
		Scanner sc = new Scanner(System.in);
		// control
		try {
			// pedimos nº para nota entre 1 y 10
			System.out.print("Introduce la nota entre 1 y 10: ");
			int nota = sc.nextInt();
			
			while (nota < 1 || nota > 10) {
				System.out.print("La nota no es válida, introduce un valor entre 1 y 10: ");
				nota = sc.nextInt();
			}
			// swtich para traducir nº a letra
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
			// default no es necesario porque el nº ya entra filtrado por while
			// default: System.out.println("La nota no es correcta!"); break;
			}
			
		} catch (Exception e) {
			System.err.println("ERROR. Dato no válido.");
		} finally {
			// cierre lector
			sc.close();
		}
		
	}

}
