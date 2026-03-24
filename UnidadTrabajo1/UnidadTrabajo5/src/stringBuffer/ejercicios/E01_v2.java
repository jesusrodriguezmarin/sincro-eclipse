package stringBuffer.ejercicios;

import java.util.Scanner;

public class E01_v2 {

	public static void main(String[] args) {

		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Pedimos una cadena de caracteres al usuario
		System.out.print("Introduce una cadena de caracteres: ");
		String cadena = sc.nextLine();
		sc.close();
		
		// Convertimos el String a StringBuild para aplicar .reverse()
		StringBuilder build = new StringBuilder(cadena);
		
		// Invertimos la cadena introducida
		System.out.println("La cadena invertida es: "+build.reverse());

	}

}
