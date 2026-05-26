package ejemplos.mac.pieza;

import java.io.Serializable;

public class Pieza implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos de la pieza
	private String nombre;
	private int cantidad;

	// Constructor
	public Pieza(String nombre, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	// Método toString para pintar los datos en el Case 2 y Case 5
	@Override
	public String toString() {
		return "Pieza [Nombre = " + nombre + ", Cantidad = " + cantidad + " unidades]";
	}
}