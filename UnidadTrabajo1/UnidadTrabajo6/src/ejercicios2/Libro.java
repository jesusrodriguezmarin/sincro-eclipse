package ejercicios2;

public class Libro {

	// Atributos
	private String ISBN;
	private String titulo;
	private String autor;
	private int paginas;
	
	/**
	 * Constructor con parámetros
	 * @param iSBN
	 * @param titulo
	 * @param autor
	 * @param paginas
	 */
	public Libro(String iSBN, String titulo, String autor, int paginas) {
		ISBN = iSBN;
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
	}

	/**
	 * Muestra el ISBN del libro
	 * @return String - ISBN actual
	 */
	public String getISBN() {
		return ISBN;
	}

	/**
	 * Establece el ISBN del libro
	 * @param iSBN String - ISBN a establecer
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	/**
	 * Muestra el título del libro 
	 * @return String - el título actual
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Establece el título del libro
	 * @param titulo String - a establecer
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Muestra el autor del libro
	 * @return String - autor del libro
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Establece el autor del libro
	 * @param autor String - a establecer
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * Muestra la cantidad de páginas del libro
	 * @return int - la cantidad de páginas
	 */
	public int getPaginas() {
		return paginas;
	}

	/**
	 * Establece la cantidad de páginas del libro
	 * @param paginas int - cantidad de páginas a establecer
	 */
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	/**
	 * Muestra la información del libro con todos los datos actuales
	 */
	public String toString() {
		return "El libro "+titulo+" con ISBN "+ISBN+" creado por el autor "+autor+" tiene "+paginas+" páginas";
	}
	
}
