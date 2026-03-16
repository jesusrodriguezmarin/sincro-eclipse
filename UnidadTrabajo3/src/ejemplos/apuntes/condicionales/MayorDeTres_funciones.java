package ejemplos.apuntes.condicionales;

public class MayorDeTres_funciones {

	/**
	 * Función que devuelve el mayor de dos números enteros
	 * @param x - número entero
	 * @param y - número entero
	 * @return el mayor de dos números enteros
	 */
	public static int mayor(int x, int y) {
		if (x > y)
			return x;
		else
			return y;
	}
	
	/**
	 * Función que devuelve un número aleatorio
	 * @param N - número entero
	 * @return un número aleatorio entre 1 y N
	 */
	public static int aleatorio(int N) {
		return (int)(Math.random()*N+1);
	}
	
	// Programa principal
	public static void main(String[] args) {
		// Declaración e inicialización de variables
		int a = aleatorio(50);
		int b = aleatorio(50);
		int c = aleatorio(50);
		System.out.println("Valores: "+a+", "+b+" y "+c);
		System.out.println("El mayor es: "+mayor(mayor(a, b),c));

	}

}
