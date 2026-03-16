package estudioCasa;

import java.util.Scanner;

public class FortalezaCharacter {

	/**
	 * Procedimiento que muestra información para generar una contraseña al usuario
	 */
	public static void mostrar() {
		System.out.println(" -----------------------------------------------------");
		System.out.println("| Fortaleza de un password:                           |");
		System.out.println("| --> DEBIL: Si contiene menos de 8 caracteres        |");
		System.out.println("| --> MODEREADA: Si contiene al menos, 8 caracteres   |");
		System.out.println("| --> FUERTE: Si contiene como mínimo 8 caracteres    |");
		System.out.println("|             y cumple con al menos 3 coniciones:     |");
		System.out.println("|       - 1 minúscula                                 |");
		System.out.println("|       - 1 mayúscula                                 |");
		System.out.println("|       - 1 número (0 al 9)                           |");
		System.out.println("|       - 1 caracter especial                         |");
		System.out.println("| --> EXCELENTE: Si contiene como mínimo 8 caracteres |");
		System.out.println("|                 y cumple con las 4 coniciones.      |");
		System.out.println(" -----------------------------------------------------");
	}

	/**
	 * Función que registra cuantas condiciones cumple un String pasado por parámetro
	 * @param s - String pasado por parámetro
	 * @return int de 1 a 4 según cumpla 1,2,3 o 4 caracteristicas
	 */
	public static int conta(String s) {
		int min = 0, may = 0, num = 0, esp = 0;
		int conta = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLowerCase(s.charAt(i))) {
				if (min==0)
					min++;
			} else if (Character.isUpperCase(s.charAt(i))) {
				if (may==0)
					may++;
			} else if (Character.isDigit(s.charAt(i))) {
				if (num==0)
					num++;
			} else {
				if (esp==0)
					esp++;
			}
		}
		conta = (min+may+num+esp);
		return conta;
	}

	// Programa principal
	public static void main(String[] args) {

		// Creamos variable para almacenar la contraseña
		String pass = "";

		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Mostramos la información inicial
		mostrar();

		// Pedimos contraseña al usuario
		System.out.print("\nIntroduce un password: ");
		pass = sc.nextLine();
		sc.close();

		// Comunicamos fortaleza de la contraseña
		System.out.print("|--> fortaleza del password: ");
		
		int longpass= pass.length();
		int condiciones= conta(pass);

		if (longpass >= 8 && (condiciones) == 4) {
			System.out.println("EXCELENTE");
		} else if (longpass >= 8 && (condiciones) == 3) {
			System.out.println("FUERTE");
		} else if (longpass >= 8) {
			System.out.println("MODERADA");
		} else {
			System.out.println("DEBIL");
		}

	}

}
