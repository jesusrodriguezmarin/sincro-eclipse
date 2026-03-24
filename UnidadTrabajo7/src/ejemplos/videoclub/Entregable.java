package ejemplos.videoclub;

public interface Entregable {

	/**
	 * Devuelve true para el atributo prestado
	 * @return true
	 */
	boolean entregar();
	
	/**
	 * Devuelve false para el atributo presatado
	 * @return false;
	 */
	boolean devolver();
	
	/**
	 * Devuelve el estado del atributo
	 * @return true o false
	 */
	boolean isPrestado();
}
