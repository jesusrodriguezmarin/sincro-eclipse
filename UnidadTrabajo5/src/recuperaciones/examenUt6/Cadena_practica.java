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
		// Asigna cadena del parámetro al atributo this.cadena porque es void, establece
		this.cadena=cadena;
	}
	
	/**
	 * Devuelve la cadena
	 * @return {String} cadena
	 */
	public String getCadena() {
		// Devuelve el atributo cadena poeque no es void, muestra, no modifica
		return cadena;
	}

	/**
	 * Devuelve la candena en mayúsculas
	 * @return {String} la cadena en mayúsculas
	 */
	public String mayus() {
		// Devuelve el atributo porque no es void, muestra, no modifica
		return cadena.toUpperCase();
	}
	
	/**
	 * Devuelve la cadena en minúsculas
	 * @return {String} la cadena en minúsculas
	 */
	public String minus() {
		// Devuelve el atributo porque no es void, muestra, no modifica
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
		// Devuelve el String declarado porque no es void, muestra, no modifica
		return cad;
	}
		
	/**
	 * Devuelve la longitud de la cadena
	 * @return {int} longitud de la cadena
	 */
	public int longi() {
		// Devuelve el atributo porque no es void, muestra, no modifica
		return this.cadena.length();
	}
		
	/**
	 * Devuelve el número de vocales de la cadena
	 * @return {int} número de vocales de la cadena
	 */
	public int voc() {
		int conta = 0;
		String temp = this.cadena.toLowerCase();
		for (int i=0; i<this.cadena.length(); i++) {
			char l = temp.charAt(i);
			if (l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u') {
				conta++;
			}
		}
		// Devuelve el int declarado porque no es void, muestra, no modifica el atributo
		return conta;
	}
	
	/**
	 * Devuelve el número de consonantes de la cadena
	 * @return {int} el número de consonantes del la cadena
	 */
	public int cons() {
		int conta = 0;
		String temp = cadena.toLowerCase();
		
		for (int i=0; i<temp.length(); i++) {
			char c = temp.charAt(i);
			if (Character.isLetter(c) && (c != 'a' && c != 'e' && c != 'i' 
					&& c != 'o' && c != 'u')) {
				conta++;
			}
		}
		// Devuelve un String declarado porque no es void, muestra, no modifica el atributo
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
		// Devuelve el int declarado porque no es void, muestra otra variable, no modifica el atributo
		return conta;
	}
	
	/**
	 * Reemplaza el caracter introducido a por el caracter introducido b
	 * @param a - caracter a quitar
	 * @param b - caracter a establecer
	 */
	public void reemp(char a, char b) {
		char aM = Character.toUpperCase(a);
		char am = Character.toLowerCase(a);
		
		char bM = Character.toUpperCase(b);
		char bm = Character.toLowerCase(b);
		
		// Establece el atributo modificado porque es un void
		this.cadena = cadena.replace(am, bm);
		this.cadena = cadena.replace(aM, bM);
	}
	
	/**
	 * Elimina todas las apariciones del caracter pasado por parametro
	 * @param c - caracter a eliminar
	 */
	public void borra(char c) {
		StringBuffer cad = new StringBuffer(this.cadena);
		
		for (int i=cad.length()-1; i>=0; i--) {
			char cadm = Character.toUpperCase(cad.charAt(i));
			char cm = Character.toUpperCase(c);
			if (cadm == cm) {
				cad.deleteCharAt(i);
			}
		}
		// Establece el atributo modificado porque es void
		this.cadena = cad.toString();
	}
}
