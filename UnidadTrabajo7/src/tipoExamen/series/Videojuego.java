package tipoExamen.series;

public class Videojuego implements Entregable {

	// Constante 
	private final static int HORAS_ESTIMADAS_DEF=100;	// Nº de horas estimadas por defecto
	
	// Atributos
	private String titulo;
	private int horasEstimadas;
	private String genero;
	private String desarrollador;
	private boolean presatado;
	
	/**
	 * Constructor por defecto
	 */
	public Videojuego() {
		this("", HORAS_ESTIMADAS_DEF, "", "");
		
	}
	
	/**
	 * Constructor con dos parámetros
	 * @param titulo
	 * @param desarrollador
	 */
	public Videojuego(String titulo, String desarrollador) {
		this(titulo, HORAS_ESTIMADAS_DEF, "", desarrollador);
	}
	
	/**
	 * Constructor con todos los parámetros
	 * @param titulo
	 * @param horasEstimadas
	 * @param genero
	 * @param desarrollador
	 * @param presatado
	 */
	public Videojuego(String titulo, int horasEstimadas, String genero, String desarrollador, boolean presatado) {
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.genero = genero;
		this.desarrollador = desarrollador;
		this.presatado = presatado;
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
