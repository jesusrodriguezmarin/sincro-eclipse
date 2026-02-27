package strings.ejercicios;

import java.util.Scanner;

public class FortalezaPassword_class {

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
	private static boolean esNum(char c) {
		if (c >= '0' && c <= '9')
			return true;
		return false;
	}

	// Programa principal
	public static void main(String[] args) {

		// 1. Mostramos el mensaje de ayuda
		mostrar();
		
		// 2. Pedimos al usuario la contraseña
		Scanner entrada = new Scanner(System.in);
		System.out.print("\nIntroduce password: ");
		String password = entrada.nextLine();
		entrada.close();
		
		// 3. Comprobamos la fortaleza
		System.out.print("Fortaleza del password: ");
		// 3.1 Si la longitud es menor de 8 caracteres, el DEBIL
		if (password.length()<8) {
			System.out.println("DEBIL");
		} else {
			// 3.2 En otro caso, recorremos comprobando el resto de caracteristicas
			char c;	// para abreviar el caracter del password según la iteración
			int contaMin, contaMay, contaNum, contaEsp;	// Variables contador
			contaMin=contaMay=contaNum=contaEsp=0;	// Inicializamos variables a 0
			
			// recorremos String password caracter a caracter
			for (int i=0; i<password.length(); i++) {
				c=password.charAt(i);	// Inicializamos variable al caracter ocurrente
				if (esMin(c))
					contaMin++;
				else if (esMay(c))
					contaMay++;
				else if (esNum(c))
					contaNum++;
				else
					contaEsp++;
			}
			// Variable para contear
			int cumple=0;
			if (contaMin>=1) cumple++;
			if (contaMay>=1) cumple++;
			if (contaNum>=1) cumple++;
			if (contaEsp>=1) cumple++;
			
			// 3.3 Informamos sobre la fortaleza
			if (cumple==4)
				System.out.println("EXCELENTE");
			else if (cumple==3)
				System.out.println("FUERTE");
			else
				System.out.println("MODERADA");
		}
			
	}

}
