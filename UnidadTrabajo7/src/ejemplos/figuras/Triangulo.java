package ejemplos.figuras;

public class Triangulo implements Figura {

	// Atributos
	private int base;
	private int altura;
	
	/**
	 * Constructor con 2 parámetros
	 * @param base del triángulo
	 * @param altura del triángulo
	 */
	public Triangulo(int base, int altura) {
		this.base = base;
		this.altura = altura;
	}

	/**
	 * Calcula el área del triángulo
	 * @return {int} el área del triángulo
	 */
	@Override
	public int area() {
		return (this.base*this.altura)/2;
	}

	@Override
	public String toString() {
		return "Área del triangulo: "+this.area();
	}
	
	
	
}
