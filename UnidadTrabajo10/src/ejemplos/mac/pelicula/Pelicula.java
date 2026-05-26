package ejemplos.mac.pelicula;

import java.io.Serializable;

public class Pelicula implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos de la película
	private String titulo;
	private int anio;

	// Constructor
	public Pelicula(String titulo, int anio) {
		this.titulo = titulo;
		this.anio = anio;
	}

	// Getters y Setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	// Método toString para pintar los datos en el Case 2 y Case 5
	@Override
	public String toString() {
		return "Película [Título = " + titulo + ", Año = " + anio + "]";
	}
}