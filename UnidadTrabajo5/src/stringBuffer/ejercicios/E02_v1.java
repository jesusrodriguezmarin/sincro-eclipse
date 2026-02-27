package stringBuffer.ejercicios;

import java.util.Scanner;

public class E02_v1 {

	public static void main(String[] args) {
		
		// Cramos lector
		Scanner sc = new Scanner(System.in);
		
		// Pedimos cadena a usuario
		System.out.print("Introduce una cadena de caracteres: ");
		String cadena = sc.nextLine();
		sc.close();
		
		// Revertimos el orden del String y lo concatenamos al principal
		for (int i=cadena.length()-2; i>=0; i--) {
			cadena+=cadena.charAt(i);
		}
		// Mostramos
		System.out.println(cadena);
	}

}
