package matrices.ejemplos;

public class Ejemplo02 {

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
		
		// Creamos una matriz
		int[][] matriz1= {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}};
		int[][] matriz2= {{1,2,3,4}, {16,17,18,19}, {11,12,13,14}};
		
		// Mostramos por pantalla los valores almacenados en la matriz
		// Ejemplo de mostrar directamente en el MAIN
		System.out.println("Matriz 1: ");
		for (int filas=0; filas<matriz1.length; filas++) {
			for (int columnas=0; columnas<matriz1[filas].length; columnas++) {
				// Imprime primero fila
				System.out.print(matriz1[filas][columnas]+"\t");
			}
			// Salto e imprime columna
			System.out.println();
		}
		// Mostramos por pantalla los valores almacenados en la matriz
		// Ejemplo de mostrar llamando a un procedimiento creado fuera del MAIN
		System.out.println("\nMatriz 2: ");
		mostrarMatriz(matriz2);
	}

}
