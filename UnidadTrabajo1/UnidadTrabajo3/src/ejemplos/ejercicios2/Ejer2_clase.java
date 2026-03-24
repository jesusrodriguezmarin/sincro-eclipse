package ejemplos.ejercicios2;

import java.util.Scanner;

public class Ejer2_clase {

	/**
	 * Funcion que indica si un nº de 5 cifras es capicúa
	 * Requisito: el nº debe ser de 5 cifras
	 * @param N - nº entero de 5 cifras
	 * @return True si es capicua o False si no lo es
	 */
	public static boolean esCapicua (int N) {
		
		// creamos variable num para dejar N sin modificar
		int num;
		
		// descomponemos en 
		int dm, um, c, d, u;
		
		// calculamos las unidades
		u = N % 10;
		
		// inicialzación de num como N menos las unidades
		num = N / 10;
		
		// calculamos las decenas
		d = num % 10;
		
		// actualuzacion de num quitandole las decenas
		num = num / 10;
		
		// calculamos las centenas
		c = num % 10;
		
		// actualización de num quitandole las centenas
		num /= 10;
		
		// calculamos um
		um = num % 10;
		
		// actualizacion de num quitandole las u de millar
		num /= 10;
		
		// calculamos dm
		dm = num % 10;
		
		// siendo el nº de 5 cifras (dm, um, c, d, u)
		if (dm == u && um == d) {
			return true;
		}	
			
		// si el nº es de 4 cifras (um, c, d, u)
		if (dm == 0 && um == u && c == d) {
			return true;
		}
		
		// si el nº es de 3 cifras (c, d, u)
		if (dm == 0 && um == 0 && c == u) {
			return true;
		}
		// si el nº es de 2 cifras (d, u)
		if (dm == 0 && um == 0 && c == 0 && d == u) {
			return true;
		}
		// si el nº es de 1 cifra (u)
		if (dm == 0 && um == 0 && c == 0 && d == 0) {
			return true;
		}
		// también nos vale esto para una cifra
		if (num < 10) {
			return true;
		}
		return false;
	}
	
	// programa principal
	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		
		// control de excepcion
		try {
			// declaración de variable
			int num;
			
			do {
			// pedimos nº entre 1 y 99999
			System.out.print("Introduce un nº entre 1 y 99999: ");
			num = sc.nextInt();
			} while (num < 1 || num > 99999);
			
			// llamamos funcion
			if (esCapicua(num) == true) {
				System.out.println("Si, el número es capicúa.");
			} else {
				System.out.println("No, el número no es capicúa.");
			}
			
		} catch (Exception e) {
			System.out.println(">> ERROR. Tipo de dato no válido");
		} finally {
			// cerramos lector
			sc.close();
		}
		

	}

}
