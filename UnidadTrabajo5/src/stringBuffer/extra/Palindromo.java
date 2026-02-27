package stringBuffer.extra;

import java.util.Scanner;

public class Palindromo {

	public static void main(String[] args) {
		
		// 1. Creamos un String para pedir al usuario por teclado
		String palabra = "";
		
		// 2. Pedimos al usuario
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce una palabra: ");
		palabra = sc.nextLine();
		sc.close();
		
		// Quitar espacios laterales
		palabra=palabra.trim();
		
		// Quitar espacios duplicados en el centro
		palabra=palabra.toLowerCase().replace(" ", "");
		
		// 3. Convertimos String a StringBuilder para aplicar el método .reverse()
		StringBuilder palabraB = new StringBuilder(palabra);
		
		// 4. Revertimos
		palabraB = palabraB.reverse();
		
		// 5. Convertimos a String para poder usar .compareTo()
		String revertida = palabraB.toString();

		// 6. Comparamos si es un palindromo entre dos String
		if (palabra.compareTo(revertida)==0) {
			System.out.println("La palabra es un palindromo");
		} else {
			System.out.println("La palabra no es un palindromo");
		}
		
	}

}
