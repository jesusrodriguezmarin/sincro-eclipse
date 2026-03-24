package ejercicio;

public abstract class Alumno {

	// Constante
	public final double NOTA_DEF=7.50;
	
	// Atributos
	protected String nombre;
	protected double nota;
	protected String titulo;
	
	/**
	 * Constructor con dos atributos como parámetro
	 * @param nombre
	 * @param horas
	 * @param curso
	 */
	public Alumno(String nombre, String titulo) {
		this.nombre = nombre;
		this.nota = NOTA_DEF;
		this.titulo = titulo;
	}

	/**
	 * Constructor con todos los atributos como parámetro
	 * @param nombre
	 * @param horas
	 * @param curso
	 */
	public Alumno(String nombre, double nota , String titulo) {
		this.nombre = nombre;
		this.nota = nota;
		this.titulo = titulo;
	}

	/**
	 * Devuelve el nombre del alumno
	 * @return the nombre {String} del alumno
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del alumno
	 * @param nombre {Sting} the nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve la nota del alumno
	 * @return la nota {double} las nota del alumno
	 */
	public double getHoras() {
		return nota;
	}

	/**
	 * Establece la nota del alumno
	 * @param nota {double} a establecer
	 */
	public void setHoras(double nota) {
		this.nota = nota;
	}

	/**
	 * Devuelve el titulo del alumno
	 * @return the titulo {String} del alumno
	 */
	public String getCurso() {
		return titulo;
	}

	/**
	 * Establece el titulo del alumno
	 * @param el titulo {String} a establecer
	 */
	public void setCurso(String titulo) {
		this.titulo = titulo;
	}

	/*
	 * Muestra la información sobre Alumno
	 */
	@Override
	public String toString() {
		return "Alumno: "+this.nombre+"\nCurso: "+this.titulo+" ("+this.nota+" nota media)";
	}
	
	// Método abstracto
	public abstract double notaFinal();
	
}
