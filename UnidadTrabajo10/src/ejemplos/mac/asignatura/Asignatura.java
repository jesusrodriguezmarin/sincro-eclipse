package ejemplos.mac.asignatura;

import java.io.Serializable;

public class Asignatura implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos de la asignatura
	private String nombre;
	private int horas;

	// Constructor
	public Asignatura(String nombre, int horas) {
		this.nombre = nombre;
		this.horas = horas;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	// Método toString para pintar los datos en el Case 2 y Case 5
	@Override
	public String toString() {
		return "Asignatura [Nombre = " + nombre + ", Horas = " + horas + "]";
	}
}