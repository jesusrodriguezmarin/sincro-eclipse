package ejemplos.fraccion;

import java.util.Scanner;

public class EjercicioFinal {

	public static void main(String[] args) {
		// Creamos dos fracciones
		Fraccion primera = new Fraccion();
		Fraccion segunda = new Fraccion();
		
		// Abrimos lector
		Scanner sc = new Scanner(System.in);
		
		// Control de excepciones
		try {
			System.out.println("Introduce dos fracciones para comprobar si son o no EQUIVALENTES.");
			System.out.println("\nPrimera fraccion");
			System.out.print(" Numerador:");
			primera.setNumerador(sc.nextInt());
			System.out.print(" Denominador: ");
			primera.setDenominador(sc.nextInt());
			
			System.out.println("\nSegunda fracción");
			System.out.print(" Numerador:");
			segunda.setNumerador(sc.nextInt());
			System.out.print(" Denominador: ");
			segunda.setDenominador(sc.nextInt());
			
		} catch (Exception e) {
			System.err.println(">> ERROR. Tipo de dato no válido.");
		} finally {
			sc.close();
		}
		
		
		
		// Llamamos al método para resolver la equivalencia
		if (primera.getNumerador()*segunda.getDenominador() == primera.getDenominador()*segunda.getNumerador())
			System.out.println("\nLas fracciones "+primera+" y "+segunda+" son EQUIVALENTES.");
		else
			System.out.println("\nLas fracciones "+primera+" y "+segunda+" NO son EQUIVALENTES.");


	}

}
