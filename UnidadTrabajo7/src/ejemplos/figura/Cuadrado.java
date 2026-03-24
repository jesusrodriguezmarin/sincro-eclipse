package ejemplos.figura;

public class Cuadrado extends Figura{

	// Atributo
	protected int lado;
	
	// Constructor
	public Cuadrado(int lado) {
		this.lado=lado;
	}

	/**
	 * Devuelve el lado del cuadrado
	 * @return {int} lado del cuadrado
	 */
	public int getLado() {
		return lado;
	}

	/**
	 * Establece el lado del cuadrado
	 * @param lado {int} el lado a establecer
	 */
	public void setLado(int lado) {
		this.lado = lado;
	}
	
	
}
