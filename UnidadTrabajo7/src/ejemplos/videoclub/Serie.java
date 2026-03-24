package ejemplos.videoclub;

public class Serie implements Entregable {

	// Constantes
	public static final int NUMTEMPORADAS_DEF = 3;
	public static final boolean PRESTADO_DEF = false;
	public static final String TITULO_DEF = "";
	public static final String GENERO_DEF = "";
	public static final String CREADOR_DEF = "";

	
	// Atributos
	private String titulo;
	private	int numTemporadas;
	private String genero;
	private String creador;
	private boolean prestado;
	
	/**
	 * Constructor por defecto
	 */
	public Serie() {
		this.titulo = TITULO_DEF;
		this.numTemporadas = NUMTEMPORADAS_DEF;
		this.genero = GENERO_DEF;
		this.creador = CREADOR_DEF;
		this.prestado = PRESTADO_DEF;
	}
	
	/**
	 * Constructor con los 2 parámetros
	 * @param titulo de la serie
	 * @param creador de la serie
	 */
	public Serie(String titulo, String creador) {
		this.titulo = titulo;
		this.creador = creador;
	}
	
	/**
	 * Constructor con los 5 parámetros
	 * @param titulo de la serie
	 * @param numTemporadas de la serie
	 * @param genero de la serie
	 * @param creador de la serie
	 * @param prestado - estado de la serie
	 */
	public Serie(String titulo, int numTemporadas, String genero, String creador, boolean prestado) {
		this.titulo = titulo;
		this.numTemporadas = numTemporadas;
		this.genero = genero;
		this.creador = creador;
		this.prestado = prestado;
	}

	/**
	 * Devuelve el titulo de la serie
	 * @return {STring} titulo de la serie
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Devuelve el numero de temporadas de la serie
	 * @return {int} numTemporadas de la serie
	 */
	public int getNumTemporadas() {
		return numTemporadas;
	}

	/**
	 * Devuelve el género de la serie
	 * @return {String} genero de la serie
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Devuelve el creador de la serie
	 * @return {String} creador de la serie
	 */
	public String getCreador() {
		return creador;
	}

	/**
	 * Establece el titulo de la serie
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Establece el numero de temporadas de la serie
	 * @param numTemporadas the numTemporadas to set
	 */
	public void setNumTemporadas(int numTemporadas) {
		this.numTemporadas = numTemporadas;
	}

	/**
	 * Establece el género de la serie
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Establece el creador de la serie
	 * @param creador the creador to set
	 */
	public void setCreador(String creador) {
		this.creador = creador;
	}

	/**
	 * Muestra la información de la serie
	 */
	@Override
	public String toString() {
		return "Serie [titulo=" + titulo + ", numTemporadas=" + numTemporadas + ", genero=" + genero + ", creador="
				+ creador + ", prestado=" + prestado + "]";
	}

	@Override
	public boolean entregar() {
		this.prestado=true;
		return this.prestado;
	}

	@Override
	public boolean devolver() {
		this.prestado = false;
		return this.prestado;
	}

	@Override
	public boolean isPrestado() {
		return this.prestado;
	}
	
	
	
}
