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
		File f = new File("/Users/jesusrodriguezmarin/Documents/ficherosEclipse/dictionary.txt");

		// Declaramos una variable para encontrar
		boolean encontrado = false;

		try {
			// Creamos otro scanner
			Scanner s = new Scanner(f);
			String linea;

			// Mientras haya una línea y no se haya encontrado
			while (s.hasNextLine() && !encontrado) {
				
				// Guarda esa línea en una variable
				linea = s.nextLine();

				// De la línea completa cogemos solo la primera parte desde 0 hasta = sin incluirlo
				String p1 = linea.substring(0, linea.indexOf('='));
				
				// Declaramos variable para asignar la segunda parte de la línea como traduccion
				String traduccion  = "";
				
				// Comprobamos con compareTo, nos da 0 si son iguales o -1 si no lo son
				if (p1.compareToIgnoreCase(palabra) == 0) {
					
					// Son iguales, "se traduce" cogiendo la otra parte de la línea
					traduccion = linea.substring(linea.indexOf('=') + 1);
					
					// Validamos encontrado
					encontrado = true;

					// 3. Indicamos si se ha encontrado la palabra o no
					System.out.print("Traslation: ");

					if (encontrado) 
						System.out.println(traduccion);
				}
			}
			// Si llega aquí y no se ha encontrado muestra el mensaje
			if (!encontrado)
				System.out.println("Sorry, not found");
			
			
			s.close();

		} catch (FileNotFoundException e) {
			System.err.println("> Error en el archivo, no existe.");
		}
	}

}
