package colecciones.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Iterator01 {

	public static void main(String[] args) {
		
		// Creamos una lista de nombres
		ArrayList<String> listaNombres= new ArrayList<String>();
		
		// Insertamos 6 nombres distintos en la lista
		listaNombres.add("Ana");
		listaNombres.add("Juan");
		listaNombres.add("Alba");
		listaNombres.add("Pedro");
		listaNombres.add("Susana");
		listaNombres.add("Ernesto");
		
		// Iteramos bublce for
		System.out.println("Listado 1 (for): ");
		for (int i=0; i<listaNombres.size(); i++) {
			System.out.println(listaNombres.get(i));
		}
		
		// Iteramos con bucle while
		System.out.println("\nListado 2 (while): ");
		int i=0;
		while (i<listaNombres.size()) {
			System.out.println(listaNombres.get(i));
			i++;
		}
		
		// Iteramos via bucle Iterator
		System.out.println("\nListado 3 (Iterator): ");
		Iterator<String> listaIterator = listaNombres.iterator();
		while (listaIterator.hasNext()) {
			System.out.println(listaIterator.next());
		}
		
	}

}
