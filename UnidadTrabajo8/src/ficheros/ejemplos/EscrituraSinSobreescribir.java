package ficheros.ejemplos;

import java.io.FileWriter;
import java.io.PrintWriter;

public class EscrituraSinSobreescribir {

	public static void main(String[] args) {
		// Creamos un FileWriter
		FileWriter fw = null;
		
		// Creamos un PrintWriter
		PrintWriter pw = null;
		
		try {
			// Si el archivo no existe lo crea, si existe le añade con true
			fw = new FileWriter("C:/BD/FicheroEscritura.txt", true);
			pw = new PrintWriter(fw);
			
			// Escritura de un fichero
			pw.println("\nAñadimos esta línea!");
			
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
