package ejemplos.apuntes.condicionales;

public class MayorDeDos_aleatorio {

	/**
	 * Función que devuelve un número aleatorio entre 1 y N
	 * @param N - número entero
	 * @return un número aleatorio entero entre 1 y N
	 */
	public static int aleatorio(int N) {
		return (int)(Math.random()*N+1);
	}
	public static void main(String[] args) {
		// Declaración e inicialización de variables
		int a = aleatorio(100);
		int b = aleatorio(100);
		
		// Condicional para mostrar el mayor
		if (a > b) {
			System.out.println(a+" es mayor que "+b);
		} else if (a == b) {
			System.out.println(a+" es igual a "+b);
		} else {
			System.out.println(b+" es mayor que "+a);
		}
	}

}
