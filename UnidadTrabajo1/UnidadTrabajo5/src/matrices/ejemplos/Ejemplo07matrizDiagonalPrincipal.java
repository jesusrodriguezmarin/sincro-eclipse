package matrices.ejemplos;

public class Ejemplo07matrizDiagonalPrincipal {

	// Costante para el tamaño de una matriz cuadrada: TAMxTAM
	final static int TAM=6;
	
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
		
		// Mostramos la matriz
		System.out.println("Matriz inicial: ");
		mostrarMatriz(matriz);

		
		// Mostramos la diagonal principal
		System.out.println("\nDiagonal principal: ");
		for (int i=0; i<matriz.length; i++) {
			System.out.print(matriz[i][i]+" ");
		}

	}

}
