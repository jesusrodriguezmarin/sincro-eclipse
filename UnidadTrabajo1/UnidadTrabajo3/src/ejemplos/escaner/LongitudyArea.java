package ejemplos.escaner;

import java.util.Scanner;

public class LongitudyArea {

	public static double longitud(int r) {
		final double PI = 3.1416;
		double longTotal = 2*PI*r;
		return longTotal;
	}
	
	public static double area(int r) {
		final double PI = 3.1416;
		double areaTotal = PI*r*r;
		return areaTotal;
	}
		
	public static void main(String[] args) {
		// Creamos el lector
		Scanner sc = new Scanner (System.in);
		
		try {
			// Leemos el radio
			System.out.println("Dime el radio de la circunferencia: ");
			int r = sc.nextInt();
			
			// Mostramos la longitud de la circunferencia de radio r
			longitud(r);
			System.out.print("La longitud de la circunferencia es: "+longitud(r));
			
			// Mostramos el área del círculo de radio r
			area(r);
			System.out.print("El área del círculo es: "+area(r));
			
			
		} catch (Exception e) {
			System.err.println("Error!!!");
		}
		
		
		
		
		sc.close();

	}

}
