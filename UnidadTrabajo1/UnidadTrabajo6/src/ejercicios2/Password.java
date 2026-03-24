package ejercicios2;

public class Password {

	// Atributos
	private String contraseña;
	private int longitud;
	
	/**
	 * Constructor con un parámetro String para la contraseña
	 * @param contraseña - String
	 */
	public Password(String contraseña) {
		this.contraseña = contraseña;
		this.longitud = contraseña.length();
	}
	
	/**
	 * Muestra la contraseña actual
	 * @return String - la contraseña actual
	 */
	public String getContraseña() {
		return contraseña;
	}
	
	/**
	 * Establece la contraseña pasada por parámetro
	 * @param contraseña String - para establecer
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	/**
	 * Muestra la longitud actual de la contraseña
	 * @return int - longitud de la contraseña
	 */
	public int getLongitud() {
		return longitud;
	}
	
	/**
	 * Establece la longitud de la cotraseña pasada por parámetro
	 * @param longitud int - a establecer
	 */
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	
	/**
	 * Determina si una contraseña es fuerte
	 * Es fuerte si tiene mas de 8 caracteres
	 * @return True si es cumple la característica, False si no la cumple
	 */
	public boolean esFuerte() {
		return contraseña.length()>8;
	}
	
	/**
	 * Cambia la contraseña actual String por una nuesva String
	 * Solo realiza el cambio si la nueva es diferente a la anterior
	 * @param nueva - String - nueva cadena a establecer como contraseña
	 */
	public void cambiar(String nueva) {
		if (!nueva.equals(contraseña)) {
			contraseña = nueva;
			longitud = nueva.length();
		} else {
			System.out.println("ERROR: Es igual a la anterior");
		}
	}

	
}
