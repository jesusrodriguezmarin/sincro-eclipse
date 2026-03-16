package ejemplos.aserciones;

import java.util.Scanner;

public class HoraOk2Aserciones {

	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		// control errores
		try {
			// declaramos variables a pedir
			int hora, minutos, segundos;
			
			System.out.println("Introduce la hora...");
			
			System.out.print("Introduce la hora: ");
			hora = sc.nextInt();
			assert hora >= 0 && hora <= 23 : ">> Horas fuera de rango permitido";
			
			System.out.print("Introduce los minutos: ");
			minutos = sc.nextInt();
			assert minutos >= 0 && minutos <= 59 : ">> Minutos fuera de rango permitido";
			
			System.out.print("Introduce los segundos: ");
			segundos = sc.nextInt();
			assert segundos >= 0 && segundos <= 59 : ">> Segundos fuera de rango permitido";
			
			System.out.println("La hora "+hora+" : "+minutos+" : "+segundos+" es correcta.");
		
		} catch (AssertionError ae) {
			System.out.println(ae.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR");
		} finally {
			// cierre
			sc.close();
		}
			
	}

}
