package recuperaciones.arrays.ejercicios2;

import java.util.Scanner;

public class Ej5 {

	// Constante
	final static int TAM = 10;
	
	// Programa principal
	public static void main(String[] args) {

		// Cramos array 
		int[] a = new int[TAM];
		
		// Pedimos los números por teclado
		Scanner sc = new Scanner(System.in);
		
		// Variables para la media
		double suma = 0;
		int conta = 0;
		
		for (int i = 0; i < a.length; i++) {
			System.out.print("Introduce un número: ");
			int n = sc.nextInt();
			a[i] = n;
			
			// Si la iteración es par sumamos el número introducido para la media
			if (i % 2 == 0) {
				suma += n;
				conta++;

			}
		}
		System.out.println("La media de los números pares del array es: "+suma/conta);
		sc.close();
	}

}
