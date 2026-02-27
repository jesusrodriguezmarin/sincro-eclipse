// Leer un char y eliminar un carácter

package strings.arrays;

import java.util.Scanner;

public class EjerTipoExamenEliminarChar {

	/**
	 * Función que devuelve una cadena de caracteres donde se ha eliminado un caracter
	 * @param cadena - String original
	 * @param caracter - a eliminar
	 * @return cadena de caracteres (String) sin el caracter
	 */
	private static String elimina(String cadena, char caracter) {
		String resultado="";
		for (int i=0; i<cadena.length(); i++) {
			if (cadena.charAt(i)!=caracter) {
				resultado+=cadena.charAt(i);
			}
		}
		return resultado;
	}
	
	public static void main(String[] args) {

		// Creamos lector
		Scanner sc = new Scanner(System.in);

		// Pedimos nombre al usuario
		System.out.print("Introduce tu nombre: ");
		String nombre = sc.nextLine();

		// Pedimos nombre al usuario
		System.out.print("Dime un caráceter a eliminar: ");
		char c = sc.nextLine().charAt(0);
		sc.close();

		// Eliminamos el carácter del nombre
		System.out.println("Nombre sin '"+c+"': "+elimina(nombre, c));
		
	}

}
