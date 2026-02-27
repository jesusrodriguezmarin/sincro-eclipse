package ejemplos.ejercicios2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejer1 {

	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		
		// control de excepciones
		try {
		// declaración de variable
		int num;
		
		// pedimos un nº hasta que este entre 1..999
		do {
			System.out.print("Introduce un nº entre 1 y 999: ");
			num = sc.nextInt();
		} while (num < 1 || num > 999);
		
		// descomponemos el nº en unidades, decemas y centenas
		int c, d, u;
		
		// sacamos la primera capa unidades
		u = num % 10;
		
		// sacamos la segunda capa decenas
		num = num /10;
		d = num % 10;
		
		// sacamos la tercera capa centenas
		num = num / 10;
		c = num % 10;
		
		// control para controlar el cero
		if (c == 0 && d == 0) {
			System.out.println(u);
		} else if (c == 0) {
			System.out.println(u+" "+d);
		} else {
			System.out.println(c+" "+d+" "+u);
		}
		
		
		// control de excepcion escpecífica
		} catch (InputMismatchException ime) {
			System.err.println(">> ERROR: Tipo de dato no válido.");
			
		// control de excepcion general
		} catch (Exception e) {
			System.err.println(">> Se ha producido una excepcion distinta.");
		} finally {
			// cierre
			sc.close();
		}
	}

}
