package strings.ejercicios;

import java.util.Scanner;

public class JuegoAhorcadoCasa_v2 {

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

		// Declaramos un String para la palabra adivinar
		// Inicializamos con palabras() aleatorias
		String adivinar = palabras();

		// Declaramos un String para la palabra mostrar
		String mostrar = "";

		// Declaramos la palabra mostrar y la inicializamos con asteriscos
		for (int i = 0; i < adivinar.length(); i++) {
			mostrar += "*";
		}

		// Declaramos un char para pedir por teclado
		String letra;

		// Creamos lector
		Scanner sc = new Scanner(System.in);

		// Constante para intentos
		final int TOTAL = 10;

		// Variables para intentos
		int realizados = 0;
		int restantes = TOTAL;

		// Varianle para fin
		boolean fin = false;

		// Mostramos el mensaje inicial
		System.out.println("Nº de letras de la palabra a acertar: " + adivinar.length());

		do {
			// Pedimos el caracter por teclado tantas veces como intentos TOTAL
			System.out.println("\nPalabra a acertar: " + mostrar);
			System.out.println("Nº de intentos realizados: " + realizados);
			System.out.println("Nº de intentos restantes: " + restantes);
			System.out.print("Introduce una letra: ");
			letra = sc.nextLine().toUpperCase();

			// Si resuelve se muestra este mensaje y finaliza
			if (letra.equalsIgnoreCase("RESUELVO: " + adivinar)) {
				System.out.println("\n¡CORRECTO! ¡Has acertado la palabra! ¡ENHORABUENA!");
				System.out.println("Acertaste la palabra en " + (realizados + 1) + " intentos.");
				System.out.println("La palabra es: " + adivinar);
				fin = true;
				
			// Si no resuelve y no acierta letra se muestra este mensaje
			} else if (adivinar.indexOf(letra.charAt(0)) == -1) {
				System.out.println("¡OHHHHH! La letra " + letra + " no se encuentra en la cadena.");
			
			// Si no resuleve pero si acierta letra, la añadimos a mostrar concatenando .substring
			} else {
				// Recorremos el String adivinar como un array caracter a caracter
				// Vamos creando la palabra mostrar en cada iteración para un mismo caracter
				for (int i = 0; i < adivinar.length(); i++) {
					if (adivinar.charAt(i) == letra.charAt(0)) {
						// Generamos una subcadena hasta la letra, concatenamos la letra y otra
						// subcadena
						mostrar = mostrar.substring(0, i) + letra + mostrar.substring(i + 1);
					}
				}
				// Si al salir de la actualización de mostrar la palabra es correcta mostramos y fin
				if (adivinar.equals(mostrar)) {
					System.out.println("\n¡CORRECTO! ¡Has acertado la palabra! ¡ENHORABUENA!");
					System.out.println("Acertaste la palabra en " + (realizados + 1) + " intentos.");
					System.out.println("La palabra es: " + adivinar);
					fin = true;
				}
				// Si la palabra no está completa aún mostramos acierto y seguimos
				if (!fin)
				System.out.println("¡ACERTASTE! La letra " + letra + " se encuentra en la cadena.");
			}
			// Sumamos realizados y restamos restantes
			realizados++;
			restantes--;

		} while (restantes <= 10 && restantes >= 0 && !fin);
		sc.close();

		// Si no quedan intentos y no ha salido con fin, mostramos mensaje de GAME OVER
		if (!fin)
			System.out.println("\nGAME OVER! Te quedaste sin intentos: "+(restantes+1));
	}

}
