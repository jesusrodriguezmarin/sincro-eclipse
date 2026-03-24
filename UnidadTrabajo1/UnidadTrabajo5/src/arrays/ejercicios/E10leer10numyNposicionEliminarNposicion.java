package arrays.ejercicios;

import java.util.Scanner;

public class E10leer10numyNposicionEliminarNposicion {

	final static int TAM=10;
	
	/**
	 * Procedimiento que muestra los valores del array
	 * @param A - array de números enteros
	 * @param tam - tamaño o numero de posiciones que queremos mostrar
	 */
	public static void mostrar(int A[], int tam) {
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
	}
	
	// Programa principal main
	public static void main(String[] args) {
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Creamos array que almacenará los números pedidos por teclado
		int A[]= new int[TAM];
		
		// Variable números a desplazar
		int n = TAM;
		
		// Control
		try {
			// Pedimos números
			System.out.println("Introduce los valores que almacenaremos en el vector...");
			for (int i=0; i<A.length; i++) {
				System.out.print("valor ["+i+"]: ");
				A[i]=sc.nextInt();
			}
			
			// Preguntamos las posiciones a eliminar
			do {
				System.out.print("\nPosiciones a eliminar (entre 0 y "+(TAM-1)+"): ");
				n = sc.nextInt();				
			} while (n<0 || n>=TAM);
			
		} catch (Exception e) {
			System.err.println("ERROR");
		} finally {
			sc.close();
		}
		// Mostramos
		System.out.print("Vector original: ");
		mostrar(A, TAM);
		
		// Desplazamos desde la posicion elegida al final
		for (int i=n; i<TAM-1; i++) {
			A[i]=A[i+1];
		}
		
		// Mostramos vector con un elemento eliminado
		System.out.print("\nVector con un elemento eliminado: ");
		mostrar(A, TAM-1);
	}

}
