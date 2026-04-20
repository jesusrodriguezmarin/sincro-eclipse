package examen;

public class Cadena {

	// Atributo
	private String cadena;

	/**
	 * Constructor con parámetro
	 * @param cadena {string} a establecer
	 */
	public Cadena(String cadena) {
		this.cadena = cadena;
	}

	/**
	 * Constructor por defecto sin parámetros
	 */
	public Cadena() {
		this.cadena = "";
	}

	/**
	 * Devuelve el String cadena
	 * @return {String} la cadena 
	 */
	public String getCadena() {
		return cadena;
	}

	/**
	 * Esteblece el String cadena
	 * @param cadena {String} cadena a establecer
	 */
	public void setCadena(String cadena) {
		this.cadena = cadena;
	}
	
	/**
	 * Devuelve el String en mayusculas
	 * @return {String} cadena en mayusculas
	 */
	public String mayusculas() {
		return this.cadena.toUpperCase();
	}
	
	/**
	 * Devuelve el String en minusculas
	 * @return {String} cadena en minusculas
	 */
	public String minusculas() {
		return this.cadena.toLowerCase();
	}
	
	/**
	 * Función que invierte la cadena
	 * @return {String} - la cadena invertida
	 */
	public String invertir() {
		StringBuffer sb = new StringBuffer(this.cadena);
		sb.reverse();
		return sb.toString();
	}
	
	/**
	 * Función que determina el largo de la cadena
	 * @return {int} el largo de cadena
	 */
	public int longitud() {
		int res = 0;
		res = this.cadena.length();
		return res;
	}
	
	/**
	 * Función que calcula la cantidad de vocales de la cadena
	 * @return {int} la cantidad de vocales 
	 */
	public int vocales() {
		int conta = 0;
		for (int i = 0; i < this.cadena.length(); i++) {
			char c = this.cadena.toUpperCase().charAt(i);
			if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
				conta++;
			}
		}
		return conta;
	}
	
	/**
	 * Función que calcula la cantidad de consonantes de la cadena
	 * @return {int} la cantidad de consonantes 
	 */
	public int consonantes() {
		int conta = 0;
		for (int i = 0; i < this.cadena.length(); i++) {
			char c = this.cadena.toUpperCase().charAt(i);
			if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
				conta++;
			}
		}
		return conta;
	}
	
	/**
	 * Procedimiento que reemplaza un caracter introducido por otro
	 * @param c - char a eliminar
	 * @param cnew - char a almacenar
	 */
	public void reemplazar(char c, char cnew) {
		this.cadena = this.cadena.replace(c, cnew);
	}
	
	/**
	 * Procedimiento que elimina un caracter pasado por parametro
	 * @param c - char a eliminar
	 */
	public void eliminar(char c) {
		StringBuffer s = new StringBuffer(this.cadena);
		for (int i = s.length()-1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				s.delete(i, i+1);
			}
		}
		this.cadena = s.toString();
	}
	
	
	
}
