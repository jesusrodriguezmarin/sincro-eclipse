package ejemplos.agenda;

import java.io.Serializable;

// Implementamos Serializable para poder guardar el objeto en un archivo binario (.dat)
public class Contacto implements Serializable {
	
	// Atributos de nuestro contacto
	private String nombre;
	private int telefono;
	
	/**
	 * Constructor: Sirve para crear un contacto nuevo pasándole el nombre y el teléfono
	 */
	public Contacto(String nombre, int telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	/**
	 * Getters y Setters: Los métodos necesarios para poder leer y modificar 
	 * los atributos desde otras clases (como tu AgendaPer).
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * toString: Este método sirve para que cuando hagamos un System.out.println(contacto),
	 * en lugar de salir un código raro por pantalla, pinte los datos bonitos.
	 */
	@Override
	public String toString() {
		return nombre + " - " + telefono;
	}
}