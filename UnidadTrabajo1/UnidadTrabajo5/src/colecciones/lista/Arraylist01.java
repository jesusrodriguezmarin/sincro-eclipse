package colecciones.lista;

import java.util.ArrayList;

public class Arraylist01 {

	public static void main(String[] args) {
		
		// Creamos una lista de nombres
		ArrayList<String> listaNombres= new ArrayList<String>();
		
		// Insertamos 6 nombres en una lista
		listaNombres.add("Ana");
		listaNombres.add("Juan");
		listaNombres.add("Alba");
		listaNombres.add("Pedro");
		listaNombres.add("Susana");
		listaNombres.add("Ernesto");
		
		// Número de nombres de la lista
		System.out.println("Cantidad de nombres: "+listaNombres.size());
		
		// Eliminamos un nombre de la lista
		String nombre = "Juan";
		
		if (listaNombres.remove(nombre))
			System.out.println("El nombre "+nombre+" ha sido eliminado correctamente");
		else
			System.out.println("No existe el nombre en la lista");
		
		// Comprobamos si existe un nombre en la lista
		nombre ="Sergio";
		if (listaNombres.contains(nombre))
			System.out.println("Si existe el nombre "+nombre+" en la lista");
		else 
			System.out.println("No esxiste el nombre "+nombre+ "en la lista");
	}

}
