package ejemplos.libros;

public class LibrosTest {

	public static void main(String[] args) {
		// creamos objetos
		Libros l1 = new Libros("El Quijote", "Cervantes", 800);
		Libros l2 = new Libros("Regreso al futuro", "Steveen", 500);
		Libros l3 = new Libros("El lazarillo", "Anónimo", 600);
		
		// aumentamos el nº de paginas de cada libro en 100 mas
		l1.setNumPaginas(l1.getNumPaginas()+100);
		l2.setNumPaginas(l2.getNumPaginas()+100);
		l3.setNumPaginas(l3.getNumPaginas()+100);
		
		// mostramos por pantalla
		l1.mostarLibro();
		l2.mostarLibro();
		l3.mostarLibro();

	}

}
