package ejemplos.ejercicios2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejer1_clase {

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
		
		// descomponemos el nº en unidades, decenas y centenas
		int c, d, u;
		c = num / 100;
		num %= 100;
		d = num / 10;
		num %= 10;
		u = num;
		
		// salto de linea
		System.out.println();
		
		// valor de cada parte
		System.out.println("C: "+c);
		System.out.println("D: "+d);
		System.out.println("U: "+u);
		
		// salto de linea
		System.out.println();
		
		// nº odenado
		System.out.println(c+" "+d+" "+u);
		// nº invertido
		System.out.println(u+" "+d+" "+c);
		
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
