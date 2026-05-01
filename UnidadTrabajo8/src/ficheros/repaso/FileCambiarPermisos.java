package ficheros.repaso;

import java.io.File;

public class FileCambiarPermisos {

	public static void main(String[] args) {

		// Creamos objeto File
		File f = new File("/Users/jesusrodriguezmarin/Documents/ficherosEclipse/PruebaEscritura.txt");

		// Comprobamos los permisos actuales
		if (!f.exists()) {
			System.out.println("Archivo no existente");
		} else {
			System.out.println("El archivo " + f.getName() + ", se encuentra en: " + f.getPath());

			// permisos
			System.out.print("Lectura: ");
			if (f.canRead()) {
				System.out.println("Permitido.");
			} else {
				System.out.println("Denegado.");
			}

			System.out.print("Escritura: ");
			if (f.canWrite()) {
				System.out.println("Permitido.");
			} else {
				System.out.println("Denegado.");
			}

			System.out.print("Ejecución: ");
			if (f.canExecute()) {
				System.out.println("Permitido.");
			} else {
				System.out.println("Denegado.");
			}
		}

		// Cambiamos los permisos
		f.setReadable(false);
		f.setWritable(false);
		f.setExecutable(false);

		// Comprobamos los permisos de nuevo
		// permisos
		System.out.print("Lectura: ");
		if (f.canRead()) {
			System.out.println("Permitido.");
		} else {
			System.out.println("Denegado.");
		}

		System.out.print("Escritura: ");
		if (f.canWrite()) {
			System.out.println("Permitido.");
		} else {
			System.out.println("Denegado.");
		}

		System.out.print("Ejecución: ");
		if (f.canExecute()) {
			System.out.println("Permitido.");
		} else {
			System.out.println("Denegado.");
		}

		// Cambiamos los permisos
		f.setReadable(true);
		f.setWritable(true);
		f.setExecutable(true);

		// Comprobamos los permisos de nuevo
		// permisos
		System.out.print("Lectura: ");
		if (f.canRead()) {
			System.out.println("Permitido.");
		} else {
			System.out.println("Denegado.");
		}

		System.out.print("Escritura: ");
		if (f.canWrite()) {
			System.out.println("Permitido.");
		} else {
			System.out.println("Denegado.");
		}

		System.out.print("Ejecución: ");
		if (f.canExecute()) {
			System.out.println("Permitido.");
		} else {
			System.out.println("Denegado.");
		}
	}

}
