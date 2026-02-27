package stringBuffer.ejercicios;

import java.util.Scanner;

public class E05 {

	/**
	 * Función que indica si un caracter pasado como parámetro es una vocal
	 * @param c carácter
	 * @return TRUE si es una vocal, FALSE si no lo es
	 */
	public static Boolean esVocal(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
			c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
			return true;
		}
		return false;
	}

	/**
	 * Función que indica si un carácter pasado como parámetro es una consonante
	 * @param c carácter
	 * @return TRUE si el caracter es una consonante, FALSE si no lo es
	 */
	public static Boolean esConsonante(char c) {
		if (esVocal(c))
			return false;
		if (c>='b' && c<='z')
			return true;
		if (c>='C' && c<='Z')
			return true;
		return false;
	}

	public static void main(String[] args) {

		// Cramos lector
		Scanner sc = new Scanner(System.in);

		// Pedimos cadena a usuario
		System.out.print("Introduce la cadena de caracteres principal: ");
		String cadena = sc.nextLine();
		sc.close();
		
		// Declaramos las variables contadores
		int vocal=0;
		int consonante=0;
		int espacio=0;
		
		// Recorremos el String
		for (int i=0; i<cadena.length(); i++) {
			if (esVocal(cadena.charAt(i))) {
				vocal++;
			}
			if (esConsonante(cadena.charAt(i))) {
				consonante++;
			}
			if (cadena.charAt(i)==' ') {
				espacio++;
			}
		}
		// Mostramos el resultado
		System.out.println("Vocales: "+vocal);
		System.out.println("Consonantes: "+consonante);
		System.out.println("Espacios: "+espacio);

	}

}
