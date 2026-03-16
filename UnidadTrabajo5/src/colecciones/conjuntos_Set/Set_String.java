package colecciones.conjuntos_Set;

import java.util.HashSet;
import java.util.Set;

public class Set_String {

	public static void main(String[] args) {
		
		// Creamos un conjunto de números pero escritos como una cadena de caracteres
		Set<String> numberSet = new HashSet<String>();

		// Insertamos elementos en el conjunto
		numberSet.add("Uno");
		numberSet.add("Dos");
		numberSet.add("Tres");
		numberSet.add("Uno");
		numberSet.add("Cuatro");
		numberSet.add("Dos");
		
		System.out.println("Conjunto: "+numberSet.toString());
		System.out.println("Tamaño: "+numberSet.size());
		
		if (numberSet.add("Tres"))
			System.out.println("Se ha insertado correctamente");
		else
			System.out.println("Error al insertar");
		
		if (numberSet.contains("Tres"))
			System.out.println("El elemento tres ya está en el conjunto");
	}

}
