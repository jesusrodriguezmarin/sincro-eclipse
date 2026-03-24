package matrices.ejercicios;

public class Ej01diagonalPrincipal1resto0 {

	// Constante para la matriz cuadrada
	final static int TAM=5;
	
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
			System.out.println();
		}
	}
	
	
	// Programa principal
	public static void main(String[] args) {
		// Creamos una matriz cuadrada
		int[][] matriz= new int[TAM][TAM];
		
		// Incrementamos la diagonal principal en 1
		for (int i=0; i<matriz.length; i++) {
			matriz[i][i]++;
		}
		
		// Mostramos la matriz
		System.out.println("Matriz incrementada:");
		mostrarMatriz(matriz);
		
		System.out.println("\nDiagonal principal: ");
		// Mostramos diagonal principal sola
		for (int i=0; i<matriz.length; i++) {
			System.out.print(matriz[i][i]+"\t");
		}
		System.out.println();

	}

}
