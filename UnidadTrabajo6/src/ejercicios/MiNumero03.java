package ejercicios;

public class MiNumero03 {

	// Atributo
	int dato;

	/**
	 * Constructor
	 * @param dato
	 */
	public MiNumero03(int dato) {
		this.dato = dato;
	}
	
	/**
	 * Calcula el doble del dato
	 * @return el doble del dato
	 */
	public int doble() {
		return dato*2;
	}
	
	/**
	 * Calcula el triple del dato
	 * @return el triple del dato
	 */
	public int triple() {
		return doble()+dato;
	}
	
	/**
	 * Calcula el cuadruple del dato
	 * @return el cuadruple del dato
	 */
	public int cuadruple() {
		return triple()+dato;
	}
}
