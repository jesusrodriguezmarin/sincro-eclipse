package ejemplos.mac.producto;

import java.io.Serializable;

public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos del producto
	private String nombre;
	private double precio;

	// Constructor
	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	// Método toString para pintar los datos en el Case 2 y Case 5
	@Override
	public String toString() {
		return "Producto [Nombre = " + nombre + ", Precio = " + precio + "€]";
	}
}