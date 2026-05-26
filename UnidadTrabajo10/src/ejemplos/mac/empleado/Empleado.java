package ejemplos.mac.empleado;

import java.io.Serializable;

public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos del empleado
	private String nombre;
	private double sueldo;

	// Constructor
	public Empleado(String nombre, double sueldo) {
		this.nombre = nombre;
		this.sueldo = sueldo;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	// Método toString para pintar los datos en el Case 2 y Case 5
	@Override
	public String toString() {
		return "Empleado [Nombre = " + nombre + ", Sueldo = " + sueldo + "€]";
	}
}