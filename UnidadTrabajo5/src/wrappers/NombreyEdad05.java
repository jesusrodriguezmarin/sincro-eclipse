package wrappers;

import java.util.Scanner;

public class NombreyEdad05 {

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
		
		// pedimos la nota
		System.out.print("Introduce tu nota: ");
		String nota = sc.nextLine();
		
		// parseo
		float notafloat = Float.parseFloat(nota);
		
		// mostramos los valores leidos
		System.out.println("Te llamas "+nombre+" y tu edad es: "+edad);
		System.out.println("El año que viene tu edad será: "+(edadnumero+1));
		System.out.println("Subimos un punto a la nota: "+(notafloat+1));
		
		// cerramos lector
		sc.close();

	}

}
