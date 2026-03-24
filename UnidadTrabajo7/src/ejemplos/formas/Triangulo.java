package ejemplos.formas;

public class Triangulo implements Formas {

	// Atributos
	protected int base;
	protected int altura;

	// Constructor
	public Triangulo(int base, int altura) {
		this.base = base;
		this.altura = altura;
	}
	
	/**
	 * Devuelve el área del triangulo
	 * @return {int} área del triángulo
	 */
	public int area() {
		return (base*altura)/2;
	}
}
