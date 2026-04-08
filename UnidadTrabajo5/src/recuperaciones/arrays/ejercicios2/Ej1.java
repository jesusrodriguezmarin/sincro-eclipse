package recuperaciones.arrays.ejercicios2;

import java.util.Scanner;

public class Ej1 {

	// Constante para el tamaño del array
	final static int TAM = 10;
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos un array de números enteros
		int[] a = new int[TAM];

		// Pedimos TAM números al usuario para almacenar en el array
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce "+TAM+" números para almacenar en el array.");
		
		// Variables contador
		int pos = 0;
		int neg = 0;
		int cero = 0;
		
		for (int i = 0; i < a.length; i++) {
			System.out.print("Introduce un número entero: ");
			int n = sc.nextInt();
			a[i] = n;
			
			if (n < 0) {
				neg++;
			} else if (n == 0) {
				cero++;
			} else {
				pos++;
			}
		}
		System.out.println("\nEl array es: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		
		System.out.println("\nEn el array hay "+neg+" números negativos.");
		System.out.println("En el array hay "+pos+" números positivos.");
		System.out.println("En el array hay "+cero+" ceros.");

		sc.close();
	}

}
