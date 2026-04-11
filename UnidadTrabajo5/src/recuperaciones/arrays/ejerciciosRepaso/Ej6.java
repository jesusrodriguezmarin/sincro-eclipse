package recuperaciones.arrays.ejerciciosRepaso;

import java.util.Scanner;

public class Ej6 {

	// Constantes
	final static int TAM = 6; // Tamañao de los arrays
	final static int LIM = 49; // Límite superior para generar números

	/**
	 * Función que genera un número aleatorio entre 1 y N
	 * 
	 * @param N {int} Límite
	 * @return {int} un número aleatorio entre 1 y N
	 */
	public static int aleatorio(int N) {
		return (int) (Math.random() * N + 1);
	}

	/**
	 * Procedimiento que muestra todos los elementos contenidos en un array de
	 * enteros
	 * 
	 * @param a - array de números enteros
	 */
	public static void mostrar(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	/**
	 * Función que comprueba si un número pasado por parámetro se encuentra entre
	 * los elemntos de un array
	 * 
	 * @param a - array de números enteros
	 * @param n - número a comprobar
	 * @return true si se encuantra en el array, false si no se encuentra
	 */
	public static boolean encontrado(int[] a, int n, int pos) {
		for (int i = 0; i < pos; i++) {
			if (a[i] == n) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Función que compara dos arrays y devuelve cuantos elementos tienen en común
	 * 
	 * @param a - array a comparar
	 * @param b - array a comparar
	 * @return {int} el número de coincidencias
	 */
	public static int aciertos(int[] a, int[] b) {
		int total = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					total++;
				}
			}
		}
		return total;
	}
	
	/**
	 * Procedimiento que ordena todos los elementos contenidos en un array de menor a mayor
	 * @param a - array a ordenar
	 */
	public static void bubblesort (int[] a) {
		int aux;
		for (int i = a.length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (a[j] > a[j+1]) {
					aux = a[j];
					a[j] = a[j+1];
					a[j+1] = aux;
				}
			}
		}
	}

	// Programa principal
	public static void main(String[] args) {

		// Creamos el array para generar el número ganador
		int[] ganadores = new int[TAM];

		// Creamos el array para almacenar los números que pedimos al usuario
		int[] apuesta = new int[TAM];

		// Generamos los números para ganadores
		for (int i = 0; i < ganadores.length; i++) {
			int n = aleatorio(LIM);
			while (encontrado(ganadores, n, i)) {
				n = aleatorio(LIM);
			}
			ganadores[i] = n;
		}

		// Pedimos los números al usuario
		Scanner sc = new Scanner(System.in);

		try {
			for (int i = 0; i < apuesta.length; i++) {
				// Pedimos el número
				System.out.print("Introduce un número " + (i + 1) + " : ");
				int num = sc.nextInt();

				// Controlamos los errores de introducción
				while ((num < 1 || num > LIM) || (encontrado(apuesta, num, i))) {

					// Informamos del error
					if (num < 1 || num > LIM) {
						System.out.println("El número está fuera del rango 1 - 49.");
					} else if (encontrado(apuesta, num, i)) {
						System.out.println("El número ya se encuentra en la apuesta.");
					}
					// Pedimos el número de nuevo
					System.out.print("Introduce un número " + (i + 1) + " : ");
					num = sc.nextInt();
				}
				apuesta[i] = num;
			}
			// Mostramos la apuesta del usuario
			System.out.print("\nTu apuesta es: ");
			bubblesort(apuesta);
			mostrar(apuesta);

			// Mostramos la apuesta ganadora
			System.out.print("\nLos números ganadores son:  ");
			bubblesort(ganadores);
			mostrar(ganadores);

			// Mostramos los aciertos
			System.out.println("\nEl número de aciertos es: " + aciertos(ganadores, apuesta));

		} catch (Exception e) {
			System.err.println("Error. Tipo de dato no válido.");
		} finally {
			sc.close();
		}

	}

}
