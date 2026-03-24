package ejemplos.arrayFigura;

public class Cuadrado extends ArrayFigura {

	// Atributo
	protected int lado;

	// Constructor
	public Cuadrado(int lado) {
		this.lado = lado;
	}
	
	/**
	 * Calcula el área del cuadrado
	 * @return {double} el área del cuadrado
	 */
	public double area() {
		return lado * lado;
	}

}
