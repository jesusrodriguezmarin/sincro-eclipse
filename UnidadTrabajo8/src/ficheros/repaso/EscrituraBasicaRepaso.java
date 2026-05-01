package ficheros.repaso;

import java.io.FileWriter;
import java.io.PrintWriter;

public class EscrituraBasicaRepaso {

	public static void main(String[] args) {
		
		// Creamos un objeto FileWriter
		FileWriter fw = null;
		
		// Creamos un objeto PrintWriter
		PrintWriter pw = null;
		
		try {
			// Creamos el archivo
			fw = new FileWriter("/Users/jesusrodriguezmarin/Documents/ficherosEclipse/Prueba3Escritura.txt");
			pw = new PrintWriter(fw);
			
			// Damos nombre al archivo
			pw.println("Tercera prueba de Escritura: ");
			
			for (int i = 1; i <= 10; i++) {
				pw.println("Partes: "+i);
			}
			
			
		} catch (Exception e) {
			System.err.println("Se ha producido un error en el archivo.");
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
