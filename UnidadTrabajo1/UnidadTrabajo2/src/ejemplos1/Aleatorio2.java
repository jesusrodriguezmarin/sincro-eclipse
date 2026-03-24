package ejemplos1;

public class Aleatorio2 {
	
	/**
	 * Devuleve un númereo aleatorio entre 1 y num
	 * @param num - límite superior
	 * @return un número entero entre 1 y num
	 */
	public static int aleatorio(int num) { // El parámetro (int num) aqui se declara se inicializa con el valor del argumento
		return (int)(Math.random()*num+1);
		
	}
	
	// Programa principal
	public static void main(String[] args) {
		// Generamos un numero aleatorio entre 1 y 10
		System.out.println("Numero aleatorio entre 1 y 10: "+aleatorio(10)); // El parámetro (int num) aqui  se inicializa 
		
		// Generamos un numero aleatorio entre 1 y 10
		System.out.println("Numero aleatorio entre 1 y 50: "+aleatorio(50));
		
		// Generamos un numero aleatorio entre 1 y 10
		System.out.println("Numero aleatorio entre 1 y 100: "+aleatorio(100));
		
		// Generamos un numero aleatorio entre 1 y 10
		System.out.println("Numero aleatorio entre 1 y 1000: "+aleatorio(1000));
		
		// Generamos un numero aleatorio entre 1 y 10
		System.out.println("Numero aleatorio entre 1 y 6: "+aleatorio(6));	
	}

}
