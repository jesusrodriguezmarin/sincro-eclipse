package ejemplos.condicionales;

public class Mayor_v3_fAleatorio {
	
	/**
	 * Función que devuelve un número aleatorio entre 1 y N
	 * @param N - límite superior
	 * @return número aleatorio tipo entero
	 */
	public static int aleatorio(int N) {
		return (int)(Math.random()*N+1);
	}
	
	public static void main(String[] args) {
		// Declaramos e inicializamos las variables
		int a=aleatorio(10);
		int b=aleatorio(10);
		
		// Comparamos y mostramos el resultado en pantalla
		if (a>b) {
			System.out.println(a+" es mayor que "+b);
		} else if (a<b) {
			System.out.println(a+" es menor que "+b);
		} else {
			System.out.println(a+" es igual que "+b);
		}

	}

}
