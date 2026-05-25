package ejemplos.mac;

import java.io.Serializable;

public class AlumnoObjetoBASE01 implements Serializable {

	/**
	 * Propiedades
	 */
	private String nombre;
	private float nota;
	
	/**
	 * Constructor
	 */
	public AlumnoObjetoBASE01(String nombre, float nota) {
		this.nombre = nombre;
		this.nota = nota;
	}
	
	/**
	 * Devuelve la información sobre el alumno
	 */
	public String toString() {
		return nombre+" - "+nota;
	}

	/**
	 * Devuelve el nombre del alumno
	 * @return - String - nombre del alumno
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve la nota del alumno
	 * @return - float - la nota del alumno
	 */
	public float getNota() {
		return nota;
	}

	/**
	 * Establece la nota del alumno
	 * @param nota - float - la nota del alumno
	 */
	public void setNota(float nota) {
		this.nota = nota;
	}
	
	
}
