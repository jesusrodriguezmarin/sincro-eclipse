package strings.cifrado;

import java.util.Scanner;

public class TransposicionRiel {

	public static final int CESAR=3;
	
	public static final int ROT13=13;
	
	/**
	 * Cifrado por sustitución
	 * Sustituye cada caracter del mensaje a cifrar por el carácter que ocupa 'clave' posiciones en el alfabeto
	 * Cifra solo los carácteres del alfabeto 'A'..'Z' Y 'a'..'z' (sin incluir ñ ni Ñ).
	 * Cualquier otro carácter incluidos espacios en blanco se copiaran igual, sin cifrar.
	 * Considera el alfabeto circular: después de 'Z' continuará 'A' y en minúsculas igual.
	 * @param mensaje - String - mensaje a cifrar.
	 * @param clave - int - clave a aplicar en el cifrado
	 * @return criptograma al que se ha aplicado el cifrado por sustitución
	 */
	public static String sustitucion(String mensaje, int clave) {
		String criptograma = "";
		
		// Declaramos caracter
		int caracter;
		
		// Recorremos el mensaje
		for (int i=0; i<mensaje.length(); i++) {
			// Si el carácter a cifrar se encuentra entre A y Z lo ciframos
			if (mensaje.charAt(i)>='A' && mensaje.charAt(i)<='Z') {
				caracter=mensaje.charAt(i)+clave;
				if ((char)caracter>'Z') {
					caracter-=26;
				}
				criptograma+=(char)caracter;
			} else if (mensaje.charAt(i)>='a' && mensaje.charAt(i)<='z') {
				caracter=mensaje.charAt(i)+clave;
				if ((char)caracter>'z') {
					caracter-=26;
				}
				criptograma+=(char)caracter;
			} else {
				criptograma+=mensaje.charAt(i);
			}
			
		}
		return criptograma;
	}
	
	/**
	 * Crifrar por la trasposición de Riel.
	 * El mensaje se cifra alternando dos cadenas separadas y concatenando estas dos
	 * @param mensaje - String - mensaje a cifrar
	 * @return criptograma String que se obtiene al aplicar la transposición de Riel
	 */
	public static String transposicionRiel(String mensaje) {
		String cadena1="";
		String cadena2="";
		for (int i=0; i<mensaje.length(); i++) {
			if (i%2==0) {
				cadena1+=mensaje.charAt(i);
			} else {
				cadena2+=mensaje.charAt(i);
			}
		}
		return cadena1+cadena2;
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Leemos por teclado un mensaje a cifrar
		Scanner sc = new Scanner(System.in);
		System.out.print("Escribe el mensaje a cifrar: ");
		String texto = sc.nextLine();
		sc.close();
				
		// Mostramos el texto plano y los correspondientes criptogramas
		System.out.println("Texto plano: "+texto);
		System.out.println("Criptograma (César): "+sustitucion(texto, CESAR));
		System.out.println("Criptograma (Rot13): "+sustitucion(texto, ROT13));
		System.out.println("Criptograma (Riel): "+transposicionRiel(texto));
	}

}
