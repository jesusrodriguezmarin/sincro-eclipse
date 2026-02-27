package ejemplos1;

public final class Area {
	
	/**
	 * Función que calcula y devuelve el area de un circulo
	 * @param radio - radio del circulo
	 * @return a
	 */
	
	public static double area(int radio) {
		final double PI=3.1416;
		return PI*radio*radio;
	}
	
	// Programa principal
	public static void main(String[] args) {
	
		System.out.println("El área de un círculo de radio "+2+": "+area(2));
		System.out.println("El área de un círculo de radio "+3+": "+area(3));
		System.out.println("El área de un círculo de radio "+4+": "+area(4));	
		System.out.println("El área de un círculo de radio "+5+": "+area(5));
	}

}
