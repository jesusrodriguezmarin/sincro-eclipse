package ficheros.ejemplos;

import java.io.FileWriter;
import java.io.PrintWriter;

public class EscrituraBasica {

	public static void main(String[] args) {
		// Creamos un FileWriter
		FileWriter fw = null;
		
		// Creamos un PrintWriter
		PrintWriter pw = null;
		
		try {
			// Si el archivo no existe lo crea, si existe lo sobreescribe
			fw = new FileWriter("C:/BD/FicheroEscritura.txt");
			pw = new PrintWriter(fw);
			
			// Escritura de un fichero
			pw.println("Prueba de escritura:\n ");
			for (int i = 0; i <= 10; i++) {
				pw.println("Linea "+i);
			}
			
		} catch (Exception e) {
			System.err.println("Se ha producido un error en el archivo especificado.");
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (Exception e2) {
				System.err.println("Error en el cierre del archivo.");
			}
		}

	}

}
