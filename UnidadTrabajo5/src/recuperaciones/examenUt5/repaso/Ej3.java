package recuperaciones.examenUt5.repaso;

import java.util.Scanner;

public class Ej3 {

	public static void main(String[] args) {

		// Solicitamos una cadena de texto por consola
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce una cadena de texto: ");
		String cadena = sc.nextLine().trim();
		
		// Mostramos de forma inversa
		System.out.print("La cadena inversa es: ");
		for (int i = cadena.length()-1 ; i >= 0; i--) {
			System.out.print(cadena.charAt(i));
		}
		
		// Mostramos vocales mayúsculas
		System.out.print("\nCon vocales en mayúscula: ");
		for (int i = 0; i < cadena.length(); i++) {
			char c = cadena.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				System.out.print(cadena.toUpperCase().charAt(i));
			} else {
				System.out.print(cadena.charAt(i));
			}
		}
		
		// Reemplazamos
		StringBuffer sb = new StringBuffer(cadena);
		
		System.out.print("\nIntroduce un caracter: ");
		char nuevo = sc.nextLine().trim().charAt(0);
		
		System.out.print("Reemplazado por ' ': ");
		
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (c == nuevo) {
				sb.replace(i, i+1, " ");
			}
		}
		
		System.out.println(sb);
		
		// Eliminamos espacios
		System.out.print("Sin espacios: ");
		for (int i = sb.length()-1; i >= 0; i--) {
			if (sb.charAt(i) == ' ') {
				sb.delete(i, i+1);
			}
		}
		System.out.println(sb);
		sc.close();
	}

}
