package ficheros.repaso;

import java.io.File;

public class FileExistePermisos {

	public static void main(String[] args) {
		
		// Pasamos una ruta de fichero para comprobar si existe
		File f = new File("/Users/jesusrodriguezmarin/Documents/ficherosEclipse/PruebaEscritura.txt");
		
		// Çomprobamos con .exit
		if (f.exists()) {
			System.out.println("El fichero existe.");
			
			// Si existe comprobamos los permisos que pueda tener
			if (f.canRead()) {
				System.out.println("Lectura");
			}
			
			if (f.canWrite())
				System.out.println("Escritura");
			
			if (f.canExecute())
				System.out.println("Ejecución");
			
		} else {
			System.out.println("El fichero no existe.");
		}

	}

}
