package stringBuffer.ejercicios;

import java.util.Scanner;

public class E01_v1 {

	public static void main(String[] args) {

		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Pedimos una cadena de caracteres al usuario
		System.out.print("Introduce una cadena de caracteres: ");
		String cadena = sc.nextLine();
		sc.close();
		
		// Invertimos la cadena sin convertir a Builder, con charAt
		String invertida = new String();
		for (int i=cadena.length()-1; i>=0; i--) {
			invertida+=cadena.charAt(i);
		}
		// Mostramos el String
		System.out.println(invertida);
	}

}
