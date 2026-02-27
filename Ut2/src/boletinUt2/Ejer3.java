package boletinUt2;

public class Ejer3 {
	
	/**
	 * Función para calcular un porcentaje de descuento
	 * @param precio número tipo double
	 * @param descuento número tipo int
	 * @return resultado del descuento tipo double
	 */
	public static double precioFinal(double precio, int descuento) {
		double descontar=(precio*descuento/100);
		double descontado=precio-descontar;
		return descontado;
	}
	
	// Programa principal
	public static void main(String[] args) {	
		
		double precio=85;
		int descuento=30;
		// Llamada de la función de porcentaje de descuento
		System.out.println("Precio (€): "+precio);
		System.out.println("Descuento (%): "+descuento);
		System.out.println("Precio rebajado: "+precioFinal(precio, descuento));	
	}
	
}
