package ejercicios2;

public class Ejercicio1B {
	
	public static void Bienvenida(String nombre) {
		
		/**
		 * Genero un procedimiento con nombre para llamarlo con dif nombres en el main
		 */
		System.out.println("Hola "+nombre+"!");
		System.out.println("Bienvenido al C.E.S Vega-Media");
		System.out.println("En este curso aprenderas Java");
		System.out.println("Espero que te guste "+nombre+"\n");
	}
	public static void main(String[] args) {
		
		// Muestra por pantalla un mensaje de bienvenida para diferentes nombres
		Bienvenida("Juan");
		Bienvenida("Pablo");
		Bienvenida("Pedro");
	}
}
