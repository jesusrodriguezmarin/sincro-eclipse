package strings.arrays;

import java.util.Scanner;

public class E01miNombre {

	/**
	 * La forma extendida
	 * 
	 * Función que devuelve invertida la cadena de caracteres pasada como parámetro
	 * 
	 * @param cadena a invertir
	 * @return cadena de caracteres invertida
	 */
	/*
	 * private static String invertir(String cadena) { StringBuilder sb = new
	 * StringBuilder(cadena); String s = sb.reverse().toString(); return s; }
	 * 
	 * 
	 * /** La forma reducida Función que devuelve invertida la cadena de caracteres
	 * pasada como parámetro
	 * 
	 * @param cadena a invertir
	 * 
	 * @return cadena de caracteres invertida
	 */
	private static String invertir1(String cadena) {
		return new StringBuilder(cadena).reverse().toString();
	}

	/**
	 * Devuelve las vocales de la cadena pasada por parámetros
	 * 
	 * @param cadena String
	 * @return cadena que contiene unicamente las vocales de la cadena
	 */
	private static String vocales(String cadena) {
		String res = "";
		char c;
		for (int i = 0; i < cadena.length(); i++) {
			c = cadena.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
					|| c == 'U') {
				res += c;
			}
		}
		return res;
	}

	/**
	 * Devuelve el nº de vocales que contiene la cadena pasada como parámetro
	 * 
	 * @param cadena String sobre la que vamos a contar el nº de vocales
	 * @return el nº de vocales de la cadena (int)
	 */
	private static int nvocales(String cadena) {
		int conta = 0;
		char c;
		for (int i = 0; i < cadena.length(); i++) {
			c = cadena.toUpperCase().charAt(i);
			if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
				conta++;
			}
		}
		return conta;
	}

	/**
	 * Devuelve el nº de consonantes que contiene una cadena pasada por parámetro
	 * 
	 * @param cadena String
	 * @return el nº de consonantes
	 */
	private static int nconsonantes(String cadena) {
		int conta = 0;
		char c;
		for (int i = 0; i < cadena.length(); i++) {
			c = cadena.charAt(i);
			if (c >= 'b' && c <= 'z') {
				if (c != 'e' && c != 'i' && c != 'o' && c != 'u') {
					conta++;
				}
			}
		}
		return conta;
	}

	/**
	 * Devuelve una cadena con las consonantes de la cadena pasada por parámetro
	 * 
	 * @param cadena String
	 * @return las consonantes
	 */
	private static String consonantes(String cadena) {
		String res = "";
		char c;
		for (int i = 0; i < cadena.length(); i++) {
			c = cadena.charAt(i);
			if (c >= 'b' && c <= 'z') {
				if (c != 'e' && c != 'i' && c != 'o' && c != 'u') {
					res += c;
				}
			}
		}
		return res;
	}

	// Programa principal
	public static void main(String[] args) {

		// Creamos lector
		Scanner sc = new Scanner(System.in);

		// Pedimos nombre al usuario
		System.out.print("Introduce tu nombre: ");
		String nombre = sc.nextLine();
		sc.close();

		// Creamos el String

		System.out.println("Nombre:" + nombre);
		System.out.println("Mayúsculas: " + nombre.toUpperCase());
		System.out.println("Minúsculas: " + nombre.toLowerCase());
		System.out.println("Invertido: " + invertir1(nombre));
		System.out.println("Vocales: " + vocales(nombre));
		System.out.println("Nº vocales: " + nvocales(nombre));
		System.out.println("Consonantes: " + consonantes(nombre));
		System.out.println("Nº consonantes: " + nconsonantes(nombre));

	}

}
