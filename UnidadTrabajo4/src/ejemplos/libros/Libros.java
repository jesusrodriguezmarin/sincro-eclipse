package ejemplos.libros;

public class Libros {

	private String titulo;		// titulo del libro
	private String autor;		// nombre del autor del libro
	private int numPaginas;		// número total de paginas


	/**
	 * @param titulo
	 * @param autor
	 * @param numPaginas
	 */
	public Libros(String titulo, String autor, int numPaginas) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.numPaginas = numPaginas;
	}

	// GETTERS
	
	/**
	 * 
	 * @return el titulo del libro
	 */
	public String getTitulo() {
		return titulo;
	}


	/**
	 * 
	 * @return el autor del libro
	 */
	public String getAutor() {
		return autor;
	}


	/**
	 * 
	 * @return el nº de paginas del libro
	 */
	public int getNumPaginas() {
		return numPaginas;
	}

	// SETTERS
	
	/**
	 * Establece el titulo del libro
	 * @param titulo a establecer para el libro
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Establece el autor del libro
	 * @param autor a establecer para el libro
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * Establece el nº de paginas
	 * @param numPaginas a establecer para el libro
	 */
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	
	// mostramos el libro
	public void mostarLibro() {
		System.out.println("Título: "+titulo);
		System.out.println("Autor: "+autor+" - Nº páginas: "+numPaginas+"\n");
	}
	
}
