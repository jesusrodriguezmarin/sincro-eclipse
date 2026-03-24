package stringBuffer.ejercicios;

import java.util.Scanner;

public class E01pedirCadenaInvertir {

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

	}

}
