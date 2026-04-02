package recuperaciones.arrays;

import java.util.Scanner;

public class LeerMostrarOrdenInverso {

	// Constante para el tamaño del array
	final static int TAM = 10;

	public static void main(String[] args) {

		// lector
		Scanner sc = new Scanner(System.in);

		// Control de errores
		try {
			// Creamos array de números enteros
			int lista[] = new int[TAM];

			System.out.println("Introduce " + TAM + " valores enteros...");
			// Bucle para pedir números para el array
			for (int i = 0; i < lista.length; i++) {
				// Pedimos números enteros por consola
				System.out.print("Valor[" + (i + 1) + "]: ");
				lista[i] = sc.nextInt();
			}

			// Mostramos los números en orden introducido
			System.out.print("Orden introducido: ");
			for (int i = 0; i < lista.length; i++) {
				System.out.print(lista[i] + " ");
			}

			// Mostramos los números en ordn inverso
			System.out.print("\nOrden inverso: ");
			for (int i = lista.length - 1; i >= 0; i--) {
				System.out.print(lista[i] + " ");
			}

		} catch (Exception e) {
			System.err.println("Error tipo de dato no válido");
		} finally {
			sc.close();
		}

	}

}
