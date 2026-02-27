package ejemplos1;

public final class Longitudes2 {
	
	/**
	 * Función que calcula y devuelve la longitud de una circunferencia
	 * @param radio - radio de la circunferencia
	 * @return longitud de la circunferencia
	 */
	
	public static double longitud (int radio) {
		final double PI=3.1416;
		double longitudCirc=2*PI*radio;
		return longitudCirc;
	}
	
	// Programa principal
	public static void main(String[] args) {
	
		System.out.println("Longitud de la circunferencia de radio "+2+": "+longitud(2));
		System.out.println("Longitud de la circunferencia de radio "+3+": "+longitud(3));
		System.out.println("Longitud de la circunferencia de radio "+4+": "+longitud(4));	
		System.out.println("Longitud de la circunferencia de radio "+5+": "+longitud(5));
	}

}
