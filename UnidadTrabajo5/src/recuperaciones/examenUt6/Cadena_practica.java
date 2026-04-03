package recuperaciones.examenUt6;

public class Cadena_practica {

	// Atributo
	private String cadena;
	
	/**
	 * Constructor pro defecto sin parámetros
	 */
	public Cadena_practica() {
		this.cadena = "";
	}

	/**
	 * Constructor con parámetro
	 * @param cadena {String}
	 */
	public Cadena_practica(String cadena) {
		this.cadena = cadena;
	}
	
	/**
	 * Establece la cadena para cadena
	 * @param cadena {String} a establecer
	 */
	public void setCadena(String cadena) {
		this.cadena=cadena;
	}
	
	/**
	 * Devuelve la cadena
	 * @return {String} cadena
	 */
	public String getCadena() {
		return cadena;
	}

	/**
	 * 
	 */
	public void mayusculas() {
		this.cadena=cadena.toUpperCase();
	}
	
}
