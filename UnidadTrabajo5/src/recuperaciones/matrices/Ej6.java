package recuperaciones.matrices;

public class Ej6 {

	// Creamos una matr// Constantes
	final static int F = 3;
	final static int C = 4;
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

	/**
	 * Muestra el mayor valor almacenado en la matriz
	 * @param m - matriz a comprobar
	 * @return {int} el mayor
	 */
	public static int mayor (int[][] m) {
		int mayor = m[0][0];
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] > mayor) {
					mayor = m[i][j];
				}
				
			}
		}
		return mayor;
	}
	
	/**
	 * Muestra el mayor valor almacenado en la matriz
	 * @param m - matriz a comprobar
	 * @return {int} el mayor
	 */
	public static int menor (int[][] m) {
		int menor = m[0][0];
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] < menor) {
					menor = m[i][j];
				}
				
			}
		}
		return menor;
	}
	
	// Programa principal
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
		
		// El mayor elemento de la matriz
		System.out.println("El mayor elemento de la matriz es: "+mayor(m));
		System.out.println("El menor elemento de la matriz es: "+menor(m));

		

	}

}
