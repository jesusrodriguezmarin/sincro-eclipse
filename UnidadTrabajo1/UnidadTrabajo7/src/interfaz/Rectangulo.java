package interfaz;

public class Rectangulo implements Figura {
	
	/* Atributos */
	private int ancho;
	private int alto;
	
	/**
	 * Constructor
	 * @param ancho
	 * @param alto
	 */
	Rectangulo(int ancho, int alto){
		this.ancho=ancho;
		this.alto=alto;
	}

	/**
	 * Calcula el area de un rectangulo
	 * @return el area de un ratangulo
	 */
	public int area() {
		// TODO Auto-generated method stub
		return ancho*alto;
	}
	
	
}
