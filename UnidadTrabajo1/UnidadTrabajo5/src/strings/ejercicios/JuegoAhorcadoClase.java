package strings.ejercicios;

import java.util.Scanner;

public class JuegoAhorcadoClase {

	/**
	 * Selecciona de forma aleatoria una palabra de un array de palabras
	 * 
	 * @return String
	 */
	private static String generar() {
		String array[] = { "ZANAHORIA", "CARPINTERO", "ESCALERA", "IMPRESORA", "GUITARRA" };

		return array[(int) (Math.random() * array.length)];
	}

	// Programa principal
	public static void main(String[] args) {

		// Constante
		final int TOTAL_INTENTOS = 10; // Nº total de intentos para el usuario

		// Variables
		int intentos = 0; // Nº de intentos utilizados
		String palabraAcertar = generar(); // Palabra que se debe acertar
		String palabraMostrar = ""; // Palabra que mostramos al usuario ***
		String cadena; // Cadena que va introduciendo el usuario
		char letra; // Letra a comprobar en acertar
		boolean acertada = false; // TRUE si el usuario acierta, FALSE si no

		// Generamos una palabra a mostrar con tantos * como caracteres tenga
		for (int i = 0; i < palabraAcertar.length(); i++) {
			palabraMostrar += "*";
		}

		System.out.println("Nº de letras de la palabra acertar: " + palabraAcertar.length());

		Scanner entrada = new Scanner(System.in);

		// Repetimos mientras queden intentos o no se acierte la palabra
		while (intentos < TOTAL_INTENTOS && !acertada) {
			// Mostramos por pantalla los mensajes de cada intento
			System.out.println("\nPalabra a acertar: " + palabraMostrar);
			System.out.println("Nº de intentos realizados: " + intentos);
			System.out.println("Nº de intentos restantes: " + (TOTAL_INTENTOS - intentos));

			// Pedimos al usuario que introduzca el caracter
			System.out.print("Introduce una letra: ");
			cadena = entrada.nextLine().toUpperCase();

			if (cadena.startsWith("RESUELVO:")) {
				// Si el usuario opta por resolver, comprobamos cadena en palabra acertar
				if (palabraAcertar.equals(cadena.substring(9)))
					acertada = true;
				else
					System.out.println("¡OHHHH! La palabra no es correcta.");
			} else {
				// Si el usuario no opta por resolver
				// Comprobamos si el caracter introducido se encuentra en la palabra
				letra = cadena.charAt(0);
				System.out.println("Letra introducida: " + letra);

				if (palabraAcertar.indexOf(letra) == -1) {
					System.out.println("¡OHHH! La letra " + letra + " no se encuentra en la palabra.");
				} else {
					// Hemos acertado una de las letras
					System.out.println("¡ACERTASTE! La letra " + letra + " está en la palabra.");
					// Sustituimos la letra acertada en la palabra acertar
					for (int i = 0; i < palabraAcertar.length(); i++) {
						if (palabraAcertar.charAt(i) == letra) {
							palabraMostrar = palabraMostrar.substring(0, i) + letra + palabraMostrar.substring(i + 1);
						}
					}
					// Si la palabraMostrar es igual que la palabraAcertar, la hemos acertado
					if (palabraAcertar.equals(palabraMostrar))
						acertada = true;
				}
			}
			// Incrementamos el número de intentos
			intentos++;

		}
		entrada.close();

		if (acertada) {
			System.out.println("\n¡CORRECTO! Has acertado la palabra! ¡Enhorabuena!");
			System.out.println("Acertaste la palabra en " + intentos + " intentos");
		} else {
			System.out.println("\n¡Ohhhh! Has agotado el número de intentos");
			System.out.println("La palabra es: " + palabraAcertar);
		}
	}

}
