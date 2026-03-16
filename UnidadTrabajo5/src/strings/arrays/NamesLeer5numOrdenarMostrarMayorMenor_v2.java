package strings.arrays;

import java.util.Scanner;

public class NamesLeer5numOrdenarMostrarMayorMenor_v2 {

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

	/**
	 * Función que devuelve el índice del String mas largo almacenado en el array de Strings
	 * @param array de Strings
	 * @return índice (int) del String más largo almacenado en el array de Strings
	 */
	private static int mayorString(String[] array) {
		int res=0;
		for (int i=0; i<array.length; i++) {
			if (array[i].length()>array[res].length()) {
				res=i;
			}
		}
		return res;
	}
	
	/**
	 * Función que devuelve el índice del String mas largo almacenado en el array de Strings
	 * @param array de Strings
	 * @return índice (int) del String más largo almacenado en el array de Strings
	 */
	private static int menorString(String[] array) {
		int res=0;
		for (int i=0; i<array.length; i++) {
			if (array[i].length()<array[res].length()) {
				res=i;
			}
		}
		return res;
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
		System.out.println("\nEl nombre mas largo es: " + vector[mayorString(vector)]);
		System.out.println("El nombre mas corto es: " + vector[menorString(vector)]);
		System.out.println("Nombre elegido al azar: "+ vector[(int)Math.random()*vector.length]);
	}

}
