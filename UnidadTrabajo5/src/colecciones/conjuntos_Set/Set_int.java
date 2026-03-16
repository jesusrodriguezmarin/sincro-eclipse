package colecciones.conjuntos_Set;

import java.util.HashSet;
import java.util.Set;

public class Set_int {

	public static void main(String[] args) {
		// Creamos un conjunto de números enteros
		Set<Integer> numberSet= new HashSet<Integer>();
		
		// Insertamos 6 elementos en el conjunto
		numberSet.add(1);
		numberSet.add(3);
		numberSet.add(2);
		numberSet.add(1);
		numberSet.add(4);
		numberSet.add(2);

		System.out.println("Conjunto: "+numberSet.toString());
		System.out.println("Tamaño: "+numberSet.size());
		
		if (!numberSet.add(3))
			System.out.println("Error al insertar el 3");
		
		if (numberSet.contains(3))
			System.out.println("El valor 3 ya está en el conjunto");
	}

}
