package stringBuffer.ejercicios;

import java.util.Scanner;

public class E03 {

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
		
		// Buscamos la subcadena y contamos el número de apariciones
		int posicion=0;
		int apariciones=0;
		
		while (posicion>=0) {
			posicion=cadena.indexOf(subcadena, posicion);
			if (posicion>=0) {
				posicion++;
				apariciones++;
			}
		}
		// Mostramos el número de apariciones
		System.out.println("Aparece "+apariciones+" veces");
	}

}
