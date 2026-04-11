package recuperaciones.matrices;

public class Ej3 {

	// Constante para el tamaño de la matriz cuadrada
	final static int TAM = 3;
	
	// Programa principal
	public static void main(String[] args) {

		// Creamos una matriz cuadrada
		int[][] m = new int[TAM][TAM];
		
		System.out.println("Matriz inicializada: ");
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j]+"\t");
			}
			System.out.println();
		}
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j]++;
			}
		}
		System.out.println("\nMatriz incrementada: ");
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
