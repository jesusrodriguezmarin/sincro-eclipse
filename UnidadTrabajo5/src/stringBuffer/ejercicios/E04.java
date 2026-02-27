package stringBuffer.ejercicios;

import java.util.Scanner;

public class E04 {

	public static void main(String[] args) {

		// Cramos lector
		Scanner sc = new Scanner(System.in);

		// Pedimos cadena a usuario
		System.out.print("Introduce la cadena de caracteres principal: ");
		String cadena = sc.nextLine();

		// Pedimos cadena a usuario
		System.out.print("Introduce la cadena de caracteres a buscar: ");
		String subcadena = sc.nextLine();
		sc.close();

		cadena=cadena.replace(subcadena, subcadena.toUpperCase());
		
		System.out.println(cadena);
	}

}
