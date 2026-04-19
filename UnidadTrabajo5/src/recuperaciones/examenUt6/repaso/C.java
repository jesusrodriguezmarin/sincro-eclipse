package recuperaciones.examenUt6.repaso;

public class C {

	// Atributo
	private String cadena;

	// Constructor con parámetro
	public C(String cadena) {
		this.cadena = cadena;
	}

	// Constructor por defecto
	public C() {
		this.cadena = "";
	}

	/**
	 * Devuelve la cadena de texto
	 * 
	 * @return {String} la cadena de texto
	 */
	public String getCadena() {
		return cadena;
	}

	/**
	 * Establece la cadena de texto
	 * 
	 * @param cadena {String} a establecer
	 */
	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	/**
	 * Procedimiento que crea un Stringbuffer para invertir el String
	 */
	public void reverse() {
		StringBuffer sb = new StringBuffer(this.cadena);
		cadena = sb.reverse().toString();
	}
	
	/**
	 * Función que devuelve un nuevo String con la cadena invertida
	 * @return {String} con la cadena invertida
	 */
	public String invertido() {
		String nuevo = "";
		for (int i = this.cadena.length()-1; i >= 0; i--) {
			nuevo += cadena.charAt(i);
		}
		return nuevo;
	}

	/**
	 * Función que devuelve la cantidad de volcales que contiene una cadena
	 * 
	 * @return {int} cantidad total de vocales
	 */
	public int vocales() {
		int num = 0;
		for (int i = 0; i < this.cadena.length(); i++) {
			char c = this.cadena.toUpperCase().charAt(i);
			if ((Character.isLetter(c)) && (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')) {
				num++;
			}
		}
		return num;
	}

	/**
	 * Procedimiento que crea un StringBuffer y sustutuye vocales por *
	 */
	public void sustituto() {
		StringBuffer s = new StringBuffer(cadena);
		for (int i = 0; i < cadena.length(); i++) {
			char c = this.cadena.toUpperCase().charAt(i);
			if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
				s.replace(i, i + 1, "*");
			}
		}
		this.cadena = s.toString();
	}
	
	/**
	 * Devuelve un nuevo String sustituyendo vocales por *
	 * @return un nuevo String con * 
	 */
	public String sust() {
		StringBuffer nuevo = new StringBuffer(cadena);
		String may = cadena.toUpperCase();
		for (int i = 0; i < cadena.length(); i++) {
			char c = may.charAt(i);
			if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
				nuevo.replace(i, i+1, "*");
			}
		}
		return nuevo.toString();
	}

	/**
	 * Convierte los * a espacios
	 */
	public void espacios() {
		StringBuffer s = new StringBuffer(cadena);
		for (int i = 0; i < cadena.length(); i++) {
			if (s.charAt(i) == '*') {
				s.replace(i, i + 1, " ");
			}
		}
		this.cadena = s.toString();
	}
	
	

	/**
	 * Devuelve la cadena sin espacios
	 */
	public void sin() {
		StringBuffer s = new StringBuffer(cadena);
		for (int i = cadena.length()-1; i >= 0; i--) {
			if (cadena.charAt(i) == ' ') {
				s.replace(i, i+1, "");
			}
		}
		this.cadena = s.toString();
	}

}
