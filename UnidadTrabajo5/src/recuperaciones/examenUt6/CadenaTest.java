package recuperaciones.examenUt6;

import java.util.Scanner;

public class CadenaTest {

	public static void main(String[] args) {

		char esp = ' ';

		// Creamos un scanner
		Cadena cad = new Cadena();

		Scanner tcl = new Scanner(System.in);
		System.out.print("Introduce un nombre: ");
		cad.setCadena(tcl.nextLine());

		System.out.println("> Nombre original: " + cad.getCadena());
		System.out.println("> Nombre en mayúscula: " + cad.mayusculas());
		System.out.println("> Nombre en minúsculas: " + cad.minusculas());
		System.out.println("> Nombre invertido: " + cad.invertir());
		System.out.println("> Número de caracteres: " + cad.longitud());
		System.out.println("> Número de vocales: " + cad.contarVocales());
		System.out.println("> Número de consonantes: " + cad.contarConsonantes());
		cad.reemplazar('p', 'v');
		System.out.println("> Reemplace: "+ cad.getCadena());

		System.out.print("\nEscribe un caracter: ");
		char letra = tcl.nextLine().charAt(0);

		if (cad.contarLetra(letra) == 0) {
			System.out.print("\n> No se han encontrado ocurrencias del caraceter '" + letra + "' en el nombre");
		} else {
			String nueva = cad.getCadena().replace(letra, esp);
			cad.setCadena(nueva);
			
			System.out.println("> Reemplazamos el carácter '" + letra + "' por espacios en blanco: "
					+ cad.getCadena());
			System.out.println("> Eliminamos espacios en blanco: " + cad.getCadena().replace(" ", ""));

		}

		tcl.close();

	}

}
