package ejemplos.mac.proveedor;

import java.io.Serializable;

public class Proveedor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos del proveedor
	private String nombre;
	private String ciudad;

	// Constructor
	public Proveedor(String nombre, String ciudad) {
		this.nombre = nombre;
		this.ciudad = ciudad;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	// Método toString para pintar los datos en el Case 2 y Case 5
	@Override
	public String toString() {
		return "Proveedor [Nombre = " + nombre + ", Ciudad = " + ciudad + "]";
	}
}