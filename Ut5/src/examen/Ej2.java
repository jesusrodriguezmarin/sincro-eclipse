package examen;

import java.util.Scanner;

public class Ej2 {

	// Constante para el tamaño
	final static int TAM = 8;

	// Constante para el límite superior de los aleatorios
	final static int LIM = 10;

	/**
	 * Función genera un número aleatorio
	 * 
	 * @param N - límite superior
	 * @return {int} el número aleatorio generado
	 */
	public static int aleatorio(int N) {
		return (int) (Math.random() * N + 1);
	}

	/**
	 * Procedimiento que muestra todos los elementos de un array
	 * 
	 * @param a - array a mostrar
	 */
	public static void mostrar(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	// Programa principal
	public static void main(String[] args) {

		// Cramos un array de enteros
		int[] a = new int[TAM];

		for (int i = 0; i < a.length; i++) {
			a[i] = aleatorio(LIM);
		}

		// Mostramos el array
		System.out.print("> Valores: ");
		mostrar(a);

		// Pedimos un valor para reemplazar
		Scanner sc = new Scanner(System.in);
		
		// Variable contadora
		int conta = 0;
		
		// Variable comporbar
		boolean ok = false;
		
		try {
			System.out.print("\n\nValor a reemplzar: ");
			int viejo = sc.nextInt();
			System.out.print("Nuevo valor: ");
			int nuevo = sc.nextInt();
			
			for (int i = 0; i < a.length; i++) {
				if (a[i] == viejo) {
					a[i] = nuevo;
					conta++;
					ok = true;
				}
			}
			
			if (ok) {
				System.out.println("\n> Se han realizado "+conta+" reemplazos");
				// Mostramos el array
				System.out.print("> Valores: ");
				mostrar(a);	
			} else {
				System.out.println("\n> No se ha encontrado el valor: "+viejo);
			}

		} catch (Exception e) {
			System.err.println("ERROR: Tipo de dato no válido.");
		} finally {
			sc.close();
		}
	}

}
