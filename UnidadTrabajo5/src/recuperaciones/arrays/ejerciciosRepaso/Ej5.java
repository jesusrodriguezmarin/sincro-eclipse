package recuperaciones.arrays.ejerciciosRepaso;

import java.util.Scanner;

public class Ej5 {

	// Cosntante para el tamaño
	final static int TAM = 5;

	/**
	 * Función que comprueba si un elemento ya se encuentra en el array
	 * 
	 * @param a - array a comprobar
	 * @return true si se encuentra, false si no se encuentra
	 */
	public static boolean encontrado(int[] a, int n, int l) {
		for (int i = 0; i < l; i++) {
			if (a[i] == n) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Muestra todos los elementos contenidos en un array
	 * 
	 * @param a - array
	 */
	public static void mostrar(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	// Programa principal
	public static void main(String[] args) {

		// Creamos el array
		int[] a = new int[TAM];

		// Pedimos los números al usuario
		Scanner sc = new Scanner(System.in);

		try {
			for (int i = 0; i < a.length; i++) {
				System.out.print("Inroduce un número entre 1 y 10 para almacenar: ");
				int n = sc.nextInt();

				// Comprobamos que este dentro del rango 1 - 10
				while ((n < 1 || n > 10) || (encontrado(a, n, i))) {
					if (n < 1 || n > 10) {
						System.out.println("El número debe estar entre 1 y 10!");
					} else if (encontrado(a, n, i)) {
						System.out.println("El número ya se encuentra en el array!");		
					}
					System.out.print("Introducelo de nuevo: ");
					n = sc.nextInt();
				}

				// Asignamos el núnero a la posición del array actual
				a[i] = n;
			}
			System.out.println("\nArray a:");
			mostrar(a);

		} catch (Exception e) {
			System.err.println("Error. Tipo de dato no válido");
		} finally {
			sc.close();
		}

	}

}
