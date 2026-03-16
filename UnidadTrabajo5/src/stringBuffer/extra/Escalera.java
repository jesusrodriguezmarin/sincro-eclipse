package stringBuffer.extra;

import java.util.Scanner;

public class Escalera {

	public static void main(String[] args) {
		
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Pedimos palabra a usuario
		System.out.print("Introduce una palabra: ");
		String palabra = sc.nextLine();
		sc.close();
		
		StringBuilder escalera = new StringBuilder();
		
		// Mostramos en escalera
		for (int i=0; i<palabra.length(); i++) {
			escalera.append(palabra.charAt(i));
			System.out.println(escalera);
		}
		
	}

}
