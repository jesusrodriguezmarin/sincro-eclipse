package stringBuffer.ejercicios;

import java.util.Scanner;

public class E02invertirConcatenarEspejo {

	public static void main(String[] args) {

		// Creamos lector
		Scanner sc = new Scanner(System.in);
				
		// Pedimos a usuario un String
		System.out.print("Introduce una cadena de caracteres: ");
		String cad = sc.nextLine();
		sc.close();
				
		// Creamos un StringBuffer para aplicar el método .reverse
		StringBuffer cad1 = new StringBuffer(cad);
				
		// Invertimos la cadena
		cad1.reverse();
		System.out.println(cad1);
		
		// Pasamos cad1 a String
		String cad2 = cad1.toString();
		
		// Concatenamos
		cad.concat(cad2);
		
		// Mostramos
		System.out.println(cad.concat(cad2));
		
		// Mostramos cad sin la última letra y concatenamos cad2
		System.out.println(cad.substring(0, cad.length()-1).concat(cad2));
	}

}
