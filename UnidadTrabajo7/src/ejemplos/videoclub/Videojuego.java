package ejemplos.videoclub;

public class Videojuego implements Entregable {

	// Constantes
	private static final int HORAS_DEF = 100;
	private static final boolean PREST_DEF = false;
	private static final String TITULOV_DEF = "";
	private static final String GENEROV_DEF = "";
	private static final String DESARROLLADOR_DEF = "";

	// Atributos
	private String tituloV;
	private int horas;
	private String generoV;
	private String desarrollador;
	private boolean prest;
	
	/**
	 * Constructor por defecto
	 */
	public Videojuego() {
		this.tituloV = TITULOV_DEF;
		this.horas = HORAS_DEF;
		this.generoV = GENEROV_DEF;
		this.desarrollador = DESARROLLADOR_DEF;
		this.prest = PREST_DEF;
	}
	
	/**
	 * Constructor con 2 parámetros
	 * @param tituloV
	 * @param desarrollador
	 */
	public Videojuego(String tituloV, String desarrollador) {
		this.tituloV = tituloV;
		this.desarrollador = desarrollador;
	}
	
	/**
	 * Constructor con los 5 parámetros
	 * @param tituloV
	 * @param horas
	 * @param generoV
	 * @param desarrollador
	 * @param prest
	 */
	public Videojuego(String tituloV, int horas, String generoV, String desarrollador, boolean prest) {
		this.tituloV = tituloV;
		this.horas = horas;
		this.generoV = generoV;
		this.desarrollador = desarrollador;
		this.prest = prest;
	}

	/**
	 * @return the tituloV
	 */
	public String getTituloV() {
		return tituloV;
	}

	/**
	 * @param tituloV the tituloV to set
	 */
	public void setTituloV(String tituloV) {
		this.tituloV = tituloV;
	}

	/**
	 * @return the horas
	 */
	public int getHoras() {
		return horas;
	}

	/**
	 * @param horas the horas to set
	 */
	public void setHoras(int horas) {
		this.horas = horas;
	}

	/**
	 * @return the generoV
	 */
	public String getGeneroV() {
		return generoV;
	}

	/**
	 * @param generoV the generoV to set
	 */
	public void setGeneroV(String generoV) {
		this.generoV = generoV;
	}

	/**
	 * @return the desarrollador
	 */
	public String getDesarrollador() {
		return desarrollador;
	}

	/**
	 * @param desarrollador the desarrollador to set
	 */
	public void setDesarrollador(String desarrollador) {
		this.desarrollador = desarrollador;
	}

	/**
	 * Devuelve la información del videojuego
	 */
	@Override
	public String toString() {
		if (this.tituloV.equals(""))
			return "Videojuego sin información registrada";
		return "Videojuego [tituloV=" + tituloV + ", horas=" + horas + ", generoV=" + generoV + ", desarrollador="
				+ desarrollador + ", prest=" + prest + "]";
	}

	@Override
	public boolean entregar() {
		this.prest=true;
		return this.prest;
	}

	@Override
	public boolean devolver() {
		this.prest = false;
		return this.prest;
	}

	@Override
	public boolean isPrestado() {
		return this.prest;
	}

	
}
