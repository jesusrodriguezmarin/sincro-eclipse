package stringBuffer.ejercicios;

import java.util.Scanner;

public class E05consonantesVocalesEspacios {

	public static void main(String[] args) {

		// Creamos lector
		Scanner sc = new Scanner(System.in);
										
		// Pedimos a usuario un String
		System.out.print("Introduce una cadena de caracteres: ");
		String cad1 = sc.nextLine();
		sc.close();
		
		// Variables contador
		int conta=0;
		int conta1=0;
		int conta2=0;
		
		// Recorremos el String
		for (int i=0; i<cad1.length(); i++) {
			if (cad1.charAt(i)=='a' || cad1.charAt(i)=='e' || cad1.charAt(i)=='i' || cad1.charAt(i)=='o' ||
				cad1.charAt(i)=='u' || cad1.charAt(i)=='A' || cad1.charAt(i)=='E' || cad1.charAt(i)=='I' || 
				cad1.charAt(i)=='O' || cad1.charAt(i)=='U') {
				conta++;
			}
			if (cad1.charAt(i)!='a' && cad1.charAt(i)!='e' && cad1.charAt(i)!='i' && cad1.charAt(i)!='o' &&
				cad1.charAt(i)!='u' && cad1.charAt(i)!='A' && cad1.charAt(i)!='E' && cad1.charAt(i)!='I' && 
				cad1.charAt(i)!='O' &&cad1.charAt(i)!='U') {
			conta1++;
			}
			if (cad1.charAt(i)==' ') {
				conta2++;
			}
			
		}
		// Mostramos los resultados
		System.out.println("Vocales: "+conta);
		System.out.println("Consonantes: "+conta1);
		System.out.println("Espacios: "+conta2);
	}

}
