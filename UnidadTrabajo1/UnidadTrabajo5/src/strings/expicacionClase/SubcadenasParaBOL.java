package strings.expicacionClase;

import java.util.Scanner;

public class SubcadenasParaBOL {

	public static void main(String[] args) {

		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// 1. Pedimos al usuario una cadena de carácteres
		System.out.print("Introduce una cadena de carácteres: ");
		String cad = sc.nextLine().trim();
		

		// 2. Pedimos al usuario otra cadena de carácteres
		System.out.print("Introduce una cadena de carácteres: ");
		String subcad = sc.nextLine().trim();
		
		// Cerramos lector
		sc.close();
		
		// 3. Indicamos si la subcadena introducida forma paete de la cadena inicial
		if (cad.indexOf(subcad)==-1) {
			System.out.println("No hemos encontrado la subcadena"+subcad+" dentro de: "+cad);
		} else {
			System.out.println("La subcadena "+subcad+" se encuentra en la cadena: "+cad);
		}
	}

}
