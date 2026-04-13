package ficheros.repaso;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LecturaLineaRepaso {

	public static void main(String[] args) {

		// Creamos una instancia de File y asignamos el fichero
		File f = new File("/Users/jesusrodriguezmarin/Documents/ficherosEclipse/pruebaLectura.txt");

		try {
			// Creamos el scanner y leemos el fichero dentro del control de errores
			Scanner sc = new Scanner(f);
			
			// Creamos una variable iteración
			int i = 1;
			
			// Creamos un String para albergar las líneas que vamos a leer
			String linea;
			
			// Con scanner .hasNextLine buscamos si hay lineas en el fichero en bucle
			while (sc.hasNextLine()) {
				
				// Leemos la línea y la albergamos en el String linea
				linea = sc.nextLine();
				
				// Mostramos la línea de la iteración actual
				System.out.println("Línea "+i+") "+linea);
				
				// Avanzamos la iteración
				i++;
			}
			// Cerramos scanner
			sc.close();	
			
		} catch (FileNotFoundException e) {
			System.out.println("Error. El fichero no existe.");
		}
		
	}

}
