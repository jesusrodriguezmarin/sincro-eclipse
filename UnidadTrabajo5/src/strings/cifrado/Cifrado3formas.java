package strings.cifrado;

import java.util.Scanner;

public class Cifrado3formas {

	// Constantes para las claves de sustitución (Cesar3 y Rot13)
	private static final int CESAR = 3;
	private static final int ROT13 = 13;

	/**
	 * Encripta una palabra pasada por parámetro por método de sustutución
	 * 
	 * @param palabra - String pasado por parámetro
	 * @param clave   - posiciones pasadas como clave a sustituir
	 * @return una palabra encriptada por sustitución tantas posiciones como la
	 *         clave indica
	 */
	private static String sustitucion(String mensaje, int clave) {
		// Palabra a crear
		String encriptada = "";
		int caracter;

		// Recorremos la palabra introducida
		for (int i = 0; i < mensaje.length(); i++) {

			// Si el caracter itinerante esta dentro del abecedario minúsculo
			if (mensaje.charAt(i) >= 'a' && mensaje.charAt(i) <= 'z') {

				// Encriptamos el caracter en caracter+clave
				caracter = mensaje.charAt(i) + clave;

				// Controlamos si tras la encriptacion se pasa de 'z'
				if (caracter > 'z') {

					// Restamos 26 para hacer la sustitución circular
					caracter = caracter - 26;
				}
				// Concatenamos el caracter en clave a la palabra nueva que estamos generando
				encriptada += (char) caracter;

				// En caso de mayúsculas igual con este condicional
			} else if (mensaje.charAt(i) >= 'A' && mensaje.charAt(i) <= 'Z') {
				caracter = mensaje.charAt(i) + clave;
				if (caracter > 'Z') {
					caracter -= 26;
				}
				encriptada += (char) caracter;

				// En otro caso es un caracter especial o número y lo dejamos tal cual
			} else {
				encriptada += mensaje.charAt(i);
			}
		}
		return encriptada;
	}
	
	/**
	 * Encripta por el método de transposición un mensaje pasado por parámetro
	 * junta letras impares primero, pares después 
	 * concatena las dos cadenas
	 * @param mensaje - String a encriptar
	 * @return un String referente al mensaje encriptado
	 */
	private static String riel(String mensaje) {
		String cad1="";
		String cad2="";
			for (int i=0; i<mensaje.length(); i++) {
				if (i%2==0) {
					cad1+=mensaje.charAt(i);
				} else {
					cad2+=mensaje.charAt(i);
				}
			}
		return cad1+cad2;
	}

	public static void main(String[] args) {

		// Declaramos la variable para pedir la palabra y generar la encriptación
		String palabra;

		// Creamos lector
		Scanner sc = new Scanner(System.in);

		// Pedimos la palabra
		System.out.print("Introduce una palabra a encriptar: ");
		palabra = sc.nextLine();
		sc.close();

		// Encriptamos en Cesar3
		System.out.println("Tu palabra en Cesar3 es: " + sustitucion(palabra, CESAR));

		// Encriptamos en Rot13
		System.out.println("Tu palabra en Rot13 es: "+ sustitucion(palabra, ROT13));

		// Encriptamos en Riel
		System.out.println("Tu palabra en Riel es: "+riel(palabra));
	}

}
