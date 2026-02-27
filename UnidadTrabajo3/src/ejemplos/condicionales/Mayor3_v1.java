package ejemplos.condicionales;

public class Mayor3_v1 {

	/**
	 * Función que devuelve un número aleatorio entre 1 y N
	 * @param N - número entero límite superior
	 * @return un número entero aleatorio entre 1 y N
	 */
	public static int aleat(int N) {
		return (int)(Math.random()*N+1);
	}
	
	/**
	 * Función que devuelve el mayor de tres números pasados por parámetro
	 * @param x - número entero
	 * @param y - número entero
	 * @param z - número entero
	 * @return el mayor de tres números enteros
	 */
	public static int mayor(int x, int y, int z) {
		if (x>=y && x>=z) {
			return x;
		} else if (y>=x && y>=z) {
			return y;
		} else
			return z;
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Declaración de variables
		int a, b, c;	// Variables con límite superior 10
		// Inicialización de variables llamando a la función aleat con límite 10
		a=aleat(10);
		b=aleat(10);
		c=aleat(10);
		
		// Muestro los valores participantes por pantalla
		System.out.println("Valores: "+a+" "+b+" "+c);
		// Muestro el mayor valor de los tres
		System.out.println("Mayor: "+mayor(a, b, c));
	}

}
