package ejemplos.alumno;

public class Doctorado extends Alumno {

	// Constante
	public final int horas_defecto_tesis = 10;
	
	// Atributos
	protected int horas_tesis;
	protected String nombre_tesis;

	/**
	 * @param nombre
	 * @param horas_lectivas
	 * @param curso
	 */
	public Doctorado(String nombre, int horas_lectivas, String curso, int horas_tesis, String nombre_tesis) {
		super(nombre, horas_lectivas, curso);
		this.horas_tesis = horas_tesis;
		this.nombre_tesis = nombre_tesis;
	}

	/**
	 * Devuelve las horas de la tesis
	 * @return the horas_tesis {int}
	 */
	public int getHoras_tesis() {
		return horas_tesis;
	}

	/**
	 * Establece las horas de la tesis
	 * @param horas_tesis the horas_tesis a establecer
	 */
	public void setHoras_tesis(int horas_tesis) {
		this.horas_tesis = horas_tesis;
	}

	/**
	 * Devuelve el nombre de la tesis
	 * @return the nombre_tesis {String} a establecer
	 */
	public String getNombre_tesis() {
		return nombre_tesis;
	}

	/**
	 * Establece el nombre de la tesis
	 * @param nombre_tesis the nombre_tesis {String} a establecer
	 */
	public void setNombre_tesis(String nombre_tesis) {
		this.nombre_tesis = nombre_tesis;
	}
	
	// Muestra la información del alumno y su doctorado
	@Override
	public String toString() {
		return super.toString()+"\nTesis doctoral: "+this.nombre_tesis+"("+this.horas_tesis+" horas semanales)\nHoras totales: "+this.horasTotales();
	}

	// Calcula las horas totales del doctorado + la tesis
	@Override
	public int horasTotales() {
		// TODO Auto-generated method stub
		return this.horas_lectivas + this.horas_tesis;
	}
	
}
