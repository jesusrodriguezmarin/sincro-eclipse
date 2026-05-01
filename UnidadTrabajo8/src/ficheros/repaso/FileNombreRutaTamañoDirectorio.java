package ficheros.repaso;

import java.io.File;

public class FileNombreRutaTamañoDirectorio {

	public static void main(String[] args) {

		// Creamos un objeto File con una ruta en parámetro
		File f = new File("/Users/jesusrodriguezmarin/Documents/ficherosEclipse/PruebaEscritura.txt");

		// Comprobamos si existe y mostramos ruta y nombre con getters
		if (!f.exists()) {
			System.out.println("No existe");
		} else {
			System.out.println("Existe!");
			System.out.println("Directorio: "+f.getParent());
			System.out.println("Ruta: " + f.getPath());
			System.out.println("Nombre: " + f.getName());
			System.out.println("Bytes: "+f.length());
		}

	}

}
