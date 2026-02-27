package ejercicios2;

public class Ejercicio8B {

	// Declaración global de la constante PI
	final static double PI=3.1416;
	
	/**
	 * Funcion que calcula la longitud de un círculo con radio r
	 * @param r número de tipo entero que le dammos al radio
	 * @return longitud de tipo double
	 */
	public static double longitud(int r) {
		return 2*PI*r;
	}
	
	/**
	 * Funcion que calcula el area de una circunferencia con radio r
	 * @param r número de tipo entero que le dammos al radio
	 * @return area de tipo double
	 */
	public static double area(int r) {
		return PI*r*r;
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		int radio=4;
		
		// Cálculo y muestra por pantalla de la longitud de una circunferencia
		System.out.println("La longitud de un círculo con radio "+radio+" es: "+longitud(radio));
		// Cálculo y muestra por pantalla del área de un círculo
		System.out.println("El área de una círcunferencia con radio "+radio+" es: "+area(radio));
		
		radio=5;
		// Cálculo y muestra por pantalla de la longitud de una circunferencia
		System.out.println("La longitud de un círculo con radio "+radio+" es: "+longitud(radio));
		// Cálculo y muestra por pantalla del área de un círculo
		System.out.println("El área de una círcunferencia con radio "+radio+" es: "+area(radio));
	}

}
