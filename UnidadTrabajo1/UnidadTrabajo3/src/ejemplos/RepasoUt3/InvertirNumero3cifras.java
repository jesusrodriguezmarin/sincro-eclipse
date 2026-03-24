package ejemplos.RepasoUt3;

import java.util.Scanner;

public class InvertirNumero3cifras {

	public static void main(String[] args) {
		// abrimos escaner
		Scanner sc = new Scanner(System.in);
		// control de excepciones
		try {
			// declaración de variable para el nº solicitado
			int num;
			
			// pedimos el nº en el rango acotado 1..999
			do {
				System.out.print("Introduce un número entre 1 y 999: ");
				num = sc.nextInt();
			} while (num < 1 || num > 999);
			
			// declaramos variables para aislar las partes del nº
			int c, d, u;
			
			// logaritmo para tratar el nº introducido
			
			// módulo de 10 para aislar las unidades
			u = num % 10;
			
			// dividimos num entre 10 para quitar unidades
			num /= 10;
			
			// módulo de 10 para aislar decenas
			d = num % 10;
			
			// dividimos num entre 10 de nuevo para quitar decenas
			num /= 10;
			
			// módulo entre 10 de num para sacar las centenas
			c = num % 10;
			
			// dividimos num entre 10 para dejar a 0 "como buena práctica"
			num /= 10;
			
			// mostramos condicionando para controlar el 0
			
			// condición pare nº de una unidad
			if (c == 0 && d == 0) {
				System.out.println("Tu número es: "+u);
				System.out.println("La cifra al revés es la misma: "+u);
			} else if (c == 0) {
				System.out.println("Tu número es: "+d+""+u);
				System.out.println("Tu número al revés es: "+u+""+d);
			} else {
				System.out.println("Tu número es: "+c+""+d+""+u);
				System.out.println("Tu número al revés es: "+u+""+d+""+c);
			}
			
			
			
			
		} catch (Exception e) {
			System.err.println("ERROR. Tipo de datos no válido.");
		}
		
		// cerramos lector
		sc.close();

	}

}
