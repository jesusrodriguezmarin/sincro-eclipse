package stringBuffer.ejercicios;

import java.util.Scanner;

public class E04dosCadenasCoincidenciaMayus {

	public static void main(String[] args) {

		// Creamos lector
		Scanner sc = new Scanner(System.in);
								
		// Pedimos a usuario un String
		System.out.print("Introduce una cadena de caracteres: ");
		String cad1 = sc.nextLine();
				
		// Pedimos a usuario otro String
		System.out.print("Introduce la subcadena a remplazar: ");
		String cad2 = sc.nextLine();
		sc.close();
		
		// Reemplazamos la cadena
		cad1=cad1.replaceAll(cad2, cad2.toUpperCase());
		
		// Mostramos
		System.out.println(cad1);

	}

}
