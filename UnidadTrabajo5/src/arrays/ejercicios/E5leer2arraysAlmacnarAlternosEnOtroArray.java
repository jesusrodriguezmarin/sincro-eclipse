package arrays.ejercicios;

import java.util.Scanner;

public class E5leer2arraysAlmacnarAlternosEnOtroArray {

	// Constante global para el tamaño de los arrays A y B
	final static int TAM=5;

	/**
	 * Procedimiento que muestra todos los elementos almacenado en un array
	 * @param A - array de números enteros
	 */
	public static void mostrar(int A[]) {
		for (int i=0; i<A.length; i++)
			System.out.print(A[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		// Creamos el primer array A
		int A[]= new int[TAM];
		
		// Creamos el segundo array B
		int B[]= new int[TAM];
		
		// Creamos el tercer array C
		int C[]= new int[A.length+B.length];
		
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Control de excepciones
		try {
			// Pedimos los valores al usuario
			System.out.println("Vector A: ");
			for (int i=0; i<A.length; i++) {
				System.out.print("Introduce un valor: ");
				A[i]=sc.nextInt();
			}
			// Pedimos los valores al usuario
			System.out.println("Vector B: ");
			for (int i=0; i<B.length; i++) {
				System.out.print("Introduce un valor: ");
				B[i]=sc.nextInt();
			}
			
		} catch (Exception e) {
			System.err.println(">> ERROR: Tipo de dato no válido");
		} finally {
			sc.close();
		}
		// Almacenamos los elementos de A y B en C de forma alterna
		// Declaramos un ídice incremental para C
		int incremental=0;
		
		for (int i=0; i<TAM; i++) {
			C[incremental]=A[i];
			incremental++;
			C[incremental]=B[i];
			incremental++;
		}
		// Mostramos los elementos almacenados en A
		mostrar(A);
		
		// Mostramos los elementos almacenados en B
		mostrar(B);
		
		// Mostramos los elementos almacenados en C
		mostrar(C);
	}

}
