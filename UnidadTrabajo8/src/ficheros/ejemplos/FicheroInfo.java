package ficheros.ejemplos;

import java.io.File;

public class FicheroInfo {

	public static void main(String[] args) {

		// Creamos un objeto File
		File f = new File("C:/BD/MiFichero.txt");
		if (f.exists()) {
			System.out.println("El archivo existe");
			System.out.println("Nombre del archivo: " + f.getName());
			System.out.println("Directorio padre: " + f.getParent());
			System.out.println("Ruta: " + f.getPath());
			System.out.println("Tamaño: " + f.length() + " bytes");
			System.out.println("Permisos: ");

			if (f.canRead()) {
				System.out.print("r");
			} else {
				System.out.print("-");
			}
			if (f.canWrite()) {
				System.out.print("w");
			} else {
				System.out.print("-");
			}
			if (f.canExecute()) {
				System.out.print("x");
			} else {
				System.out.print("-");
			}
		} else {
			System.out.print("El archivo no existe");
		}

	}

}
