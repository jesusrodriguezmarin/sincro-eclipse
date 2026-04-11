package recuperaciones.matrices;

public class Ej2 {

	public static void mostrar(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		// Creamos una matriz de 3 x 3
		int[][] m = {{1, 2, 3}, {4,5,6}, {7,8,9}};

		// Mostramos la matriz
		System.out.println("La matriz resultante es: ");
		mostrar(m);
	}

}
