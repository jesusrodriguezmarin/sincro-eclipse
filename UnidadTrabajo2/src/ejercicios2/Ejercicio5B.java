package ejercicios2;

public class Ejercicio5B {

	/**
	 * Funcion para sumar dos números enteros
	 * @param a número tipo entero
	 * @param b número tipo entero
	 * @return un número entero resultado de la suma de a+b
	 */
	public static int suma(int a, int b) {
		return (a+b);
	}
	
	/**
	 * Funcion para restar dos números enteros
	 * @param a número tipo entero
	 * @param b número tipo entero
	 * @return un número entero resultado de la resta de a-b
	 */
	public static int resta(int a, int b) {
		return (a-b);
	}
	
	public static void main(String[] args) {
		
		// Muestra por pantalla de la suma de las variables llamando a la función
		int a=5, b=6;
		System.out.println("La suma de "+a+" + "+b+" es: "+suma(a, b));
		
		// Muestra por pantalla de la suma de las variables llamando a la función
		a=1; b=2;
		System.out.println("La suma de "+a+" + "+b+" es: "+suma(a, b));
		
		// Muestra por pantalla de la resta de las variables llamando a la función
		a=10; b=5;
		System.out.println("La suma de "+a+" - "+b+" es: "+resta(a, b));
				
		// Muestra por pantalla de la resta de las variables llamando a la función
		a=15; b=15;
		System.out.println("La suma de "+a+" - "+b+" es: "+resta(a, b));	
	}

}
