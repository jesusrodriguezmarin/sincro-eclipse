package recuperaciones.colecciones;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ej1 {

	public static void main(String[] args) {
		
		// Creamos un cojunto de números enteros
		Set<Integer> conjunto = new HashSet<Integer>();
		
		// Añadimos 6 números 
		conjunto.add(1);
		conjunto.add(3);
		conjunto.add(4);
		conjunto.add(2);
		
		System.out.println("El tamaño del conjunto es: "+conjunto.size());
		System.out.println("Conjunto: "+conjunto.toString());
		
		if (!conjunto.add(1)) {
			System.out.println("\nEl: "+1+" ya se encuentra en el conjunto.");
			System.out.println("No se puede volver a meter");
		}
		if (conjunto.add(5)) {
			System.out.println("El: "+5+" se ha introducido en el conjunto.");
		}
		
		System.out.println("\nAhora el conjunto es:\n"+conjunto.toString());
		
		// Creamos un conjunto de String
		Set<String> conjuntoString = new TreeSet<String>();
		
		// Añadimos elementos String al conjunto
		conjuntoString.add("Cuatro");
		conjuntoString.add("Uno");
		conjuntoString.add("Tres");
		conjuntoString.add("Dos");
		
		System.out.println("\nEl conjuntoString tiene "+conjuntoString.size()+" elementos.");
		System.out.println("Los elementos son: "+conjuntoString.toString());
		
		if (conjuntoString.add("Cinco")) {
			System.out.println("Has añadido el Cinco.");
		} else {
			System.out.println("Cinco ya se encuentra en el conjunto.");
		}
		
		if (!conjuntoString.add("Uno")) {
			System.out.println("Uno ya se encuentra en el conjunto.");
		}
	}

}
