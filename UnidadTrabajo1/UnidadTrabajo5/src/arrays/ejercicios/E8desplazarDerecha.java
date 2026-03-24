package arrays.ejercicios;

import java.util.Scanner;

public class E8desplazarDerecha {

	// Constante para el tamaño del array
	final static int TAM=5;
	
	/**
	 * Procedimiento que muestra todos los valores de un array
	 * @param A - array de números enteros
	 */
	public static void mostrar(int A[]) {
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		// Declaramos un array de tamaño TAM=5
		int A[]=new int[TAM];
		
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Control de excepciones
		try {
			// Pedimos valores al usuario
			System.out.println("Introduce los elementos de la tabal: ");
			for (int i=0; i<TAM; i++) {
				System.out.print("Introduce un número: ");
				A[i]=sc.nextInt();
			}
			
		} catch (Exception e) {
			System.err.println(">> ERROR: Tipo de dato no válido");
		} finally {
			sc.close();
		}
		// Mostramos el array inicial 
		mostrar(A);
		
		// 1. Guardamos el último valor antes de ser chafado
		int aux=A[TAM-1];
		
		// 2. Desplazamos los valores hacia la derecha
		for (int i=TAM-2; i>=0; i--) {
			A[i+1]=A[i];
		}
		// 3. Asignamos el último valor a la primera posición
		A[0]=aux;
		
		// Mostramos el array desplazado
		mostrar(A);
	}

}
