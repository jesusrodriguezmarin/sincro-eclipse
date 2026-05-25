package ejemplos.alumno;

import java.io.Serializable;

public class Alumno implements Serializable {
	
	/**
	 * Propiedades
	 */
	private String nombre;	// Nombre del alumno
	private float nota;		// Nota media del alumno
	
	/**
	 * Constructor
	 * @param nombre 
	 * @param nota
	 */
	public Alumno(String nombre, float nota) {
		this.nombre = nombre;
		this.nota = nota;
	}

	/**
	 * Devuelve la información sobre el alumno
	 */
	@Override
	public String toString() {
		return nombre + " - " + nota;
	}

	/**
	 * Devuelve el nombre del alumno/a
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve la nota del alumno
	 * @return la nota
	 */
	public float getNota() {
		return nota;
	}

	/**
	 * Establece la nota del alumno
	 * @param nota la nota a establecer
	 */
	public void setNota(float nota) {
		this.nota = nota;
	}
	
	

}
