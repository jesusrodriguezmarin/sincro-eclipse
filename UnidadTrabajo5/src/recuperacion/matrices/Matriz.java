package recuperacion.matrices;

public class Matriz {

	public static void main(String[] args) {

		// Primera matriz
		int matriz[][] = new int[4][4];

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}

	}

}
