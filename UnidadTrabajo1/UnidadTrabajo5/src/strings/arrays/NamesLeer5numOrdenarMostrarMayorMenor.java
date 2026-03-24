package strings.arrays;

import java.util.Scanner;

public class NamesLeer5numOrdenarMostrarMayorMenor {

	// Número de elementos del vector
	final static int TOTAL = 5;

	/**
	 * Procedimiento que muestra todos los elementos de un array
	 * 
	 * @param array
	 */
	private static void mostrar(String array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	/**
	 * Procedimiento que ordena un array de menor a mayor
	 * 
	 * @param array de números enteros
	 */
	private static void ordenar(String array[]) {
		String aux;
		for (int i = array.length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (array[j].compareTo(array[j + 1]) > 0) {
					aux = array[j];
					array[j] = array[j + 1];
					array[j + 1] = aux;
				}
			}
		}
	}
	
	

	// Programa principal
	public static void main(String[] args) {

		// Creamos lector
		Scanner sc = new Scanner(System.in);

		// Creamos array
		String[] vector = new String[TOTAL];

		// Pedimos nombre al usuario 5 nombres
		for (int i = 0; i < TOTAL; i++) {
			System.out.print("[" + (i + 1) + "] Introduce un nombre: ");
			vector[i] = sc.nextLine();
		}
		sc.close();

		// Mostramos los valores
		System.out.println("\nArray: ");
		mostrar(vector);
		System.out.println("\nArray ordenado: ");
		ordenar(vector);
		mostrar(vector);
	}

}
