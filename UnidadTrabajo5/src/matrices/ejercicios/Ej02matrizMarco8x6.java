package matrices.ejercicios;

public class Ej02matrizMarco8x6 {
	
	// Constante para la cantidad de filas
	final static int F=8;
	
	// Constante para la cantidad de columnas
	final static int C=6;
	
	/**
	 * Procedimiento que muestra todos los elementos de una matriz
	 * @param M - matriz de números enteros
	 */
	public static void mostrar(int M[][]) {
		for (int f=0; f<M.length; f++) {
			for (int c=0; c<M[f].length; c++) {
				// Muestra y separación para cada columna
				System.out.print(M[f][c]+"\t");
			}
			// Salto de fila
			System.out.println();
		}
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos la matriz
		int M[][]= new int[F][C];
	
		// Mostramos la matriz inicial
		System.out.println("Matriz inicial: ");
		mostrar(M);
		
		// Incrementamos en 1 el marco de la matriz
		for (int f=0; f<M.length; f++) {
			for (int c=0; c<M[f].length; c++) {
				// Si la fila es posición `[0] o en última posición M.length-1
				// o si la columna es posición [0] o última M[f].length-1
				if (f==0 || f==M.length-1 || c==0 || c==M[f].length-1) {
					M[f][c]++;
				}
			}
		}
		// Mostramos la matriz incrementada
		System.out.println("\nMatriz marco: ");
		mostrar(M);
		
	}

}
