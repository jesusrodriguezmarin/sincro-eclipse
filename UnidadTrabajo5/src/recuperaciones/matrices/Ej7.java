package recuperaciones.matrices;

public class Ej7 {

	// Constantes
	final static int TAM = 4;
	final static int LIM = 50;

	/**
	 * Función que devuelve un número aleatorio entre 1 y N
	 * 
	 * @param N - Limite superior para generar los números
	 * @return {int} un número aleatorio
	 */
	public static int aleatorio(int N) {
		return (int) (Math.random() * N + 1);
	}

	public static void mostrar(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		// Creamos una matriz de 3 x 5
		int[][] m = new int[TAM][TAM];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = aleatorio(LIM);
			}
		}

		// Mostramos la matriz
		System.out.println("La matriz resultante es: ");
		mostrar(m);

		// Mostramos la diagonal principal
		System.out.println("La diagonal principal es: ");
		for (int i = 0; i < m.length; i++) {
			System.out.print(m[i][i] + " ");
		}

		// Mostramos la diagonal principal
		System.out.println("\nLa diagonal principal es: ");
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (i == j) {
					System.out.print(m[i][j]+" ");
				}
			}
		}

	}

}
