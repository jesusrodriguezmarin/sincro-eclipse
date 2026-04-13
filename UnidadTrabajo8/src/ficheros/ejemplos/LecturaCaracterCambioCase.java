package ficheros.ejemplos;

import java.io.FileReader;

public class LecturaCaracterCambioCase {

	public static void main(String[] args) {
		
		// Creamos un objeto de FileReader inicializamos a null
		FileReader fr = null;
		
		// Necesitamos control de excepciones para crear el FileReader
		try {
			// Apertura del fichero
			fr = new FileReader("C:/BD/MiFichero.txt");
			
			// Lectura del fichero
			int valor = fr.read();
			
			// Muestra del fichero
			while (valor != -1) {
				// Si es mayúscula, cambiamos a minúscula
				// if (valor >= 65 && valor <= 90)
				if (valor >= 'A' && valor <= 'Z') {
					valor+=32;
				// Si es minúscula cambiamos a mayúscula
				} else if (valor >= 'a' && valor <= 'z') {
					valor-=32;
				}
				System.out.print((char)valor);
				valor = fr.read();
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
