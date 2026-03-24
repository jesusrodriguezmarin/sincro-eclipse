package colecciones.lista;

import java.util.ArrayList;

public class ArrayList02 {

	public static void main(String[] args) {
		
		// Creamos una lista de nombres
		ArrayList<Integer> listaNum = new ArrayList<Integer>();

		// Insertamos 6 nombres en una lista
		listaNum.add(1);
		listaNum.add(5);
		listaNum.add(7);
		listaNum.add(1);
		listaNum.add(14);
		listaNum.add(21);
		listaNum.add(13);
		
		
		// .toString
		
		// Mostramos por pantalla la lista de valores
		System.out.println("Lista de elementos que, según sus caracteristias, se pueden duplicar.");
		System.out.println("Lista: "+listaNum.toString());
		
		
		// .remove(int index)
		
		// Eliminamos el valor que ocupa la posición 5 en la lista
		System.out.println("\nEliminamos el valor que ocupa la posición 5 en la lista");
		listaNum.remove(5);
		System.out.println("Lista: "+listaNum.toString());
		
		
		// .remove(obj o)
		// Integer.valueOf
		
		// Eliminamos el valor 5
		System.out.println("\nEliminamos el valor 5 en la lista");
		listaNum.remove(Integer.valueOf(5));
		System.out.println("Lista: "+listaNum.toString());
		
		

	}

}
