package strings.ejercicios;

import java.util.Scanner;

public class FortalezaPassword {

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
	 * Función que determina si un String cumple con ciertas condiciones
	 * 
	 * @param pwd - String
	 * @return TRUE si cumple todas las condiciones, FALSE si no las cumple
	 *         CONDICIONES: contener minúscula, mayúscula, número (0-9) y caracter
	 *         especial
	 */
	public static boolean fuerte(String pwd) {
		if (pwd.length() < 8) {
			return false;
		}
		int conta = 0;
		boolean min = false;
		boolean may = false;
		boolean num = false;
		boolean esp = false;

		for (int i = 0; i < pwd.length(); i++) {

			char letra = pwd.charAt(i);

			if (letra >= 'a' && letra <= 'z') {
				min = true;
			} else if (letra >= 'A' && letra <= 'Z') {
				may = true;
			} else if (letra >= '0' && letra <= '9') {
				num = true;
			} else {
				esp = true;
			}
		}
		if (min == true) {
			conta++;
		}
		if (may == true) {
			conta++;
		}
		if (num == true) {
			conta++;
		}
		if (esp == true) {
			conta++;
		}
		if (conta == 3) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Función que determina si un String cumple con ciertas condiciones
	 * 
	 * @param pwd - String
	 * @return TRUE si cumple todas las condiciones, FALSE si no las cumple
	 *         CONDICIONES: contener minúscula, mayúscula, número (0-9) y caracter
	 *         especial
	 */
	public static boolean excelente(String pwd) {
		if (pwd.length() < 8) {
			return false;
		}
		int conta = 0;
		boolean min = false;
		boolean may = false;
		boolean num = false;
		boolean esp = false;

		for (int i = 0; i < pwd.length(); i++) {

			char letra = pwd.charAt(i);

			if (letra >= 'a' && letra <= 'z') {
				min = true;
			} else if (letra >= 'A' && letra <= 'Z') {
				may = true;
			} else if (letra >= '0' && letra <= '9') {
				num = true;
			} else {
				esp = true;
			}
		}
		if (min == true) {
			conta++;
		}
		if (may == true) {
			conta++;
		}
		if (num == true) {
			conta++;
		}
		if (esp == true) {
			conta++;
		}
		if (conta >= 4) {
			return true;
		} else {
			return false;
		}
		
	}

	// Programa principal
	public static void main(String[] args) {
		// Creamos un String para solicitar password al usuario
		String pwd = "";

		// Mostramos mensaje inicial
		mostrar();

		// Pedimos password al usuario
		Scanner sc = new Scanner(System.in);
		System.out.print("\nIntroduce password: ");
		pwd = sc.nextLine();
		sc.close();

		// Compobamos fortaleza
		if (excelente(pwd)) {
			System.out.println("--> Fortaleza del password: EXCELENTE");
		} else if (fuerte(pwd)) {
			System.out.println("--> Fortaleza del password: FUERTE");
		} else if (pwd.length() >= 8) {
			System.out.println("--> Fortaleza del password: MODERADA");
		} else if (pwd.length() < 8) {
			System.out.println("--> Fortaleza del password: DEBIL");
		}
	}

}
