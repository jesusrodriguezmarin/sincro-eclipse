package ejercicios2;

public class Ejercicio6B {

	/**
	 * Funcion que cálcula la mitad de un número n
	 * @param n es la variable de tipo entero que le damos en la llamada
	 * @return la mitad n tipo double
	 */
	public static double mitad(int n) {
		return n/2.0;
	}
	
	/**
	 * Funcion que cálcula el doble de un número n
	 * @param n es la variable de tipo entero que le damos en la llamada
	 * @return el doble de n tipo entero
	 */
	public static int doble(int n) {
		return n*2;
	}
	
	/**
	 * Funcion que cálcula el triple de un número n
	 * @param n s la variable de tipo entero que le damos en la llamada
	 * @return el triple de n tipo entero
	 */
	public static int triple(int n) {
		return n*3;
	}
	
	// Programa principal
	public static void main(String[] args) {

		int num=5;
		
		// Mitad de num
		System.out.println("La mitad de "+num+" es: "+mitad(num));
		// doble de num
		System.out.println("El doble de "+num+" es: "+doble(num));
		// triple de num
		System.out.println("El triple de "+num+" es: "+triple(num));
	}

}
