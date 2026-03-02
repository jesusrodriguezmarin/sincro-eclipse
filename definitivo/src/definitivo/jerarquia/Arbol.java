package definitivo.jerarquia;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Arbol {

	public static void main(String[] args) {
		
		// Creo un conjunto
		Set<String> conjunto = new LinkedHashSet<String>();
		
		// Le añado palabras
		conjunto.add("Hola");
		conjunto.add("Mundo");
		conjunto.add("puto");
		conjunto.add("!");
		
		Iterator<String> i = conjunto.iterator();
		while (i.hasNext()) {
			System.out.print(i.next()+" ");
		}
		
		String palabra = "puto";
	
		if (conjunto.contains(palabra)) {
			conjunto.remove(palabra);
			System.out.println("\nLa palabra "+palabra+" ha sido eliminada");
		}
		
		Iterator<String> j = conjunto.iterator();
		while (j.hasNext()) {
			System.out.print(j.next()+" ");
		}

	}

}
