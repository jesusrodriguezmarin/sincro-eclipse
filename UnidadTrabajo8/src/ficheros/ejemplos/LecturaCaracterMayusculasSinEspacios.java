package ficheros.ejemplos;

import java.io.BufferedReader;
import java.io.FileReader;

public class LecturaCaracterMayusculasSinEspacios {

	public static void main(String[] args) {

		// Creamos un objeto de FileReader inicializamos a null
		FileReader fr = null;

		// Creamos un clase BufferedReader
		BufferedReader br = null;

		// Necesitamos control de excepciones para crear el FileReader
		try {
			// Apertura del fichero
			fr = new FileReader("C:/BD/MiFichero.txt");

			// Creamos un bufferedReader a partir del FileReader
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea = br.readLine();

			// Muestra del fichero
			while (linea != null) {
				// Convertimos todo a mayúsculas con .toUpperCase() y quitamos espacios con .replace()
				System.out.println(linea.toUpperCase().replace(" ", ""));
				linea = br.readLine();
			}

			// Controlamos la excepcion con la creación del FileReader
		} catch (Exception e) {
			System.err.println("Se ha producido un error con el archivo especificado");
		} finally {
			// Controlamos la excepcion del cierre
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				System.err.println("Error en el cierre del archivo");
			}

		}

	}

}
