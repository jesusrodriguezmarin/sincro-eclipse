package wrappers;

import java.util.Scanner;

public class NombreyEdad04 {

	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		
		// pedimos edad al usuario
		System.out.print("Introduce tu edad: ");
		String edad = sc.nextLine();
		
		// realizamos un parseo de String a Integer
		int edadnumero = Integer.parseInt(edad);
		
		// pedimos nombre al usuario
		System.out.print("Introduce tu nombre: "); 
		String nombre = sc.nextLine();
		
		// mostramos los valores leidos
		System.out.println("Te llamas "+nombre+" y tu edad es: "+edad);
		System.out.println("El año que viene tu edad será: "+(edadnumero+1));
		
		// cerramos lector
		sc.close();

	}

}
