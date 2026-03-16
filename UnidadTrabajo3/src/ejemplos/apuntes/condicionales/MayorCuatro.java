package ejemplos.apuntes.condicionales;

public class MayorCuatro {

	/**
	 * Función que devuelve el mayor de dos números
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
	public static void main(String[] args) {
		// Declaración e inicialización de variables
		int a = MayorDeDos_aleatorio.aleatorio(100);
		int b = MayorDeDos_aleatorio.aleatorio(100);
		int c = MayorDeDos_aleatorio.aleatorio(100);
		int d = MayorDeDos_aleatorio.aleatorio(100);
		
		System.out.println("Valores: "+a+", "+b+", "+c+" y "+d);
		System.out.println("El mayor es: "+mayor(mayor(a, b), mayor(c,d)));

	}

}
