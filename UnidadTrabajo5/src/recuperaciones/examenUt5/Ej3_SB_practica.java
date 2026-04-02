package recuperaciones.examenUt5;

import java.util.Scanner;

public class Ej3_SB_practica {

	public static void main(String[] args) {
		
		// Solicitamos un nombre por teclado
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce tu nombre: ");
		StringBuffer sb = new StringBuffer(sc.nextLine().trim());
		
		System.out.println(" > Tu nombre: "+sb);
		
		// Mostramos el nombre al revés
		System.out.println(" > Al revés es: "+sb.reverse());
		
		// Convertimos las vocales a mayúsculas
		for (int i=0; i<sb.length(); i++) {
			char c = sb.charAt(i);
			if (c == 'a' || c == 'o' || c == 'e' || c == 'i' || c == 'u'
					|| c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
				sb.setCharAt(i, Character.toUpperCase(c));
			}
		}
		// Devolvemos el nombre a su origen
		sb.reverse();
		System.out.println(" > En mayúscula: "+sb);
		
		// Reemplazamos el caracter introducido por el usuario por un espacio
		System.out.print("\nIntroduce un caracter para remplazar: ");
		char rem = sc.nextLine().toUpperCase().charAt(0);
		
		for (int i=0; i<sb.length(); i++) {
			char s = Character.toUpperCase(sb.charAt(i));
			if (s == rem) {
				sb.setCharAt(i, ' ');
			}
		}
		System.out.println(" > Con espacios: "+sb);
		
		// Eliminamos los espacios 
		for (int i=sb.length()-1; i>=0; i--) {
			if (sb.charAt(i) == ' ') {
				sb.deleteCharAt(i);
			}
		}
		System.out.println(" > Sin espacios: "+sb);
		sc.close();
	}

}
