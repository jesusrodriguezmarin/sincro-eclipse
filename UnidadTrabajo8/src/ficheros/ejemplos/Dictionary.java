package ficheros.ejemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionary {

	public static void main(String[] args) {

		// Pedimos palabra al usuario para traducir
		Scanner sc = new Scanner(System.in);
		System.out.print("Search word: ");
		String palabra = sc.nextLine();
		sc.close();

		// 2. Buscamos la palabra en el archivo que tenemos
		File f = new File("C:/BD/dictionary.txt");

		// Declaramos una variable para encontrar
		boolean encontrado = false;

		try {
			// Creamos otro scanner
			Scanner s = new Scanner(f);
			String linea;

			while (s.hasNextLine() && !encontrado) {
				linea = s.nextLine();

				// Comprobamos con compareTo que nos da 0 si son iguales o -1 si no lo son
				String p1 = linea.substring(0, linea.indexOf('='));
				if (p1.compareToIgnoreCase(palabra) == 0) {
					String traduccion = linea.substring(linea.indexOf('=') + 1);
					encontrado = true;

					// 3. Indicamos si se ha encontrado la palabra o no
					System.out.print("Traslation: ");

					if (encontrado) {
						System.out.println(traduccion);
					} else {
						System.out.println("Sorry, not found");
					}
				}
			}
			s.close();

		} catch (FileNotFoundException e) {
			System.err.println("> Error en el archivo, no existe.");
		}
	}

}
