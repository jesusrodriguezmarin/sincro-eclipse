package ejemplos.apuntes.condicionales;

public class MayorDeDos_func_aleat {

	/**
	 * Función que devuelve el mayor de dos números entros
	 * @param x - número entero
	 * @param y - núemro entero
	 * @return el mayor de dos números enteros
	 */
	public static int mayor(int x, int y) {
		if (x > y) {
			return x;
		} else {
			return y;
		}
	}
	
	/**
	 * Función que devuelve un número aleatorio
	 * @param N - número entero
	 * @return un número aleatorio entre 1 y N
	 */
	public static int aleatorio(int N) {
		return (int)(Math.random()*N+1);
	}
	
	public static void main(String[] args) {
		// Declaración d inicialización
		int a = aleatorio(50);
		int b = aleatorio(50);
		System.out.println("Valores: "+a+" y "+b);
		System.out.println("El mayor es: "+mayor(a, b));

	}

}
