package matrices.ejemplos;

import java.util.Scanner;

public class Ejemplo04 {

	// Costante para el tamaño de una matriz cuadrada: TAMxTAM
	final static int TAM=3;
	
	/**
	 * Procedimiento que muestra por pantalla los valores almacenados en una matriz
	 * @param M - matriz de valores enteros
	 */
	public static void mostrarMatriz(int M[][]) {
		for (int filas=0; filas<M.length; filas++) {
			for (int columnas=0; columnas<M[filas].length; columnas++) {
				// Imprime primero fila
				System.out.print(M[filas][columnas]+"\t");
			}
			// Salto e imprime columna
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		// Declaramos y creamos una una matriz cuadrada
		int[][] matriz = new int[TAM][TAM];		// Matriz cuadrada, mismo nº de filas que columnas
		
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Cotrol de excepciones
		try {
			
		} catch (Exception e) {
			System.out.println(">> ERROR: ");
		} finally {
			sc.close();
		}
		
		// Mostramos la matriz
		System.out.println("Matriz inicial: ");
		mostrarMatriz(matriz);
		
		// Vamos a incrementar en una unidad cada valor almacenado en la matriz
		for (int i=0; i<matriz.length; i++) {
			for (int j=0; j<matriz[i].length; j++) {
				matriz[i][j]++;
			}
		}
		// Mostramos por pantalla los valores actuales
		System.out.println("\nMatriz actual: ");
		mostrarMatriz(matriz);
		
		// Mostramos la diagonal principal
		System.out.println("\nDiagonal principal: ");
		for (int i=0; i<matriz.length; i++) {
			System.out.print(matriz[i][i]+" ");
		}
		
		// Vamos a incrementar en una unidad los valores de la diagonal principal
		for (int i=0; i<matriz.length; i++) {
			matriz[i][i]++;
		}
		// Mostramos por pantalla los valores actuales
		System.out.println("\nMatriz actual: ");
		mostrarMatriz(matriz);
		
		// Mostramos la diagonal principal
		System.out.println("\nDiagonal principal: ");
		for (int i=0; i<matriz.length; i++) {
			System.out.print(matriz[i][i]+" ");
		}
	}

}
