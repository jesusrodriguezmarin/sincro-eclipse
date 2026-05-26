package ejemplos.mac.agenda;

import java.io.Serializable;

// Implementamos Serializable para poder guardar el objeto en un archivo binario (.dat)
public class Contacto implements Serializable {
	
	// Atributos de nuestro contacto
	private String nombre;
	private int telefono;
	
	/**
	 * Constructor: creamos un contacto nuevo pasándole el nombre y el teléfono
	 */
	public Contacto(String nombre, int telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	/**
	 * Devuelve el nombre del contacto
	 * @return - String - nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del contacto
	 * @param nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el teléfono del contacto
	 * @return - int - teléfono del contacto
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * Establece el teléfono del contacto
	 * @param telefono a establecer
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * Muestra el nombre y teléfono del contacto
	 */
	@Override
	public String toString() {
		return nombre + " - " + telefono;
	}
}