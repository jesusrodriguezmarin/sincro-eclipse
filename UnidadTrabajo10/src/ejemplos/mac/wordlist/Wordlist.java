package ejemplos.mac.wordlist;

import java.io.Serializable;

public class Wordlist implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos para el diccionario de traducción
	private String espanol;
	private String traducida;

	// Constructor
	public Wordlist(String espanol, String traducida) {
		this.espanol = espanol;
		this.traducida = traducida;
	}

	// Getters y Setters
	public String getEspanol() {
		return espanol;
	}

	public void setEspanol(String espanol) {
		this.espanol = espanol;
	}

	public String getTraducida() {
		return traducida;
	}

	public void setTraducida(String traducida) {
		this.traducida = traducida;
	}

	// Método toString para pintar los datos en el Case 2 y Case 5
	@Override
	public String toString() {
		return "Diccionario [Español = " + espanol + ", Traducida = " + traducida + "]";
	}
}