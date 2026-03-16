package extendsEjemplo;

public class Cuadrado extends Figura {
	
	// Atributo
	private int lado;
	
	/*
	 * Constructor
	 */
	public Cuadrado(int lado) {
		this.lado = lado;
	}

	/**
	 * @return the lado
	 */
	public int getLado() {
		return lado;
	}

	/**
	 * @param lado the lado to set
	 */
	public void setLado(int lado) {
		this.lado = lado;
	}
}
