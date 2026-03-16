package ejercicios2;

public class LibroTest {

	public static void main(String[] args) {

		// Creamos una instancia de libro
		Libro l1 = new Libro("is1", "La sal", "Angel", 200);

		// Creamos otra instancia de libro
		Libro l2 = new Libro("is2", "El sol", "Jesus", 250);

		// Mostramos
		System.out.println("El libro 1: " + l1.toString());
		System.out.println("El libro 2: " + l2.toString());

		if (l1.getPaginas() > l2.getPaginas()) {
			System.out.println(l1 + " tiene mas páginas");
		} else if (l1.getPaginas() < l2.getPaginas()) {
			System.out.println(l2 + " tiene mas páginas");
		} else {
			System.out.println("Tienen las mismas páginas");
		}
		
		// Cambiamos las paginas
		l2.setPaginas(l2.getPaginas()-50);
		if (l1.getPaginas() > l2.getPaginas()) {
			System.out.println(l1 + " tiene mas páginas");
		} else if (l1.getPaginas() < l2.getPaginas()) {
			System.out.println(l2 + " tiene mas páginas");
		} else {
			System.out.println("Tienen las mismas páginas");
		}
		
	}

}
