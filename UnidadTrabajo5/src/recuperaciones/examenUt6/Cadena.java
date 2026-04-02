package recuperaciones.examenUt6;

public class Cadena {
	private String cadena;

	/**
	 * Constructor por defecto sin parametros
	 */
	public Cadena() {
		cadena = "";
	}

	/**
	 * Constructor
	 * 
	 * @param s - El valor que va a recibir la cadena
	 */
	public Cadena(String s) {
		cadena = s;
	}

	/**
	 * @return el cadena
	 */
	public String getCadena() {
		return cadena;
	}

	/**
	 * Establece el valor de s para cadena
	 * 
	 * @param cadena el cadena a establecer
	 */
	public void setCadena(String s) {
		cadena = s;
	}

	/**
	 * Metodo que devuelve la cadena con todos sus caracteres en mayusculas
	 * 
	 * @return - STRING la cadena en mayusculas
	 */
	public String mayusculas() {
		return cadena.toUpperCase();

	}

	/**
	 * Metodo que devuelve la cadena con todos sus caracteres en minuscula
	 * 
	 * @return STRING la cadena en minusculas
	 */
	public String minusculas() {
		return cadena.toLowerCase();

	}

	/*
	 * Metodo que devuelve la cadena invertida
	 */
	public String invertir() {
		String cad = "";
		for (int i = cadena.length() - 1; i >= 0; i--) {
			cad += cadena.charAt(i);
		}
		return cad;
	}

	/**
	 * Metodo que nos devuelve la longitud de la cadena
	 * 
	 * @return - INT El número de caracteres que contiene
	 */
	public int longitud() {
		return cadena.length();
	}

	/**
	 * Metodo que cuenta las vocales de una cadena
	 * 
	 * @return
	 */
	public int contarVocales() {
		String cad = cadena.toUpperCase();
		int conta = 0;
		for (int i = 0; i < cadena.length(); i++) {
			if (cad.charAt(i) == 'A' || cad.charAt(i) == 'E' || cad.charAt(i) == 'I' || cad.charAt(i) == 'O'
					|| cad.charAt(i) == 'U') {
				conta++;
			}
		}
		return conta;
	}

	/**
	 * Metodo que cuenta las consonantes de una cadena
	 * 
	 * @return INT El numero de consonantes
	 */
	public int contarConsonantes() {
		String cad = cadena.toUpperCase();
		int conta = 0;
		for (int i = 0; i < cadena.length(); i++) {
			if (cad.charAt(i) != 'A' && cad.charAt(i) != 'E' && cad.charAt(i) != 'I' && cad.charAt(i) != 'O'
					&& cad.charAt(i) != 'U') {
				conta++;
			}
		}
		return conta;
	}

	/**
	 * Funcion que cuenta el numero de ocurrencias del caracter c en cadena
	 * 
	 * @param c - letra a contar
	 * @return INT El numero de apariciones que tiene esa letra en la cadena
	 */
	public int contarLetra(char c) {
		int conta = 0;
		for (int i = 0; i < cadena.length(); i++) {
			if (cadena.charAt(i) == c) {
				conta++;
			}
		}
		return conta;
	}

	/**
	 * Metodo que reemplaza un caracter
	 * 
	 * @param c    - caracter a reemplazar
	 * @param newc - caracter a por el que reemplazamos
	 */
	public void reemplazar(char c, char newc) {
		for (int i = 0; i < cadena.length(); i++) {
			if (cadena.charAt(i) == c) {
				c = newc;
			}
		}
	}

	/**
	 * Metodo que elimina el caracter que pasamos como parametro
	 * 
	 * @param c - caracter a eliminar
	 */
	public void eliminar(char c) {
		cadena.toUpperCase();
		StringBuffer cad = new StringBuffer(cadena);
		for (int i = 0; i < cadena.length(); i++) {
			if (cadena.charAt(i) == c) {
				cad.deleteCharAt(i);
			}
		}
	}

}
