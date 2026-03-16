package estudioCasa;

import java.util.Scanner;

public class CifradoDescifradoMultiple {

	// Constantes para las claves de sustitución
	private static final int CESAR = 3;
	private static final int ROT13 = 13;

	/**
	 * Función que encripta una palabra pasada por parámetro Método de sustitución
	 * tantas posiciones como la clave parámetro indique
	 * 
	 * @param mensaje - String a encriptar
	 * @param clave   - int posiciones a sustituir
	 * @return String resultado de la sustitución
	 */
	public static String sustitucion(String mensaje, int clave) {
		String encriptado = "";
		int caracter;
		for (int i = 0; i < mensaje.length(); i++) {
			if (mensaje.charAt(i) >= 'a' && mensaje.charAt(i) <= 'z') {
				caracter = mensaje.charAt(i) + clave;
				if (caracter > 'z') {
					caracter -= 26;
				}
				encriptado += (char) caracter;
			} else if (mensaje.charAt(i) >= 'A' && mensaje.charAt(i) <= 'Z') {
				caracter = mensaje.charAt(i) + clave;
				if (caracter > 'Z') {
					caracter -= 26;
				}
				encriptado += (char) caracter;
			} else {
				encriptado += mensaje.charAt(i);
			}
		}
		return encriptado;
	}

	/**
	 * Función que descifra un mensaje encriptado por sustitución pasado por
	 * parñametro La clave a pasar debe ser la misma que la de haberlo encriptado
	 * 
	 * @param encriptado - String a descifrar
	 * @param clave      - int posiciones a sustituir a la inversa de la sustitución
	 * @return String resultado de la sustitución inversa al cifrado
	 */
	public static String descifrarS(String encriptado, int clave) {
		String descifrado = "";
		int caracter;

		for (int i = 0; i < encriptado.length(); i++) {
			if (encriptado.charAt(i) >= 'a' && encriptado.charAt(i) <= 'z') {
				caracter = encriptado.charAt(i) - clave;
				if (caracter < 'a') {
					caracter += 26;
				}
				descifrado += (char) caracter;
			} else if (encriptado.charAt(i) >= 'A' && encriptado.charAt(i) <= 'Z') {
				caracter = encriptado.charAt(i) - clave;
				if (caracter < 'A') {
					caracter += 26;
				}
				descifrado += (char) caracter;
			} else {
				descifrado += encriptado.charAt(i);
			}
		}
		return descifrado;
	}

	/**
	 * Función que encripta un mensaje pasado por parámetro por transposición Junta
	 * caracteres ares en una cadena, impares en otra y concatena ambas
	 * 
	 * @param mensaje - String para cifrar
	 * @return String resultado de la concatenación de las dos cadenas alternas
	 */
	public static String transposicion(String mensaje) {
		String cad1 = "";
		String cad2 = "";

		for (int i = 0; i < mensaje.length(); i++) {
			if (i % 2 == 0) {
				cad1 += mensaje.charAt(i);
			}
			else {
				cad2 += mensaje.charAt(i);
			}
		}
		return cad1 + cad2;
	}

	/**
	 * Función que descifra un mensaje cifrado por transposición El mensaje había
	 * sido cifrado en dos cadena de caracteres pares e impares Concatenadas al
	 * final
	 * 
	 * @param cifrado - String cifrado por caracteres pares e impares
	 * @return String del mensaje revertido a su origen
	 */
	public static String descifrarT(String cifrado) {
		String descifrado="";
		int mitad = (cifrado.length() + 1) / 2;
		String cad1 = cifrado.substring(0, mitad);
		String cad2 = cifrado.substring(mitad);
		
		for (int i=0; i<cad1.length(); i++) {
			descifrado+=cad1.charAt(i);
			if (i<cad2.length())
			descifrado+=cad2.charAt(i);
		}
		return descifrado;
	}

	// Programa principal
	public static void main(String[] args) {

		// Variable para la palabra a cifrar
		String palabra;

		// Creamos lector
		Scanner sc = new Scanner(System.in);

		// Pedimos palabra para cifrar
		System.out.print("Introduce una palabra: ");
		palabra = sc.nextLine();
		sc.close();

		// Ciframos la palabra por sustitución CESAR
		String cesar = sustitucion(palabra, CESAR);

		// Ciframos la palabra pro sustitución ROT13
		String rot13 = sustitucion(cesar, ROT13);

		// Ciframos la palabra por transposición
		String riel = transposicion(rot13);

		// Desciframos la palabra por transposición
		String d1 = descifrarT(riel);

		// Desciframos la palabra por sustitución ROT13
		String d2 = descifrarS(d1, ROT13);

		// Desciframos la palabra por sustitución CESAR
		String d3 = descifrarS(d2, CESAR);
		
		// Mostramos mensajes
		System.out.println("Tu palabra en CESAR es: " + cesar);
		System.out.println("Tu palabra en CESAR + ROT13 es: " + rot13);
		System.out.println("Si volvemos a pasar ROT13 se revierte: "+sustitucion(rot13, ROT13));
		System.out.println("Tu palabra en CESAR + ROT13 + RIEL es: " + riel);
		System.out.println("El primer descifrado es: "+d1);
		System.out.println("El segundo descifrado es: "+d2);
		System.out.println("El tercer descifrado es: "+d3);

	}

}
