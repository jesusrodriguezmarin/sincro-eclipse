package ejemplos.mac.alumno;

import java.io.Serializable;

public class Alumno implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos del alumno
	private String nombre;
	private double nota;

	// Constructor
	public Alumno(String nombre, double nota) {
		this.nombre = nombre;
		this.nota = nota;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	// Método toString para pintar los datos en el Case 2 y Case 5
	@Override
	public String toString() {
		return "Alumno [Nombre = " + nombre + ", Nota = " + nota + "]";
	}
}