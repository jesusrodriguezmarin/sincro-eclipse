package stringBuffer.ejercicios;

import java.util.Scanner;

public class E02_v2 {

	/**
	 * Función que devuelve la cadena espejo de la cadena pasada como parámetro
	 * @param cadena String
	 * @return cadena concatenada con cadena espejo
	 */
	public static String cadenaEspejo(String cadena) {
		StringBuilder espejo = new StringBuilder(cadena);
		espejo.reverse().delete(0, 1);
		return cadena+espejo.toString();
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Cramos lector
		Scanner sc = new Scanner(System.in);
		
		// Pedimos cadena a usuario
		System.out.print("Introduce una cadena de caracteres: ");
		String cad = sc.nextLine();
		sc.close();
		
		// Mostramos llamando a la función cadenaEspejo
		System.out.println(cadenaEspejo(cad));
		
	}

}
