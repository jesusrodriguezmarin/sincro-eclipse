package stringBuffer.ejercicios;

import java.util.Scanner;

public class E03cadPrincipalCadBuscada {

	public static void main(String[] args) {

		// Creamos lector
		Scanner sc = new Scanner(System.in);
						
		// Pedimos a usuario un String
		System.out.print("Introduce la cadena pricipal: ");
		String cad = sc.nextLine();
		
		// Pedimos a usuario otro String
		System.out.print("Introduce la cadena a buscar: ");
		String subcad = sc.nextLine();
		sc.close();
		
		// Variables contador
		int pos=0;
		int conta=0;
		
		// 
		while (pos>=0) {
			pos=cad.indexOf(subcad, pos);
			if (pos>=0) {
				pos++;
				conta++;
			}
		}
		
		System.out.println(subcad+" aparece "+conta+" veces en "+cad);
	}

}
