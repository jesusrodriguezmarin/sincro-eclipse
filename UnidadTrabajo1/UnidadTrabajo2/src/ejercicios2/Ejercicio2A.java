package ejercicios2;

public class Ejercicio2A {

	public static void main(String[] args) {

		// Muestra por pantalla 5 tiradas aleatorias de un dado de 6 caras
		System.out.println("5 tiradas aleatorias de un dado de 6 caras:");
		System.out.println("Pimera tirada: "+(int)(Math.random()*6+1));
		System.out.println("Segunda tirada: "+(int)(Math.random()*6+1));
		System.out.println("Tercera tirada: "+(int)(Math.random()*6+1));
		System.out.println("Cuarta tirada: "+(int)(Math.random()*6+1));
		System.out.println("Quinta tirada: "+(int)(Math.random()*6+1));	
	}

}
