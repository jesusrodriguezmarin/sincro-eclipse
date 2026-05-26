package ejemplos.mac.libro;

import java.io.Serializable;

public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos del libro
	private String titulo;
	private String autor;
	private int paginas;

	// Constructor
	public Libro(String titulo, String autor, int paginas) {
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
	}

	// Getters y Setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	// Método toString para pintar los datos en el Case 2 y Case 5
	@Override
	public String toString() {
		return "Libro [Título = " + titulo + ", Autor = " + autor + ", Páginas = " + paginas + "]";
	}
}