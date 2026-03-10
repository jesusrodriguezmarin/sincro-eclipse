package ejercicios2;

public class SuperPassword {

	private final static int LONG = 8;

	// Atributos
	private int longitud;
	private String contraseña;

	/**
	 * Constructor por defecto
	 */
	public SuperPassword() {
		this.longitud = LONG;
		this.contraseña = generarPassword();
	}

	/**
	 * Constructor que recibe un parámetro longitud y genera una contraseña
	 * aleatoria
	 * 
	 * @param longitud
	 */
	public SuperPassword(int longitud) {
		this.longitud = longitud;
		this.contraseña = generarPassword();
	}

	/**
	 * Genera una contraseña aleatoria con la longitud actual definida
	 * 
	 * @return contraseña
	 */
	public String generarPassword() {
		String pass = "";

		// Para el largo establecido por longitud
		for (int i = 0; i < longitud; i++) {

			// Generamos para cada iteracion una eleccion al azar de las 3 disponibles
			int eleccion = (int) (Math.random() * 3 + 1);

			// Filtramos el número generado para que decida un tipo de caracter
			switch (eleccion) {
			case 1: // Añade una mayúscula ('A'..'Z')-(65..90)
				char may = (char) (Math.random() * 26 + 65);
				pass += may;
				break;
			case 2: // Añade una minúscula
				char min = (char) (Math.random() * 26 + 97);
				pass += min;
				break;
			case 3: // Añade un dígito entre 1 y 9
				char num = (char) (Math.random() * 10 + 48);
				pass += num;
				break;
			}
		}
		return pass;
	}

	/**
	 * @return la longitud a mostrar
	 */
	public int getLongitud() {
		return longitud;
	}

	/**
	 * @return la contraseña a mostrar
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * @param longitud a establecer
	 */
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	/**
	 * Comprueba la fortaleza de una contraseña
	 * 
	 * @return true si cumple las condiciones, false si no las cumple
	 */
	public boolean esFuerte() {
		int may = 0;
		int min = 0;
		int num = 0;

		if (contraseña.length() < 8) {
			return false;
		} else {
			// Recorremos caracter a caracter
			for (int i = 0; i < longitud; i++) {
				if (contraseña.charAt(i) >= 'a' && contraseña.charAt(i) <= 'z') {
					min++;
				} else if (contraseña.charAt(i) >= 'A' && contraseña.charAt(i) <= 'Z') {
					may++;
				} else {
					num++;
				}
			}
			if (may >= 2 && min >= 2 && num >= 2)
				return true;
		}

		return false;
	}

}
