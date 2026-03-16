package ejemplos.apuntes.condicionales;

public class ParImpar_func {

	/**
	 * Función para aleatorio
	 * @param N - número entero
	 * @return un número entero aleatorio
	 */
	public static int aleatorio(int N) {
		return (int)(Math.random()*N+1);
	}
	
	/**
	 * Función booleana para par o impar
	 * @param N - número entero
	 * @return true si N es par o false si N no es par (impar)
	 */
	public static boolean espar(int N) {
		if (N % 2 == 0)
			return true;
		else
			return false;
	}
	
	// Programa principal
	public static void main(String[] args) {
		// Declaración e inicializació
		int num = aleatorio(50);
		
		// Indicamos si es par o impar
		if (espar(num) == true)
			System.out.println(num+" es par");
		else
			System.out.println(num+" es impar");
	}

}
