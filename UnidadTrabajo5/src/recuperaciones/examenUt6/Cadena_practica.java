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
	 * Devuelve la candena en mayúsculas
	 * @return {String} la cadena en mayúsculas
	 */
	public String mayus() {
		return cadena.toUpperCase();
	}
	
	/**
	 * Devuelve la cadena en minúsculas
	 * @return {String} la cadena en minúsculas
	 */
	public String minus() {
		return cadena.toLowerCase();
	}
	
	/**
	 * Devuelve la cadena invertida
	 * @return {String} la cadena invertida
	 */
	public String reverso() {
		String cad = "";
		for (int i=cadena.length()-1; i>=0; i--) {
			cad += cadena.charAt(i);
		}
		return cad;
	}
		
	/**
	 * Devuelve la longitud de la cadena
	 * @return {int} longitud de la cadena
	 */
	public int longi() {
		return this.cadena.length();
	}
		
	/**
	 * Devuelve el número de vocales de la cadena
	 * @return {int} número de vocales de la cadena
	 */
	public int voc() {
		int conta = 0;
		for (int i=0; i<this.cadena.length(); i++) {
			char l = this.cadena.charAt(i);
			if (l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u') {
				conta++;
			}
		}
		return conta;
	}
	
	/**
	 * Devuelve el número de consonantes de la cadena
	 * @return {int} el número de consonantes del la cadena
	 */
	public int cons() {
		int conta = 0;
		for (int i=0; i<this.cadena.length(); i++) {
			char c = this.cadena.charAt(i);
			if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
				conta++;
			}
		}
		return conta;
	}
	
	/**
	 * Devuelve el número de veces que aparece el caracter c en la cadena
	 * @param c - caracter a comparar
	 * @return {int} núnero de apariciones
	 */
	public int carac(char c) {
		int conta = 0;
		for (int i=0; i<this.cadena.length(); i++) {
			char l = this.cadena.charAt(i);
			c = Character.toUpperCase(c);
			l = Character.toUpperCase(l);
			if (l == c) {
				conta++;
			}
		}
		return conta;
	}
	
	/**
	 * Reemplaza el caracter introducido a por el caracter introducido b
	 * @param a - caracter a quitar
	 * @param b - caracter a establecer
	 */
	public void reemp(char a, char b) {
		a = Character.toUpperCase(a);
		b = Character.toUpperCase(b);
		this.cadena = cadena.replace(a, b);
	}
	
	/**
	 * Elimina todas las apariciones del caracter pasado por parametro
	 * @param c - caracter a eliminar
	 */
	public void borra(char c) {
		this.cadena = cadena.replace(c, ' ');
	}
}
