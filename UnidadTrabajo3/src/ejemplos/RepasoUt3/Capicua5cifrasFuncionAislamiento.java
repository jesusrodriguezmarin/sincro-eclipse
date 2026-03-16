package ejemplos.RepasoUt3;

import java.util.Scanner;

public class Capicua5cifrasFuncionAislamiento {

	/**
	 * Función que indica si un nº de 5 cifras es o no capicua
	 * @param N - nº entero para analizar
	 * @return true si es booleano o false si no lo es
	 */
	public static boolean capicua(int N) {
		// declaramos variable num para tratar N
		int num = N;
		
		// declaramos variables para descomponer N
		int dm, um, c, d, u;
		
		// aislamos y eliminamos partes de num 
		
		// aislamos unidades
		u = num % 10;
		
		// eliminamos unidades
		num /= 10;
		
		// aislamos decenas
		d = num % 10;
		
		// eliminamos decenas
		num /= 10;
		
		// aislamos centenas 
		c = num % 10;
		
		// eliminamos centenas
		num /= 10;
		
		// aislamos umillar
		um = num % 10;
		
		// eliminamos umillar
		num /= 10;
		
		// aislamos dmillar
		dm = num % 10;
		
		// eliminamos dmillar
		num /= 10;
		
		// importante controlar los ceros
		
		// si N es de 5 cifras comparamos dm == u, um == d, c queda igual
		if (dm == u && um == d)
			return true;
		
		// si N es de 4 cifras comparamos um == u, c == d
		if (dm == 0 && um == u && c == d)
			return true;	
		
		// si N es de 3 cifras comparamos c == u
		if (dm == 0 && um == 0 && c == u)
		return true;	
		
		// si N es de 3 cifras comparamos d == u
		if (dm == 0 && um == 0 && c == 0 && d == u)
		return true;
	
		return false;
	}
	
	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		// control de excepcion
		try {
			// declaración de variable para el nº que vamos a pedir
			int num;
			
			// pedimos el nº acotado hasta que esté dentro del rango
			do {
				System.out.print("Introduce un nº entre 1 y 99999: ");
				num = sc.nextInt();
				// si num no está en el rango informamos
				if (num < 1 || num > 99999)
					System.out.println("El nº introducido no está en el rango.");
			} while (num < 1 || num > 99999);
			
			// llamamos a la función capicua
			if (capicua(num)) {
				System.out.println(num+" es capicua.");
			} else {
				System.out.println(num+" no es capicua.");
			}
			
		} catch (Exception e) {
			System.err.println("ERROR. Dato introducido no válido.");
		} finally {
			// cierre lector
			sc.close();

		}
			
	}

}
