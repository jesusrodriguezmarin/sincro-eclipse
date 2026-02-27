package matrices.ejercicios;

import java.util.Scanner;

public class Ej05leer3x3sumarYmostrarSuma_v2 {

	// Constante para el tamaño de una matriz cuadrada 3x3
	final static int TAM=3;
	
	/**
	 * Procedimiento que muestra todos los elementos de una matriz
	 * @param M - matriz de números enteros
	 */
	public static void mostrarMatriz(int M[][]) {
		for (int f=0; f<M.length; f++) {
			for (int c=0; c<M[f].length; c++) {
				System.out.print(M[f][c]+"\t");
			}
			System.out.println();
		}
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos la matriz cuadrada A
		int A[][]= new int[TAM][TAM];
		
		// Creamos la matriz cuadrada A
		int B[][]= new int[TAM][TAM];
		
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Control de excepciones
		try {
			System.out.println("Matriz A 3x3:");
			for (int f=0; f<A.length; f++) {
				for (int c=0; c<A[f].length; c++) {
					System.out.print("A["+f+"]["+c+"]: ");
					A[f][c]=sc.nextInt();
				}
			}
			System.out.println("Matriz B 3x3:");
			for (int f=0; f<A.length; f++) {
				for (int c=0; c<A[f].length; c++) {
					System.out.print("B["+f+"]["+c+"]: ");
					B[f][c]=sc.nextInt();
				}
			}
			
		} catch (Exception e) {
			System.err.println(">> ERROR: Tipo de dato no válido.");
		} finally {
			sc.close();
		}
		// Mostramos la matriz A
		System.out.println("\nMatriz A:");
		mostrarMatriz(A);
		
		// Mostramos la matriz B
		System.out.println("\nMatriz B:");
		mostrarMatriz(B);
		
		// Creamos otra matriz C para albergar la suma
		int[][] C = new int[TAM][TAM];
		
		// Sumamos las matrices
		for (int i=0; i<TAM; i++) {
			for (int j=0; j<TAM; j++) {
				C[i][j]= A[i][j] + B[i][j];
			}
		}
	
		// Mostramos la matriz resultado de la suma de A y B
		System.out.println("\nMatriz C suma: ");
		mostrarMatriz(C);
		

	}

}
