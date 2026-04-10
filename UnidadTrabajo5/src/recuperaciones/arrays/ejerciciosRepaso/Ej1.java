package recuperaciones.arrays.ejerciciosRepaso;

import java.util.Scanner;

public class Ej1 {

	// Constante para el tamaño
	final static int TAM = 5;

	/**
	 * Procedimiento que ordena de menor a mayor los elementos de un array
	 * 
	 * @param a - array a ordenar
	 */
	public static void ordenar(int[] a) {
		int aux = 0;
		for (int i = a.length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (a[j] > a[j + 1]) {
					aux = a[j];
					a[j] = a[j + 1];
					a[j + 1] = aux;
				}
			}
		}
	}
	
	/**
	 * Compara los elementos de dos arrays de números enteros pasados por parámetro
	 * @param a - array
	 * @param b - array
	 * @return true si los arrays son iguales, false si no lo son
	 */
	public static boolean compara (int[] a, int[] b) {
		for (int i = 0; i < TAM; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	// Programa princial
	public static void main(String[] args) {

		// Creamos el primer array
		int[] a = new int[TAM];

		// Creamos el segundo array
		int[] b = new int[TAM];

		// Pedimos los valores para los arrays por teclado
		Scanner sc = new Scanner(System.in);

		try {
			
			for (int i = 0; i < TAM; i++) {
				System.out.print("Introduce un valor para el array a: ");
				int aa = sc.nextInt();
				System.out.print("Introduce un valor para el array b: ");
				int bb = sc.nextInt();
				
				a[i] = aa;
				b[i] = bb;
			}
			System.out.println("a: ");
			for (int i = 0; i < TAM; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println("\nb: ");
			for (int i = 0; i < TAM; i++) {
				System.out.print(b[i] + " ");
			}
			// Variable para igualdad
			boolean iguales = true;
			
			for (int i = 0; i < TAM; i++) {
				if (a[i] != b[i]) {
					iguales = false;
					break;
				}
			}
			// Comprobamos si contienen los mismos elementos en el mismo orden
			if (iguales) {
				System.out.println("\nLos arrays son iguales");
			} else {
				System.out.println("\nLos arrays no son iguales");
				
				// Ordenamos y comprobamos si contienen los mismos elementos
				ordenar(a);
				ordenar(b);
				
				System.out.println("\na ordenado: ");
				for (int i = 0; i < TAM; i++) {
					System.out.print(a[i] + " ");
				}
				System.out.println("\nb ordenado: ");
				for (int i = 0; i < TAM; i++) {
					System.out.print(b[i] + " ");
				}
				
				if (compara(a,b)) {
					System.out.println("\nLos arrays contienen los mismos elementos");
				} else {
					System.out.println("\nLos arrays no contienen los mismos elementos");
				}
			}
			
		} catch (Exception e) {
			System.err.println("ERROR: Tipo de dato no válido.");		
		} finally {
			sc.close();
		}

	}

}
