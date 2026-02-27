package rejog;

import java.util.Scanner;

public class TimeTest01 {

	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		
		
		
		// control de excepciones
		try {
			System.out.println("Introduce una hora...");
			System.out.print(" Horas: ");
			int hora = sc.nextInt();
			System.out.print(" Minutos: ");
			int min = sc.nextInt();
			System.out.print(" Segundos: ");
			int seg = sc.nextInt();
			
			// creamos objeto
			Time r = new Time(hora, min, seg);
			
			// usamos el método isValid
			r.isValid();
			
			System.out.println(r.toString());
			
			
		} catch (Exception e) {
			System.err.println("\n>> ERROR en la introducion de datos");
		} finally {
			sc.close();
		}

	}

}
