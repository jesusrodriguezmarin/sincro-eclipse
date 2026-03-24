package ejemplos1;

public class CircFuncion {
	
	final static double PI=3.1416; // aqui final double PI=3.1416; es una variable global y no hace falta declararla localmente
	
	// En el cuerpo de un procedimiento VOID no hay return
	// En el cuerpo de una función INT/DOUBLE no hay print
	
	/**
	 * Función que cácula el área de un círculo
	 * @param radio del círculo (tipo entero)
	 * @return área del círculo de tipo r
	 */
	public static double area(int r) {
		// Aqui final double PI=3.1416; seria una variable local
		return PI*r*r;
	}
	
	/**
	 * Función que cálcula la longitud de una circunferencia
	 * @param r es el radio para la fórmula tipo int
	 * @return devuleve el resultado de la fórmula de longitud
	 */
	public static double longitud(int r) {
		// Aqui final double PI=3.1416; seria una variable local
		return 2*PI*r;
	}
	
	public static void main(String[] args) {

		// Declaramos y definimos radio
		int radio=3; // radio aqui es una variable local
		
		// Mostramos la longitud de la circunferencia
		System.out.println("La longitud de la circunferencia r: "+radio+" es: "+longitud (radio));
		// Mostramos el area del circulo
		System.out.println("El área de un círculo r: "+radio+" es: "+area(radio));
		
		radio=4;
		// Mostramos la longitud de la circunferencia
		System.out.println("La longitud de la circunferencia r: "+radio+" es: "+longitud (radio));
		// Mostramos el area del circulo
		System.out.println("El área de un círculo r: "+radio+" es: "+area(radio));
		
		radio=5;
		// Mostramos la longitud de la circunferencia
		System.out.println("La longitud de la circunferencia r: "+radio+" es: "+longitud (radio));
		// Mostramos el area del circulo
		System.out.println("El área de un círculo r: "+radio+" es: "+area(radio));
	}

}
