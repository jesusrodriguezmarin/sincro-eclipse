package ficheros.repaso;

import java.io.FileReader;

public class FileLecturaCaracterScanner {

	public static void main(String[] args) {
		
		// Creamos dos objetos FileReader
		FileReader fr = null;
		FileReader tr = null;
		
		try {
			// Apertura del fichero
			fr = new FileReader("/Users/jesusrodriguezmarin/Documents/ficherosEclipse/PruebaEscritura.txt");
			
			// Lectura del fichero con .read()
			int valor = fr.read();
			
			// Recorremos para mostrar normal
			while (valor != -1) {
				System.out.print((char)valor);
				valor = fr.read();
			}
			
			
			// Apertura de nuevo del fichero para mostrar intercambiando case
			tr = new FileReader("/Users/jesusrodriguezmarin/Documents/ficherosEclipse/PruebaEscritura.txt");
			
			int valor2 = tr.read();
			// Recorremo otra vez e intercambiamos mayúsculas por minúsculas
			while (valor2 != -1) {
				
				//  Capturamos en caracter el valor de ese caracter actual
				char caracter = (char)valor2;
				if (caracter >= 65 && caracter <= 90) {
					caracter += 32;
				} else if (caracter >= 97 && caracter <= 122) {
					caracter -= 32;
				} 
				System.out.print(caracter);
				valor2 = tr.read();
			}
			
		} catch (Exception e) {
			System.out.println("Fichero no encontrado.");
		} finally {
			try {
				if (fr != null)
					fr.close();	
			} catch (Exception e2) {
				System.err.println("Error en el cierro del archivo");
			}
		}
		
	}

}
