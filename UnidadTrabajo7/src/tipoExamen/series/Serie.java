package tipoExamen.series;

public class Serie implements Entregable {

	// Constantes
	private final static int NUM_TEMPORADAS_DEF = 3;	// Nº de temporadas por defecto
	
	// Atributos
	private String titulo;		// Título de la serie
	private int numTemporadas;	// Nº temporadas de la serie
	private String genero;		// Género de la serie
	private String creador;		// Nombre del creador de la serie
	private boolean prestado;	// Indica si está entregada la serie
	
	/**
	 * Constructor con todos los parámetros
	 * @param titulo
	 * @param numTemporadas
	 * @param genero
	 * @param creador
	 */
	public Serie(String titulo, int numTemporadas, String genero, String creador) {
		this.titulo=titulo;
		this.numTemporadas=numTemporadas;
		this.genero=genero;
		this.creador= creador;
		this.prestado= false;
	}
	
	/**
	 * Constructor con dos parámetros
	 * @param titulo
	 * @param creador
	 */
	public Serie(String titulo, String creador) {
		this(titulo, NUM_TEMPORADAS_DEF, "", creador);
	}
	
	/**
	 * Constructor por defecto
	 */
	public Serie() {
		this("", NUM_TEMPORADAS_DEF, "", "");
	}

	@Override
	public void entregar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void devolver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isPrestado() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
