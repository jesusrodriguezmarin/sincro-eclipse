package strings.cifrado;

import java.util.Scanner;

public class CifradoMultiple {

	public static final int CLAVE = 3;

	/**
	 * Método que encripta un mensaje pasado por parámetro por sustitución
	 * 
	 * @param mensaje - String a encriptar
	 * @param clave   - int pasado por parámetro
	 * @return un String resultado de la sustitución tantas posiciones como la clave
	 *         indica
	 */
	public static String sustitucion(String mensaje, int clave) {

		// Variable para montar la nueva palabra (mensaje encriptado)
		String encriptado = "";

		// Recorremos el mensaje
		for (int i = 0; i < mensaje.length(); i++) {

			// Controlamos que está dentro del abecedario para concatenar
			if (mensaje.charAt(i) >= 'a' && mensaje.charAt(i) <= 'z') {
				// Variable para convertir el caracter actual en el caracter mas la clave
				int caracter = mensaje.charAt(i) + clave;
				// Controlamos que dentro del abecedario, con el + valor no se pase de z
				if ((char) caracter > 'z') {
					// Se hace circular
					caracter -= 26;
				}
				// Concatenamos
				encriptado += (char) caracter;
				// Seguimos en el for pasando al else si no está en minúsculas
			} else if (mensaje.charAt(i) >= 'A' && mensaje.charAt(i) <= 'Z') {
				// Variable para convertir el caracter actual en el caracter mas la clave
				int caracter = mensaje.charAt(i) + clave;
				if ((char) caracter > 'Z') {
					caracter -= 26;
				}
				// Concatenamos si es mayúscula
				encriptado += (char) caracter;
				// Seguimos en el for sino es minúscula ni mayúscula es carácter esp o núm
			} else {
				encriptado += mensaje.charAt(i);
			}
		}
		return encriptado;
	}

	/**
	 * Método que encripta un mensaje pasado por parámetro por el transposición
	 * Primero agrupa los pares, después los impares y finalmente concatena ambas
	 * cadenas
	 * 
	 * @param mensaje - String pasado por parámetro
	 * @return String resultado de concatenar dos String construidos por
	 *         transposición
	 */
	public static String transposicion(String mensaje) {
		String cad1 = "";
		String cad2 = "";
		for (int i = 0; i < mensaje.length(); i++) {
			if (i % 2 == 0) {
				cad1 += mensaje.charAt(i);
			} else {
				cad2 += mensaje.charAt(i);
			}
		}
		return cad1 + cad2;
	}

	/**
	 * Método que descifra un mensaje cifrado por sustitucion pasado por parámetro
	 * La clave para descifrar debe ser la misma que la de cifrar
	 * 
	 * @param encriptado - String cifrado
	 * @param clave      - clave similar a la clave de cifrado
	 * @return el mensaje descifrado tras desencriptar
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
	 * Método que devuelve un mensaje encriptado por transposición a su mensaje
	 * inicial
	 * 
	 * @param encriptado - String encriptado por transposición
	 * @return String mensaje original aterior a la encriptación
	 */
	public static String descifrarT(String encriptado) {

		// Variable para la mitad del mensaje para que no quede corto en la primera
		// cadena
		// que siempre será igual si es par o mayor si es impar en su primera mitad
		int mitad = (encriptado.length() + 1) / 2;

		// Variables para montar las dos cadenas originales
		String cad1 = encriptado.substring(0, mitad);
		String cad2 = encriptado.substring(mitad);

		// Variable para montar el mensaje final con una letra alterna de cada cadena
		String descifrado = "";

		// Recorremos el largo de la cad1 que siempre será igual o mayor a cad2
		for (int i = 0; i < cad1.length(); i++) {

			// Añadimos la letra de la primera mitad
			descifrado += cad1.charAt(i);

			// Añadimos la letra de la segunda mitad
			// Controlando no salirnos de la longitud
			if (i < cad2.length()) {
				descifrado += cad2.charAt(i);
			}
		}

		return descifrado;
	}

	// Programa principal
	public static void main(String[] args) {

		// Creamos un String para pedir a usuario una contraseña
		String mensaje = "";

		// Creamos lector
		Scanner sc = new Scanner(System.in);

		// Pedimos mensaje por teclado
		System.out.print("Introduce un mensaje para cifrar: ");
		mensaje = sc.nextLine();
		sc.close();

		// Llamamos a los métodos mostrando por consola
		System.out.println("Tu mensaje en Cesar es: " + sustitucion(mensaje, CLAVE));
		System.out.println("Tu mensaje en Riel es: " + transposicion(mensaje));

		// Asignamos el mensaje encriptado en Cesar una variable
		String cesar = sustitucion(mensaje, CLAVE);

		// Asignamos con el método de transposición pasando por parámetro el mensaje en
		// Cesar
		String riel = transposicion(cesar);

		// Mostramos riel como resultado de una doble encriptación
		// Sobre el primer encriptado cesar, encriptamos riel (encriptaciñon multiple)
		System.out.println("Tu mensaje en encriptación multiple es: " + riel);

		// Vamos a desencriptar primero riel
		String descifrado1 = descifrarT(riel);

		// Ahora desciframos con sustitución
		String descifradoTotal = descifrarS(descifrado1, CLAVE);

		// Mostramos los mensajes
		System.out.println("Tu primera desenciptación es: " + descifrado1);
		System.out.println("Tu mensaje descifrado totalmente es: " + descifradoTotal);

	}

}
