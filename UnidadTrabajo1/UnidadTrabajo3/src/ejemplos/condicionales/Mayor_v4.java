package ejemplos.condicionales;

public class Mayor_v4 {
	
	/**
	 * Función que devuelve un número aleatorio entre 1 y N
	 * @param N - límite superior
	 * @return número aleatorio tipo entero
	 */
	public static int aleatorio(int N) {
		return (int)(Math.random()*N+1);
	}
	
	/**
	 * Función que devuelve el número mayor de dos
	 * @param x - número entero
	 * @param y - número entero
	 * @return el mayor de dos número enteros
	 */
	public static int mayor(int x, int y) {
		if (x>y)
			return x;
		else
			return y;
	}
	
	public static void main(String[] args) {
		// Declaramos e inicializamos las variables
		int a=aleatorio(10);
		int b=aleatorio(10);
		
		System.out.println("Valores: "+a+" , "+b);
		System.out.println("Mayor: "+mayor(a,b));
	}

}
