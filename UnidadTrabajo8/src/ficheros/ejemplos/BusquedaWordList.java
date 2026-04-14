package ficheros.ejemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BusquedaWordList {

	public static void main(String[] args) {
		
		// 1. Pedimos una palabra al usuario
		Scanner sc = new Scanner(System.in);
		System.out.print("Palabra a buscar: ");
		String palabra = sc.nextLine();
		sc.close();
		
		// 2. Buscamos la palabra en el archivo que tenemos
		File f = new File("C:/BD/wordlist.txt");
		
		// Declaramos una variable para encontrar
		boolean encontrado = false;
		
		try {
			// Creamos otro scanner
			Scanner s = new Scanner(f);
			String linea; 
			
			while (s.hasNextLine() && !encontrado) {
				linea = s.nextLine();
				
				// Comprobamos con compareTo que nos da 0 si son iguales o -1 si no lo son
				if (linea.compareToIgnoreCase(palabra) == 0) {
					encontrado = true;
				}
			}
			s.close();
			
			// 3. Indicamos si se ha encontrado la palabra o no
			
			System.out.print("La palabra: "+palabra.toLowerCase()+" ");
			if (encontrado) {
				System.out.println("Si se ha encontrado");
			} else {
				System.out.println("No se ha encontrado");
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("> Error en el archivo, no existe.");
		}

	}

}
