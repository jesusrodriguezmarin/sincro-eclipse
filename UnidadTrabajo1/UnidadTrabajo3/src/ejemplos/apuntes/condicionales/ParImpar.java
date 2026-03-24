package ejemplos.apuntes.condicionales;

public class ParImpar {

	/**
	 * Función para aleatorio
	 * @param N - número entero
	 * @return un número entero entre 1 y N
	 */
	public static int aleatorio(int N) {
		return (int)(Math.random()*N+1);
	}
	// Programa principal
	public static void main(String[] arg) {
		// Declaración e inicialización de un número aleatorio entre 1 y 50
		int num = aleatorio(50);
		
		// Cálculo de par o impar e impresión
		if (num % 2 == 0) {
			System.out.println(num+" es par");	
		} else {
			System.out.println(num+" es impar");
		}
	}

}
