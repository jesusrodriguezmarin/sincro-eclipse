// Programa que pida 6 números entre 1 y 49 y los almacene en un array
// En otro array almacenará los 6 números ganadores generados aleatoriamente
// No puede haber duplicados ni en los introducidos ni en los generados
// Mostrar por pantalla los números introducidos y los ganadores ordenados
// Mostrar el número de aciertos

package estudioCasa;

import java.util.Scanner;

public class Primitiva {

	// Constante para el tamaño de los arrays
	public static final int TAM = 6;

	/**
	 * Procedimiento que muestra todos los elementos de un array
	 * 
	 * @param a - array pasado por parámetro
	 */
	public static void mostrar(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Función que determina si el número n se encuentra entre los elementos de un
	 * array
	 * 
	 * @param a - array de números enteros
	 * @param n - número a comprobar
	 * @return TRUE si el número se encuentra en el array, FALSE si no se encuentra
	 */
	public static boolean encontrado(int[] a, int n) {
		for (int i = 0; i < a.length; i++) {
			if (n == a[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Devuelve un número aleatorio para cada posición de un array pasado por
	 * parámetro
	 * 
	 * @param a - array para rellenar
	 * @return Array de números generados aleatoriamente
	 */
	public static int[] aleatorio(int[] a) {
		// Recorremos el array
		for (int i = 0; i < a.length; i++) {

			// Declaramos variable temporal
			int aux;

			// Generamos aleatorio para esta iteración
			do {
				aux = (int) (Math.random() * 49 + 1);

				// Si ya se encuentra en el array se genera de nuevo para la misma posición
			} while (encontrado(a, aux));

			// Cuando llega aquí es correcto y se almacena en la posición del vector
			a[i] = aux;
		}
		return a;
	}

	/**
	 * Procedimiento que ordena los elementos contenidos en un array Orden de menor
	 * a mayor
	 * 
	 * @param a - array de números enteros
	 */
	public static void bubblesort(int[] a) {
		// Recorremos el array descendentemente
		for (int i = a.length - 1; i >= 0; i--) {
			// Recorremos el array ascendentemente
			for (int j = 0; j < i; j++) {
				// Si nos encontramos que el anterior elemento es mayor que el siguinte
				if (a[j] > a[j + 1]) {
					// Intercambiamos los elementos
					int aux = a[j];
					a[j] = a[j + 1];
					a[j + 1] = aux;
				}
			}
		}
	}
	
	/**
	 * Función que devuelve el número de elementos comunes entre dos arrays
	 * @param a - array de números enteros pasado por parámetro
	 * @param b - array de números enteros pasado por parámetro
	 * @return int cantidad de elementos repetidos
	 */
	public static int aciertos(int[] a, int[] b) {
		int conta=0;
			for (int i=0; i<TAM; i++) {
				for (int j=0; j<TAM; j++) {
					if (a[i]==b[j]) {
						conta++;
					}
				}
			}
		return conta;
	}

	// Programa principal
	public static void main(String[] args) {

		// Array para los números ganadores generados aleatoriamente
		int[] ganadores = new int[TAM];

		// Array para almacenar los números introducidos por teclado
		int[] introducidos = new int[TAM];

		// Creamos lector para pedir 6 números al usuario
		Scanner sc = new Scanner(System.in);

		// Control de excepciones
		try {
			// Recorremos el array para pedir tantos números com length
			for (int i = 0; i < introducidos.length; i++) {

				// Pedimos el número
				System.out.print("[" + (i + 1) + "] Introduce un número: ");

				// Guardaos en una variable auxiliar
				int aux = sc.nextInt();

				// Si no es correcto entra aquí
				if (aux < 1 || aux > 49 || encontrado(introducidos, aux)) {

					// Informamamos
					System.out.println("\nEl número introducido no es válido");
					System.out.println("Introduce un número entre 1 y 49 que no esté en la lista ya.");

					// Volvemos a pedir
					do {
						System.out.print("\n[" + (i + 1) + "] Introduce un número: ");

						// Volvemos a almacenar temporalmente y condicionamos la repetición
						aux = sc.nextInt();
					} while (aux < 1 || aux > 49 || encontrado(introducidos, aux));
				}
				// Si no ha pasado por el if o ha pasado y salido del bucle es correcto
				// Almacenamos el elemento en esa posición del vector
				introducidos[i] = aux;

				// Seguimos en el for hasta terminar las iteraciones correspondientes
			}
			// Mostramos los números ganadores
			ganadores = aleatorio(ganadores);

			System.out.print("\nLos números ganadores sin ordenar son: ");
			mostrar(ganadores);

			// Mostramos los números introducidos
			System.out.print("Los números introducidos sin ordear son: ");
			mostrar(introducidos);

			// Los ordenamos
			bubblesort(ganadores);
			bubblesort(introducidos);

			// Mostramos ordenados
			System.out.print("Los números ganadores ordenados son: ");
			mostrar(ganadores);
			
			System.out.print("Los números introducidos ordenados son: ");
			mostrar(introducidos);

			// Mostramos los aciertos
			System.out.print("Has acertado "+aciertos(ganadores, introducidos)+" números");

		} catch (Exception e) {
			System.err.println(">> ERROR. Tipo de dato no válido.");
		} finally {
			sc.close();
		}

	}

}
