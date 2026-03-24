package ejemplos.condicionales;

import java.util.Scanner;

public class SwitchMedallas {
	public static void main(String[] args) {
		try {
		// Introducimos taclado
		Scanner sc = new Scanner(System.in);
		// Pedimos dato
		System.out.print("Introduce tu puesto: ");
		// Grabamos el dato
		int puesto = sc.nextInt();
		// Cerramos teclado
		sc.close();
		
		// Establecemos la condicion
		if (puesto > 0) {
			switch (puesto) {
			case 1: System.out.println("Oro"); break;
			case 2: System.out.println("Plata"); break;
			case 3: System.out.println("Bronce"); break;
			case 4: System.out.println("Diploma"); break;
			case 5: System.out.println("Diploma"); break;
			default: System.out.println("No tienes premio");
			}
		} else {
			System.out.println("El tipo de dato es igual o menor que 0");
		}
		} catch (Exception e) {
			System.err.println(">> ERROR. El tipo de dato no es correcto");
		}

	}

}

