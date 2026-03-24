package ejemplos.alumno;

public abstract class Alumno {

	// Constante
	public final int horas_defecto = 30;
	
	// Atributos
	protected String nombre;
	protected int horas_lectivas;
	protected String curso;
	
	/**
	 * Constructor con dos parámetros
	 * @param nombre
	 * @param curso
	 */
	public Alumno(String nombre, String curso) {
		this.nombre = nombre;
		this.horas_lectivas = horas_defecto;
		this.curso = curso;
	}

	/**
	 * Constructor con los tres parámetros
	 * @param nombre
	 * @param horas_lectivas
	 * @param curso
	 */
	public Alumno(String nombre, int horas_lectivas, String curso) {
		this.nombre = nombre;
		this.horas_lectivas = horas_lectivas;
		this.curso = curso;
	}

	/**
	 * Devuelve el nombre del alumno
	 * @return el nombre {String} del alumno
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del alumno
	 * @param nombre {String} el nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve las horas lectivas del alumno
	 * @return the horas_lectivas {int} del alumno
	 */
	public int getHoras_lectivas() {
		return horas_lectivas;
	}

	/**
	 * Establece las horas lectivas
	 * @param horas_lectivas {int} las horas_lectivas a establecer
	 */
	public void setHoras_lectivas(int horas_lectivas) {
		this.horas_lectivas = horas_lectivas;
	}

	/**
	 * Devuelve el curso del alumno
	 * @return el curso {String} del alumno
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * Establece el curso del alumno
	 * @param curso {String} el curso a establecer
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	// Muestra la inforemación del alumnno
	@Override
	public String toString() {
		return "\nLos datos introducidos son: \nAlumno: "+this.nombre+"\nCurso: "+this.curso+" ("+this.horas_lectivas+" horas lectivas)";
	}
	
	public abstract int horasTotales();
}
