package examenRecuperacionUt3;

import java.util.Scanner;

public class Ejer3 {

	/**
	 * Procedimiento que muestra los números impares
	 * @param n
	 */
	public static void impares(int n) {
		for (int i = 1; i <= n; i += 2)
			System.out.print(i+" ");
				
	}
	/**
	 * Función para comprobar si un nº es o no primo
	 * @param n
	 * @return
	 */
	public static boolean primo(int n) {
		for (int i = 2; i <= n - 1; i++)
			if (n % i == 0)
				return false;
		return true;
	}
	public static void main(String[] args) {
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		try {
			
			int num = 0;
			while (num < 1 || num > 10) {
				System.out.print("Dime un número: ");
				num = sc.nextInt();
				if (num < 1 || num > 10)
					System.out.println(">> El número introducido no se encuentra entre 1 y 10");
				System.out.println();
			}
			
			switch (num) {
			case 1:
				System.out.println("> UNO");
				break;
			case 2:
				System.out.println("> DOS");
				break;
			case 3:
				System.out.println("> TRES");
				break;
			case 4:
				System.out.println("> CUATRO");
				break;
			case 5:
				System.out.println("> CINCO");
				break;
			case 6:
				System.out.println("> SEIS");
				break;
			case 7:
				System.out.println("> SIETE");
				break;
			case 8:
				System.out.println("> OCHO");
				break;
			case 9:
				System.out.println("> NUEVE");
				break;
			case 10:
				System.out.println("> DIEZ");
				break;

			default:
				break;
			}
			
			if (primo(num))
				System.out.println("> Es un número primo");
			else
				System.out.println("> No es un número primo");
			
			System.out.print("> Lista de números impares: ");
			impares(num);
			
		} catch (Exception e) {
			System.err.println(">> ERROR. Tipo de dato no valido");
		} finally {
			sc.close();
		}

	}

}
