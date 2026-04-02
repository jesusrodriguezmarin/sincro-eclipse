package recuperaciones.examenUt5;

import java.util.Scanner;

public class Ejercicio02 {
	final static int LIM = 10;
	final static int TAM = 8;

	/**
	 * Funcion que genera un número aleatorio
	 * 
	 * @param a
	 * @return
	 */
	public static int generar(int a) {
		return (int) (Math.random() * LIM + 1);
	}

	public static void main(String[] args) {
		// Creamos un array
		int[] array = new int[TAM];
		// Almacenamos 8 números enteros en el array
		for (int i = 0; i < array.length; i++) {
			array[i] = generar(LIM);
		}

		// Mostramos el array
		System.out.print("Valores: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		// pedimos al usuario que introduzca un valor para ver si se encuentra en el
		// array
		int n;
		boolean verificacion = false;
		Scanner tcl = new Scanner(System.in);
		try {
			System.out.print("\n\nValor a reemplazar: ");
			n = tcl.nextInt();
			for (int i = 0; i < array.length; i++) {
				if (array[i] == n) {
					verificacion = true;
				}

			}

			if (!verificacion) {
				System.out.print("\n> No se ha encontrado el valor " + n);
			} else {
				System.out.print("Nuevo valor: ");
				int num = tcl.nextInt();
				int conta = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i] == num) {
						array[i] = num ;
						conta++;
					}

				}
				System.out.print("> Se han realizado " + conta + " reemplazos");
				// Mostramos el array
				System.out.print("\nValores: ");
				for (int i = 0; i < array.length; i++) {
					System.out.print(array[i] + " ");
				}

			}

		} catch (Exception e) {
			System.out.println("ERRO: Tipo de dato incorrecto");
		} finally {
			tcl.close();

		}
	}

}
