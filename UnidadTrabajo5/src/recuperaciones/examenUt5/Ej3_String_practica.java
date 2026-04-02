package recuperaciones.examenUt5;

import java.util.Scanner;

public class Ej3_String_practica {

	public static void main(String[] args) {
				
		// Solicitamos un nombre al usuario por teclado y guardamos en String
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce tu nombre: ");
		String nombre = sc.nextLine().trim();
		
		// Mostramos el nombre del revés
		System.out.print("\nTu nombre al revés es: ");
		for (int i=nombre.length()-1; i>=0; i--) {
			System.out.print(nombre.charAt(i));
		}
		
		// Convertimos las vocales a mayuscula	
		for (int i=0; i<nombre.length(); i++) {
			char n = nombre.charAt(i);
			if (n == 'a' || n == 'e' || n == 'i'|| n == 'o'|| n == 'u') {
				char c = nombre.toUpperCase().charAt(i);
				nombre = nombre.replace(nombre.charAt(i), c);
			}
		}
		System.out.println("\n\nAhora el nombre es: "+nombre);

		// Solicitamos un carácter único al usuario
		System.out.print("\nIntroduce un caracter: ");
		char car = sc.nextLine().toUpperCase().charAt(0);
		
		// Buscaos ese caracter en el nombre y lo sustituimos por espacio en blanco
		for (int i=0; i<nombre.length(); i++) {
			char n = nombre.toUpperCase().charAt(i);
			if (n == car) {
				nombre = nombre.toUpperCase().replace(n, ' ');
			}
		}
		System.out.println("\nAhora el nombre es: "+nombre);
		
		// Eliminamos espacios laterales e intermedios
		nombre = nombre.trim();
		
		nombre = nombre.replace(" ", "");
	
		// Mostramos resultado
		System.out.println("\nResultado: "+nombre);
		sc.close();
		// No veo necesidad de usar StringBuffer
		
	}

}
