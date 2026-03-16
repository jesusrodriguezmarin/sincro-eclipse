package estudioCasa;

import java.util.Scanner;

public class Palindromo {

	public static void main(String[] args) {
		
		// Creamos String
		String palabra;
		
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Pedimos palabra al usuario
		System.out.println("Introduce una palabra: ");
		palabra=sc.nextLine();
		sc.close();
		
		// Creamos StringBuffer para revertir la palabra
		StringBuffer revertida = new StringBuffer(palabra);
		
		// Comparamos String con StringBuffer
		palabra.equalsIgnoreCase(revertida.reverse().toString());
		
		// Mostramos si es o no es palíndromo
		if (palabra.equalsIgnoreCase(revertida.toString()))
			System.out.println("Si");
		else
			System.out.println("No");

	}

}
