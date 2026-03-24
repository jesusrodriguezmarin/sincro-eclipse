package interfaz;

public class Triangulo implements Figura {

	/* Atributos */
	private int base;
	private int altura;
	
	/**
	 * Constructor
	 * @param base
	 * @param altura
	 */
	Triangulo(int base, int altura){
		this.base=base;
		this.altura=altura;
	}

	/**
	 * Calcula el area de un triangulo
	 * @return area del triangulo
	 */
	public int area() {
		// TODO Auto-generated method stub
		return (base*altura);
	}
}
