package ejercicios;

public class AhorcadoPOO {
	
	// -- CONSTANTES
	public final int TOTAL_INTENTOS = 10;
	
	// -- ATRIBUTOS (Los atributos no se inicializan)
	private int intentos;
	private String acertar;
	private String palabraMostrar;
	private boolean acertada;
	
	// Los atributos se inicializan en el constructor
	// -- CONSTRUCTOR
	
	/** Constructor para inicializar atributos
	 * @param intentos
	 * @param acertar
	 * @param palabraMostrar
	 * @param acertada
	 */
	public AhorcadoPOO() {
		super();
		this.intentos = 0;
		this.acertar = generarPalabraAcertar();
		this.palabraMostrar = generaPalabraMostrar();
		this.acertada = false;
	}
	
	// -- MÉTODOS
	
	/**
	 * Seleccionar de forma aleatoria una palabra del array de palabras
	 * @return
	 */
	private String generarPalabraAcertar() {
		String array[] = {"PIZARRA, DROMEDARIO"};
		return array[(int)(Math.random()*array.length)];
	}
	
	/**
	 * Genera una palabra a mostrar con tantos * como letras tenga la palabra acertar
	 * @return
	 */
	private String generaPalabraMostrar() {
		String palabra = "";
		for (int i=0; i<acertar.length(); i++) {
			palabra += "*";
		}
		return palabra;
	}
	
	/**
	 * Devuelve el número de intentos que lleva el usuario
	 * @return the intentos
	 */
	public int getIntentos() {
		return intentos;
	}
	/**
	 * Devuelve la palabra que el usuaro debe acertar
	 * @return the acertar
	 */
	public String getAcertar() {
		return acertar;
	}
	/**
	 * Devuelve la palabra que se le muestra al usuario
	 * @return the palabraMostrar
	 */
	public String getPalabraMostrar() {
		return palabraMostrar;
	}
	/**
	 * True si el usuario ha acertado la palabra o false si no la ha acertado
	 * @return the acertada
	 */
	public boolean isAcertada() {
		return acertada;
	}
	
	/**
	 * Devuelve el número de letras que tiene la palabra acertar
	 * @return el número de letras int
	 */
	public int getNumLetrasPalabra() {
		return acertar.length();
	}
	
	/**
	 * Intenta acertar una letra de la palabra a adivinar
	 * @param letra a comprobar
	 * @return true si la letra está contenida en la palabra a acertar
	 * false si la letra no está contenida en la palabra a acertar
	 */
	public boolean intentar(char letra) {
		intentos++;
		if (acertar.indexOf(letra)!= -1) {
			for (int i=0; i<acertar.length(); i++) {
				if (acertar.charAt(i)==letra) {
					palabraMostrar = palabraMostrar.substring(0, i)+letra+palabraMostrar.substring(i+1, i);
				}
			}
			
			if (acertar.equals(palabraMostrar))
				acertada = true;
			return true;
			
		}
		return false;
	}
	
	public boolean resolver(String palabra) {
		return false;
	}

}
