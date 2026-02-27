package funcionesGlobales;

public class funcionAleatorio {

	/**
	 * Función que devuelve un número aleatorio entre 1 y N
	 * @param N - límite superior
	 * @return número aleatorio tipo entero
	 */
	public static int aleatorio(int N) {
		return (int)(Math.random()*N+1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
