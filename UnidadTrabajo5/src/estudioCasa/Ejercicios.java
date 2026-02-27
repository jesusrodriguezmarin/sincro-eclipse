package estudioCasa;

import java.util.Scanner;

public class Ejercicios {

	public static void main(String[] args) {

		// Creamos un StringBuffer para pedir cadena de caracteres
		String palabra;

		// Creamos lector
		Scanner sc = new Scanner(System.in);

		// 1. Invertir

		// Pedimos una cadena de caracteres al usuario
		System.out.print("Introduce una palabra para invertir: ");
		palabra = sc.nextLine();

		StringBuffer palabraB = new StringBuffer(palabra);
		palabraB.reverse();
		System.out.println(palabra);
		System.out.println(palabraB);

		// 2. Espejo

		String palabra1;
		System.out.print("Introduce una palabra para espejo: ");
		palabra1 = sc.nextLine();

		StringBuffer palabra2 = new StringBuffer(palabra1);
		palabra2.reverse();
		palabra2.delete(0, 1);
		palabra1 = palabra1.concat(palabra2.toString());
		System.out.println("Palindromo: " + palabra1);

		// 3. Cadenas comúnes

		System.out.print("\nIntroduce una cadena principal: ");
		palabra = sc.nextLine();
		System.out.print("Introduce otra cadena para buscar: ");
		palabra1 = sc.nextLine();

		int conta = 0;
		int pos = 0;
		;

		while (pos >= 0) {
			pos = palabra.indexOf(palabra1, pos);
			if (pos >= 0) {
				conta++;
				pos++;

			}
		}

		if (conta > 0) {
			System.out.println("La palabra: " + palabra1 + " aparece: " + conta + " veces en la palabra: " + palabra);
		} else {
			System.out.println("La palabra: " + palabra1 + " no aparece en la palabra: " + palabra);
		} 
		sc.close();

	}

}
