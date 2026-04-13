package ficheros.ejemplos;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscrituraTeclado {

	public static void main(String[] args) {
		// Creamos un FileWriter
		FileWriter fw = null;
		
		// Creamos un PrintWriter
		PrintWriter pw = null;
		
		try {
			// Si el archivo no existe lo crea, si existe lo sobreescribe
			fw = new FileWriter("C:/BD/FicheroEscritura2.txt");
			pw = new PrintWriter(fw);
			
			// Escritura de un fichero por teclado
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce texto (para finalizar teclea FIN): ");
			String cadena = sc.nextLine();
			
			while (!cadena.equalsIgnoreCase("FIN")) {
				pw.println(cadena);
				cadena = sc.nextLine();
			}
			System.out.println("Has finalizado la inteoducción de texto.");
			System.out.println("Abre el archivo para verificar tu texto.");
			sc.close();
			
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
