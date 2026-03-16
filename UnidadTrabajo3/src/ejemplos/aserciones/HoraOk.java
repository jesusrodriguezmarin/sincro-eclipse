package ejemplos.aserciones;

import java.util.Scanner;

public class HoraOk {

	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		// control excepciones
		try {
			// declaramos variables a pedir
			int hora, minutos, segundos;
			
			System.out.println("Introduce la hora...");
			
			System.out.print("Introduce hora: ");
			hora = sc.nextInt();
			if (hora < 0 || hora > 23) {
				System.out.println("Horas fuera de rango");
			} else {
				System.out.print("Introduce minutos: ");
				minutos = sc.nextInt();
				if (minutos < 0 || minutos > 59)
					System.out.println("minutos fuera de rango");
				else {
					System.out.print("Introduce segundos: ");
					segundos = sc.nextInt();
					if (segundos < 0 || segundos > 59)
						System.out.println("segundos fuera de rango");
					else {
						System.out.println("La hora "+hora+" : "+minutos+" : "+segundos+" es correcta.");
						
					}
				}
			}
						
		} catch (Exception e) {
			System.out.println("ERROR");
		} finally {
			// cierre
			sc.close();
		}		

	}

}
