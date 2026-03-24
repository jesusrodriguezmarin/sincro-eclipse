package matrices.ejemplos;

public class Ejemplo01 {

	public static void main(String[] args) {
		
		// Creamos una matriz
		int[][] matriz= {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}};
		
		// Mostramos por pantalla los valores almacenados en la matriz
		for (int filas=0; filas<matriz.length; filas++) {
			for (int columnas=0; columnas<matriz[filas].length; columnas++) {
				// Imprime primero fila
				System.out.print(matriz[filas][columnas]+"\t");
			}
			// Salto e imprime columna
			System.out.println();
		}

	}

}
