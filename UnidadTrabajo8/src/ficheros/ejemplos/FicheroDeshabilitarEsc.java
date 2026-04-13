package ficheros.ejemplos;

import java.io.File;

public class FicheroDeshabilitarEsc {

	public static void main(String[] args) {
		File f = new File("C:/BD/MiFichero.txt");
		if (!f.exists()) {
			System.out.println("El archivo: " + f.getName() + " no existe");
		} else {
			if (f.canWrite()) {
				System.out.println("El archivo existe y permite escritura.");
			}
			// Deshabilitamos el permiso de escritura
			if (f.setWritable(false)) {
				System.out.println("Deshabilitamos el permiso de escritura del archivo: "+f.getName());
			} else {
				System.out.println("La operación ha fallado");
				System.out.println("El usuario no tiene permisos");
			}
			
			if (f.canWrite()) {
				System.out.println("Podemos escribir en el fichero: "+f.getName());
			} else {
				System.out.println("No podemos escibir en el fichero: "+f.getName());
			}
				
		}

	}

}
