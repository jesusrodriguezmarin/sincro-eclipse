package ejemplos.figuras;

public class Rectangulo implements Figura {

	// Atributos
	private int ancho;
	private int alto;
	
	
	/**
	 * Constructor con 2 parámetros
	 * @param ancho de la figura
	 * @param alto de la figura
	 */
	public Rectangulo(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
	}

	/**
	 * Calcula el área del rectángulo
	 * @return {int} el área del rectángulo
	 */
	@Override
	public int area() {
		return this.alto*this.ancho;
	}

	@Override
	public String toString() {
		return "Área del rectangulo: ("+this.alto+" x "+this.ancho+")";
	}
	
	
}
