package recuperaciones.examenUt5;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		// Pedimos un nombre al usuario
		String nombre;
		Scanner tcl = new Scanner(System.in);
		System.out.print("Introduce tu nombre: ");
		nombre = tcl.nextLine();

		// Creamos un StringBuffer
		StringBuffer cad = new StringBuffer(nombre);

		System.out.println("\n> Nombre del revés: " + cad.reverse());

		// Cambiamos las vocales a mayusculas
		for (int i = 0; i < nombre.length(); i++) {
			if (nombre.charAt(i) == 'a' || nombre.charAt(i) == 'e' || nombre.charAt(i) == 'i' || nombre.charAt(i) == 'o'
					|| nombre.charAt(i) == 'u') {
				nombre.toUpperCase();
			}
		}
		System.out.print("Vocales en mayusculas: " + nombre);

		// pedimos un caracter y lo reemplazamos a por espacios en blanco
		String caracter;
		
		System.out.print("\nEscribe un caracter (a-z | A-Z): ");
		
		caracter = tcl.nextLine();
		for (int i = 0; i < nombre.length(); i++) {
			{
				if (cad.charAt(i) == caracter.charAt(0)) {
					cad.setCharAt(i, ' ');
				}
			}
		}

		tcl.close();

		// Eliminamos los espacios en blanco
		for (int i = cad.length()-1; i>=0; i--) {
			if (cad.charAt(i) == ' ') {
				cad.deleteCharAt(i);
			}
		}
		System.out.println("Eliminamos los espacios" + cad);
	}

}
