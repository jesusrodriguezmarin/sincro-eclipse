package ejemplos.boletin;

import java.io.Serializable;

public class Pelicula implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos de la película
	private String titulo;
	private int anio;
	private String director;

	/**
	 * Constructor con parámetros
	 * @param titulo de la película
	 * @param anio de la película
	 * @param director de la película
	 */
	public Pelicula(String titulo, int anio, String director) {
		this.titulo = titulo;
		this.anio = anio;
		this.director = director;
	}

	/**
	 * Devuelve el título de la película
	 * @return el titulo - String
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Establece el título de la película
	 * @param titulo el titulo de la película a establecer
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Devuelve el año de la película
	 * @return el anio - int
	 */
	public int getAnio() {
		return anio;
	}

	/**
	 * Establece el año de la película
	 * @param anio el anio a establecer
	 */
	public void setAnio(int anio) {
		this.anio = anio;
	}

	/**
	 * Devuelve el director de la película
	 * @return el director - String
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * Establece el director de la película
	 * @param director el director a establecer 
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "Pelicula: '" + titulo + "', Año: " + anio + ", Director: " + director;
	}

	
}