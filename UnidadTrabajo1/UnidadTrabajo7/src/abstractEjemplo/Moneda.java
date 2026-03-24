package abstractEjemplo;

public class Moneda extends Sorteo {
	
	/**
	 * Constructor
	 */
	Moneda(){
		posibilidades=2;
	}
	
	/**
	 * Devuelve el resultado de lanzar la moneda
	 */
	public String lanzar() {
		int num = (int)(Math.random()*posibilidades);
		if (num == 1) {
			return "Cara";
		} else {
			return "Cruz";
		}
	}
}
