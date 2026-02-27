package ejercicios2;

public class Ejercicio2B {

	/**
	 * Funcion que resulta un número aleatorio del 1 al 6
	 * @param num número aleatorio tipo entero
	 * @return un númerp aleatorio entero entre 1 y 6
	 */
	public static int dado() {
		return (int)(Math.random()*6+1);
	}
	
	public static void main(String[] args) {
		
		// Muestra por pantalla 5 tiradas aleatorias de un dado de 6 caras
		System.out.println("5 tiradas aleatorias de un dado de 6 caras");
		System.out.println(dado());
		System.out.println(dado());
		System.out.println(dado());	
		System.out.println(dado());	
		System.out.println(dado());	
	}

}
