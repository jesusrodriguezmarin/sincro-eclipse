package ejercicios2;

public class Ejercicio3B {

	/**
	 * Funcion para obtener un número aleatorio entre 1 y num
	 * @param num es el número máximo que puede salir
	 * @return un número tipo entero entre 1 y num
	 */
	public static int aleatorio(int num) {
		return (int)(Math.random()*num+1);
	}
	
	public static void main(String[] args) {

		// Muestra por pantalla un número aleatorio entre 1 y 10
		System.out.println(aleatorio(10));
		// Muestra por pantalla un número aleatorio entre 1 y 50
		System.out.println(aleatorio(50));
		// Muestra por pantalla un número aleatorio entre 1 y 100
		System.out.println(aleatorio(100));
		// Muestra por pantalla un número aleatorio entre 1 y 6
		System.out.println(aleatorio(6));
	}

}
