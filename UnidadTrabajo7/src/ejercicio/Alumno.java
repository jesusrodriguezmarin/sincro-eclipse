package ejercicio;

public abstract class Alumno {

	// Constante
	public final int TOTAL_HORAS=30;
	
	// Atributos
	private String nombre;
	private int horas;
	private String curso;
	
	/**
	 * Constructor con dos atributos como parámetro
	 * @param nombre
	 * @param horas
	 * @param curso
	 */
	public Alumno(String nombre, String curso) {
		this.nombre = nombre;
		this.horas = TOTAL_HORAS;
		this.curso = curso;
	}

	/**
	 * Constructor con todos los atributos como parámetro
	 * @param nombre
	 * @param horas
	 * @param curso
	 */
	public Alumno(String nombre, int horas, String curso) {
		this.nombre = nombre;
		this.horas = horas;
		this.curso = curso;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * @return the curso
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	/*
	 * Muestra la información sobre Alumno
	 */
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", horas=" + horas + ", curso=" + curso + "]";
	}
	
	// Método abstracto
	public abstract int horasTotales();
	
}
