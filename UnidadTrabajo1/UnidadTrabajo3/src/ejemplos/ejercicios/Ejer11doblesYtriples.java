package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer11doblesYtriples {

	public static void main(String[] args) {
		try {
		// Abrimos lector
		Scanner sc = new Scanner(System.in);
		// Pedimos nº
		System.out.print("Introduce un nº entero: ");
		int N = sc.nextInt();
		// Cerramos lector
		sc.close();
		
		if (N > 0) {
			System.out.println("Num\tDoble\tTriple");
			for (int conta = 1; N >= conta; conta++)
				System.out.println(conta+"\t"+conta*2+"\t"+conta*3);
		} else {
			System.err.println(">> ERROR. Introduce un nº positivo mayor que 0");
		
		}
		} catch (Exception e) {
			System.err.println("ERROR. No has introducido un nº entero positivo.");
		}
		
	}
		
}

