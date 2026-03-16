package ejercicios;

import java.util.Scanner;

public class AhorcadoPOOtest {

	public static void main(String[] args) {

		// Creamos un objeto
		AhorcadoPOO a = new AhorcadoPOO();

		// Mostramos
		System.out.println("Número de letras de la palabra acertar: " + a.getNumLetrasPalabra());

		Scanner sc = new Scanner(System.in);
		char letra;
		String cadena;

		while (!a.isAcertada() && a.getIntentos() < a.TOTAL_INTENTOS) {

			System.out.println("\nPalabra a acertar: " + a.getPalabraMostrar());
			System.out.println("Número de intentos realizados: " + a.getIntentos());
			System.out.println("Número de intentos restantes: " + (a.TOTAL_INTENTOS - a.getIntentos()));

			System.out.print("Introduce una letra: ");
			cadena = sc.nextLine().toUpperCase();
			letra=cadena.charAt(0);
			
			if (cadena.startsWith("RESUELVO:")) {
				if (a.resolver(cadena.substring(9))) {
					System.out.println("\n¡HAS ACERTADO!");
				} else {
					System.out.println("\n¡OHHH! La letra introducida no es correcta.");
				}
			} else {
				if (a.intentar(letra)) {
					System.out.println("¡ACERTASTE! La letra " + letra + " se encuentra en la cadena");
				} else {
					System.out.println("¡OHHH! La letra " + letra + " no se encuentra en la cadena");
				}
				
			}

		}

		if (a.isAcertada()) {
			System.out.println("\n¡CORRECTO! Has acertado la palabra, ¡Enhorabuena!");
			System.out.println("Acertaste la palabra en "+a.getIntentos()+" intentos.");
		} else {
			System.out.println("\n¡OHHH! Has agotado el número de intentos.");
		}
		
		System.out.println("La palabra es: "+a.getAcertar());
		sc.close();

	}

}
