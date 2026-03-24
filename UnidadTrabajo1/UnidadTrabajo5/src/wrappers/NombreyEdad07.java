package wrappers;

import java.util.Scanner;

public class NombreyEdad07 {

	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		
		try {
			
			// pedimos edad al usuario
			System.out.print("Introduce tu edad: ");
			
			// realizamos un parseo de String a Integer
			int edadnumero = Integer.parseInt(sc.nextLine());
			
			// pedimos nombre al usuario
			System.out.print("Introduce tu nombre: "); 
			String nombre = sc.nextLine();
			
			
			// mostramos los valores leidos
			System.out.println("Te llamas "+nombre+" y tu edad es: "+edadnumero);
			System.out.println("El año que viene tu edad será: "+(edadnumero+1));
			
		} catch (Exception e) {
			System.err.println(">> ERROR. Tipo de dato no válido.");
		} finally {
			// cerramos lector
			sc.close();
		}
		
	}

}
