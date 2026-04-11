package recuperaciones.matrices;

public class Ej5 {

	// Creamos una matr// Constantes
	final static int F = 3;
	final static int C = 5;
	final static int LIM = 20;

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
		int[][] m = new int[F][C];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = aleatorio(LIM);
			}
		}

		// Mostramos la matriz
		System.out.println("La matriz resultante es: ");
		mostrar(m);

		System.out.println("Con *: ");
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] % 2 != 0) {
					System.out.print("*\t");
				} else {
					System.out.print(m[i][j]+"\t");
				}
			}
			System.out.println();
		}
		
		System.out.println("Con *: ");
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] % 2 == 0) {
					System.out.print("*\t");
				} else {
					System.out.print(m[i][j]+"\t");
				}
			}
			System.out.println();
		}
		
	}

}
