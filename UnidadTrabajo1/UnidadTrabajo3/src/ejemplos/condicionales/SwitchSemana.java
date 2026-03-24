package ejemplos.condicionales;

import java.util.Scanner;

public class SwitchSemana {

	public static void main(String[] args) {
		try {
		// Introducimos lector
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime un dia de la semana: ");
		int dia = sc.nextInt();
		sc.close();
		// Introducimos el Switch
		switch (dia) {
			case 1: System.out.print("LUNES"); break;
			case 2: System.out.print("MARTES"); break;
			case 3: System.out.print("MIERCOLES"); break;
			case 4: System.out.print("JUEVES"); break;
			case 5: System.out.print("VIERNES"); break;
			case 6: System.out.print("SABADO"); break;
			case 7: System.out.print("DOMINGO"); break;
			default: System.out.print("No es un día de la semana");
			}
			} catch (Exception e) {
			System.err.println("ERROR!!! tipo de dato no válido");
		}

	}

}