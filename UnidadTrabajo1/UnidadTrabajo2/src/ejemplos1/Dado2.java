package ejemplos1;

public class Dado2 {

	/**
	 * Función que devuelve el valor aleatorio de lanzar un dado
	 * @return un numero entero entre 1 y 6
	 */
	public static int dado() {
		return (int)(Math.random()*6+1);
	}
	
	// Programa principal
	public static void main(String[] args) {
		System.out.println("Primera tirada dado: "+dado());
		System.out.println("Segunda tirada dado: "+dado());
		System.out.println("Tercera tirada dado: "+dado());
		System.out.println("Cuarta tirada dado: "+dado());
		System.out.println("Quinta tirada dado: "+dado());
		System.out.println("Sexta tirada dado: "+dado());	
	}

}
