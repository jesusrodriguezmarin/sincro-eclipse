package recuperaciones.examenUt6.repaso;

public class CadenaBorrar {

	// Atributo
	private String cadena;

	// Constructor con parámetro
	public CadenaBorrar(String cadena) {
		this.cadena = cadena;
	}

	// Constructor sin parámetros
	public CadenaBorrar() {
	}
	
	/**
	 * Establece la cadena
	 * @param cadena {String} cadena a establecer
	 */
	public void setCadena(String cadena) {
		this.cadena = cadena;
	}
	
	/**
	 * Devuelve la cadena 
	 * @return {String} la cadena
	 */
	public String getCadena() {
		return this.cadena;
	}
	
	/**
	 * Muestra el contenido en mayúsculas
	 * @return {String} el contenido en mayúsculas
	 */
	public String mayusculas() {
		return this.cadena.toUpperCase();
	}
	
	/**
	 * Muestra el contenido del String en minúsculas
	 * @return {String} en minúsculas
	 */
	public String minusculas() {
		return this.cadena.toLowerCase();
	}
	
	/**
	 * Muestra el contenido del String al revés
	 * @return {String} invertido
	 */
	public String invertido() {
		StringBuffer sb = new StringBuffer(this.cadena);
		sb.reverse();
		return sb.toString();
	}
	
	/**
	 * Muestra la longitud del String
	 * @return {int} la longitud del String
	 */
	public int longitud() {
		return this.cadena.length();
	}
	
	/**
	 * Cuenta las vocales que hay en la cadena
	 * @return {int} el número de vocales que hay en la cadena
	 */
	public int vocales() {
		int conta = 0;
		for (int i = 0; i < this.cadena.length(); i++) {
			char c = this.cadena.toLowerCase().charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				conta++;
			}
		}
		return conta;
	}
	
	/**
	 * Cuenta las consonantes que existen en la cadena
	 * @return {int} el número de consonantes que contien la cadena
	 */
	public int consonantes() {
		int conta = 0;
		for (int i = 0; i < this.cadena.length(); i++) {
			char c = this.cadena.toLowerCase().charAt(i);
			if (Character.isLetter(c) && c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
				conta++;
			}
		}
		return conta;
	}
	
	/**
	 * Cuenta las veces que aparece en la cadena un caracter pasado por parámetro
	 * @param c - caracter a comprobar
	 * @return {int} cantidad de veces que aparece el carácter c
	 */
	public int caracter(char c) {
		int conta = 0;
		for (int i = 0; i < this.cadena.length(); i++) {
			char vmay = this.cadena.toUpperCase().charAt(i);
			char vmin = this.cadena.toLowerCase().charAt(i);
			if (vmay == c || vmin == c) {
				conta++;
			}
		}
		return conta;
	}
	
	/**
	 * Sustituye en la cadena un caracter pasado por parámetro por otro tambien pasado
	 * @param viejo - char a eliminar
	 * @param nuevo - char a implementar
	 */
	public void sustituir(char viejo, char nuevo) {
		this.cadena = this.cadena.replace(viejo, nuevo);
	}
	
	/**
	 * Elimina el caracter introducido por parámetro
	 * @param eliminado - char a eliminar
	 */
	public void eliminar(char eliminado) {
		this.cadena = this.cadena.replace(String.valueOf(eliminado), "");
	}
}
