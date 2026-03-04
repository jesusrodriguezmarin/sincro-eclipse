package ejercicios;

public class Finanzas04 {

	// Atributo
	double cambio;
	
	/**
	 * Constructor por defecto
	 */
	Finanzas04() {
		cambio=1.36;
	}
	
	/**
	 * Constructor
	 * @param c cambio - double
	 */
	Finanzas04(double c){
		cambio = c;
	}
	
	/**
	 * Convierte una cantidad de dolares a euros
	 * @param n
	 * @return
	 */
	public double dolarToEuro(double n) {
		return n/cambio;
	}
	
	/**
	 * Convierte de euros a dolares
	 * @param n
	 * @return
	 */
	public double EuroToDolar(double n) {
		return n*cambio;
	}
}
