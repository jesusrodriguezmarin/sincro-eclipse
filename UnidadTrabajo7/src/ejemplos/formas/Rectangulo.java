package ejemplos.formas;

public class Rectangulo implements Formas {

	// Atributos
	protected int ancho;
	protected int alto;

	// Constructor
	public Rectangulo(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
	}
	
	/**
	 * Devuelve el área del rectángulo
	 * {int}
	 */
	public int area() {
		return ancho*alto;
	}
}
