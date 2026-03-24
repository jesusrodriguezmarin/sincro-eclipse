package examen;

public class Cadena {

	// Atributo
	private String cadena;

	/**
	 * Constructor por defecto
	 */
	public Cadena() {
		this.cadena = "";
	}

	/**
	 * Constructor con parámetro
	 * @param cadena
	 */
	public Cadena(String cadena) {
		this.cadena = cadena;
	}

	/**
	 * @return la cadena
	 */
	public String getCadena() {
		return cadena;
	}

	/**
	 * @param cadena la cadena a estblecer
	 */
	public void setCadena(String cadena) {
		this.cadena = cadena;
	}
	
	/**
	 * 
	 * @return String - cadena en mayúsculas
	 */
	public String mayusculas() {
		return cadena.toUpperCase();
	}
	
	/**
	 * 
	 * @return String - cadena en minúsculas
	 */
	public String minusculas() {
		return cadena.toLowerCase();
	}
	
	/**
	 * 
	 * @return String - cadena invertida
	 */
	public String ivertir() {
		StringBuffer s = new StringBuffer(cadena);
		s.reverse();
		return s.toString();
	}
	
	/**
	 * 
	 * @return int - longitud de la cadena
	 */
	public int longitud() {
		return cadena.length();
	}
	
	/**
	 * 
	 * @return int - número de vocales
	 */
	public int contarVocales() {
		int n = 0;
		for (int i=0; i<cadena.length(); i++) {
			if (cadena.charAt(i)=='a' || cadena.charAt(i)=='e' || cadena.charAt(i)=='i' || cadena.charAt(i)=='o' || cadena.charAt(i)=='u' ||cadena.charAt(i)=='A' || cadena.charAt(i)=='E' || cadena.charAt(i)=='I' || cadena.charAt(i)=='O' || cadena.charAt(i)=='U') {
				n++;
			}
		}
		return n;
	}
	
	/**
	 * 
	 * @return int - número de consonantes
	 */
	public int contarConsonantes() {
		int n = 0;
		for (int i=0; i<cadena.length(); i++) {
			if (cadena.charAt(i)!='a' && cadena.charAt(i)!='e' && cadena.charAt(i)!='i' && cadena.charAt(i)!='o' && cadena.charAt(i)!='u' && cadena.charAt(i)!='A' && cadena.charAt(i)!='E' && cadena.charAt(i)!='I' && cadena.charAt(i)!='O' && cadena.charAt(i)!='U') {
				n++;
			}
		}
		return n;
	}
	
	/**
	 * 
	 * @param c - char - a comprobar
	 * @return - int - númerp de caracteres pasados por parámetro
	 */
	public int contarLetra(char c) {
		int n = 0;
		for (int i=0; i<cadena.length(); i++) {
			if (cadena.charAt(i)== c)
				n++;
		}
		return n;
	}
	
	/**
	 * Reemplaza en la cadena un caracter indicado en el parámetro por otro indicado en el parámetro
	 * @param c - char a reemplazar
	 * @param newc - char nuevo
	 */
	public void reemplazar(char c, char newc) {
		for (int i=0; i<cadena.length(); i++) {
			if (cadena.charAt(i)==c) {
				cadena = cadena.replace(c, newc);
			}
		}
	}
	
	/**
	 * Elimina de la cadena el caracter pasado por parámetro
	 * @param c - char - a eliminar
	 */
	public void eliminar(char c) {
		StringBuffer s = new StringBuffer(cadena);
		for (int i=0; i<cadena.length(); i++) {
			if (s.charAt(i)==c) {
				s = s.deleteCharAt(i);
			}
		}
	}
	
}
