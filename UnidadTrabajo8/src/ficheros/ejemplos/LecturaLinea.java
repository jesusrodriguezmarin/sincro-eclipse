package ficheros.ejemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LecturaLinea {

	public static void main(String[] args) {
		// Creamos un objeto de la clase File
		File f = new File("C:/BD/MiFichero.txt");
		
		try {
			// Leemos un archivo linea a línea
			Scanner sc = new Scanner(f);
			String linea;
			
			// Para númerar las líneas
			int conta = 1;
			
			// Mientras haya líneas en el fichero 
			while (sc.hasNextLine()) {
				
				// la leemos 
				linea = sc.nextLine();
				
				// la mostramos
				System.out.println("("+conta+")"+linea);
				conta++;
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("Error: El archivo no existe.");
		}
		
		

	}

}
