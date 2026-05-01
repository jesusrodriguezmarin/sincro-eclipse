package ficheros.repaso;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileLecturaLineaScanner {

	public static void main(String[] args) {
		
		// Creamos objeto File
		File f = new File("/Users/jesusrodriguezmarin/Documents/ficherosEclipse/PruebaEscritura.txt");
		
		try {
			// Creamos el lector y le pasamos el objeto File como parámetro
			Scanner sc = new Scanner(f);
			
			// Bucle para recorrer el texto línea a línea
			while (sc.hasNextLine()) {
				// Guardamos esa línea en una variable para usar nextLine una única vez
				String linea = sc.nextLine();
				
				// Mostramos en mayúsculas
				System.out.println(linea.toUpperCase());
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		}
	}

}
