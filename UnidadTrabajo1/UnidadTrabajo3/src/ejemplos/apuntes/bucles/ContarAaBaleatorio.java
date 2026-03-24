package ejemplos.apuntes.bucles;

public class ContarAaBaleatorio {

	/**
	 * Función que genera un número entero aleatorio
	 * @param N - límite superior
	 * @return un número entero aleatorio
	 */
	public static int aleatorio(int N) {
		return (int)(Math.random()*N+1);
	}
	
	// Programa principal
	public static void main(String[] args) {
		// Declaramos dos números aleatorios
		int a = aleatorio(50);
		int b = aleatorio(50);
		
		System.out.println("Contamos desde "+a+" hasta "+b);
		// Contamos desde a a b de forma ascendente o descendente
		if (a < b) {
			for (int conta = a; conta <= b; conta++)
				System.out.print(conta+" ");
		} else {
			for (int conta = a; conta >= b; conta--)
				System.out.print(conta+" ");
		}

	}

}
