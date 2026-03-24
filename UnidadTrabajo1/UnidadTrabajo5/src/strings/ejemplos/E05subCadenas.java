package strings.ejemplos;

import java.util.Scanner;

public class E05subCadenas {

	public static void main(String[] args) {
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Pedimos a usuario
		System.out.print("Introduce una cadena de caracteres: ");
		String cadena=sc.nextLine();
		
		// Pedimos subcadena
		System.out.print("Introduce una subcadena de caracteres: ");
		String subcadena=sc.nextLine();
		sc.close();
		
		// Indicamos si la subcadena forma parte de la cadena
		if (cadena.indexOf(subcadena)==-1) {
			System.out.println("La subcadena "+subcadena+" no se encuentra en la cadena: "+cadena);
		} else {
			System.out.println("La subcadena "+subcadena+" se encuentra en la cadena: "+cadena);
		}
	}

}
