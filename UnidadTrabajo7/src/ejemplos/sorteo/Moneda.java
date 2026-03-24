package ejemplos.sorteo;

public class Moneda extends Sorteo {

	// Constructor
	public Moneda() {
		this.posibilidades= 2;
	}
	
	/**
	 * Devuelve el resultado de lanzar una moneda de manera aleatoria
	 * {String}
	 */
	public String lanzar() {
		int num = (int)(Math.random()*posibilidades+1);
		
		if (num == 1) {
			return "CARA";
		} else {
			return "CRUZ";
		}
	}
}
