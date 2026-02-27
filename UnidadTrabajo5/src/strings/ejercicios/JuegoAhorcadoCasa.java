package strings.ejercicios;

import java.util.Scanner;

public class JuegoAhorcadoCasa {

	/**
	 * Selecciona de forma aleatoria una palabra de un array de palabras
	 * 
	 * @return String
	 */
	private static String palabras() {
		String array[] = { "ZANAHORIA", "CARPINTERO", "ESCALERA", "IMPRESORA", "GUITARRA" };

		return array[(int) (Math.random() * array.length)];
	}

	// Programa principal
	public static void main(String[] args) {

		// Constante para el número de intentos
		final int TOTAL = 10;

		// Variable para el total de intentos
		int realizados = 0;
		int restantes = TOTAL;

		// Creamos String para almacenar la palabra generada
		String acertar = palabras();

		// Creamos un StringBuilder para rellenar con asteriscos
		StringBuilder guardar = new StringBuilder();

		// Rellenamos la palabra a guardar con asteriscos
		for (int i = 0; i < acertar.length(); i++) {
			guardar.append("*");
		}

		// Creamos lector
		Scanner sc = new Scanner(System.in);

		// Cramos auxiliar para los caracteres introducidos por teclado
		String aux;

		// Informamos al usuario
		System.out.println("Nº de letras de la palabra a acertar: " + acertar.length());

		// Boolean para el mensaje final
		boolean fin = false;

		do {
			// Mostramos mensaje de palabra a acertar y pedimos letra
			System.out.println("\nPalabra a acertar: " + guardar);
			System.out.println("Nº intentos realizados: " + realizados);
			System.out.println("Nº intentos restantes: " + restantes);
			System.out.print("Introduce una letra: ");
			aux = sc.nextLine();

			// Mostramos mensaje ganador por resuelta directa
			if (aux.equalsIgnoreCase("RESUELVO:" + acertar)) {
				System.out.println("\n¡CORRECTO! ¡Has acertado la palabra! ¡ENHORABUENA!");
				System.out.println("Acertaste la palabra en " + (realizados + 1) + " intentos.");
				System.out.println("La palabra es: " + acertar);
				fin = true;
			} else {

				// Variable para mostrar aciertos
				boolean acierto = false;

				// Recorremos el String comparando el caracter introducido por teclado
				for (int i = 0; i < acertar.length(); i++) {
					if (acertar.charAt(i) == aux.toUpperCase().charAt(0)) {
						guardar.setCharAt(i, aux.toUpperCase().charAt(0));
						acierto = true;
					}
				}

				if (acierto) {
					System.out.println("¡ACERTASTE! La letra " + aux + " se encuentra en la cadena.");
				} else {
					System.out.println("¡OHHHH! La letra " + aux + " no se encuentra en la cadena.");
				}

				// Mostramos mensaje ganador
				if (acertar.equals(guardar.toString())) {
					System.out.println("\n¡CORRECTO! ¡Has acertado la palabra! ¡ENHORABUENA!");
					System.out.println("Acertaste la palabra en " + (realizados + 1) + " intentos.");
					System.out.println("La palabra es: " + acertar);
					fin = true;
				}

			}
			realizados++;
			restantes--;

		} while (realizados <= 10 && fin == false);

		// Mostramos el fin del juego
		if (!fin && realizados>10) {
			System.out.println("\nGAME OVER!!! No te quedan intentos, la palabra es: "+acertar);
		}

		sc.close();
	}

}
