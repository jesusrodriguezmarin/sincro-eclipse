package wrappers;

import java.util.Scanner;

public class NombreyEdad02 {

	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		
		// pedimos edad al usuario
		System.out.print("Introduce tu edad: ");
		int edad = sc.nextInt();
		
		// se come el intro guardado
		sc.nextLine();
		
		// pedimos nombre al usuario
		System.out.print("Introduce tu nombre: "); 
		String nombre = sc.nextLine();
		
		// mostramos los valores leidos
		System.out.println("Te llamas "+nombre+" y tu edad es: "+edad);
		
		// cerramos lector
		sc.close();

	}

}
