package ejemplos.apuntes.condicionales;

public class MayorDeDos_funcion {
	/**
	 * Función que devuelve el mayor de 2 valores pasados por parámetro
	 * @param x - número entero
	 * @param y - número entero
	 * @return devuelve el mayor de x e y
	 */
	public static int mayor(int x, int y) {
		if (x > y) {
			return x;
		} else {
			return y;
		}
	}
	
	public static void main(String[] args) {
		// Declaración e inicialzación de las variables
		int a = 10, b = 20;
		System.out.println("Valores: "+a+" y "+b);
		System.out.println("Mayor: "+mayor(a, b));
	}

}
