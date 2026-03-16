package stringBuffer.extra;

import java.util.Scanner;

public class Espacios {

	public static void main(String[] args) {
		
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Pedimos String a usuario
		System.out.print("Introduce una frase: ");
		String frase = sc.nextLine();
		sc.close();
		
		// Quitamos espacios laterales
		frase = frase.trim();
		
		// Quitamos los espacios intermedios sobrantes
		for (int i=0; i<frase.length()-1; i++) {
			while (frase.charAt(i)==' ' && frase.charAt(i+1)==' ') {
				frase=frase.replace("  ", " ");
			}
		}
		
		// Mostramos la frase correcta
		System.out.println(frase);
	}

}
