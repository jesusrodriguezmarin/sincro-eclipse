package strings.ejercicios;

import java.util.Scanner;

public class FortalezaPassword_funciones {

	private static void mostrar() {
		System.out.println(" ------------------------------------------------------------------");
		System.out.println("| Fortaleza de un password:                                        |");
		System.out.println("|   --> DEBIL: si contiene menos de 8 caracteres                   |");
		System.out.println("|   --> MODERADA: si contiene, al menos, 8 caracteres              |");
		System.out.println("|   --> FUERTE: si contiene como mínimo 8 caracteres y             |");
		System.out.println("|               cumple con tres de las siguientes condiciones:     |");
		System.out.println("|                   - 1 minúscula                                  |");
		System.out.println("|                   - 1 mayúscula                                  |");
		System.out.println("|                   - 1 número (del 0 al 9)                        |");
		System.out.println("|                   - 1 caracter especial                          |");
		System.out.println("|   --> EXCELENTE: si contiene como mínimo 8 caracteres y          |");
		System.out.println("|                  cumple todas las condiciones anteriores         |");
		System.out.println(" ------------------------------------------------------------------");
	}

	/**
	 * Indica si el caracter pasado como parámetro es una letra minúscula
	 * 
	 * @param c - caracter
	 * @return TRUE si c es minúscula, FALSE si no lo es
	 */
	private static boolean esMin(char c) {
		if (c >= 'a' && c <= 'z')
			return true;
		return false;
	}

	/**
	 * Indica si un caracter pasado como parámetro es una letra mayúscula
	 * 
	 * @param c - caracter a comprobar
	 * @return TRUE si es una letra mayúscula, FALSE si es una letra minúscula
	 */
	private static boolean esMay(char c) {
		if (c >= 'A' && c <= 'Z')
			return true;
		return false;
	}

	/**
	 * Indica si un caracter pasado como parámetro es un número entre 0 y 9
	 * 
	 * @param c - caracter pasado por parámetro
	 * @return TRUE si es un número, FALSE si no lo es
	 */
	private static boolean num(char c) {
		if (c >= '0' && c <= '9')
			return true;
		return false;
	}

	// Programa principal
	public static void main(String[] args) {

		// Mostramos mensaje
		mostrar();

		// Declaramos un String para pedir al usuario
		String password = "";
		
		// Pedimos al usuario
		Scanner sc = new Scanner(System.in);
		System.out.print("\nIntroduce un password: ");
		password = sc.nextLine();
		sc.close();
		
		// Variables bandera
		boolean min=false;
		boolean may=false;
		boolean nume=false;
		boolean esp=false;
		int conta=0;

		// Comprobamos fortaleza
		for (int i=0; i<password.length(); i++) {
			char c = password.charAt(i);
			if (esMin(c)){
				min=true;
			} else if (esMay(c)) {
				may=true;
			} else if (num(c)) {
				nume=true;
			} else {
				esp=true;
			}
		}
		// Hacemos el recuento con el contador
		if (min==true)
			conta++;
		if (may==true)
			conta++;
		if (nume==true)
			conta++;
		if (esp==true)
			conta++;
		
		// Contamos para mostrar el mensaje
		if (conta==4 && password.length()>=8) {
			System.out.println("--> Fortaleza del password: EXCELENTE");
		} else if (conta==3 && password.length()>=8) {
			System.out.println("--> Fortaleza del password: FUERTE");
		} else if (password.length()>=8) {
			System.out.println("--> Fortaleza del password: MODERADA");
		} else {
			System.out.println("--> Fortaleza del password: DEBIL");
		}
			
	}

}
