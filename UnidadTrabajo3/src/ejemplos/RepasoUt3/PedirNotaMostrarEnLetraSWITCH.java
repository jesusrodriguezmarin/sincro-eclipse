package ejemplos.RepasoUt3;

import java.util.Scanner;

public class PedirNotaMostrarEnLetraSWITCH {

	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		// control
		try {
			// declaramos variable para pedir nota
			int nota;
			
			// pedimos nota acotando entre 0 y 10
			do {
				System.out.print("Introduce tu nota entre 0 y 10: ");
				nota = sc.nextInt();
			} while (nota < 0 || nota > 10);
			
			// filtro de nota para mostrar su nombre en pantalla
			switch (nota) {
			case 0:
			case 1:
			case 2: 
			case 3:
			case 4: System.out.println("Insuficiente"); break;
			case 5: System.out.println("Suficiente"); break;
			case 6: System.out.println("Bien"); break;
			case 7: 
			case 8: System.out.println("Notable"); break;
			case 9: 
			case 10: System.out.println("Sobresaliente"); break;
			}
			
		} catch (Exception e) {
			System.err.println("ERROR. Tipo de dato no válido.");
		} finally {
			// cierre lector
			sc.close();
		}
		
	}

}
