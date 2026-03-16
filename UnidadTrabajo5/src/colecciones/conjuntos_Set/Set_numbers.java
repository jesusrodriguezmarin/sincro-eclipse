package colecciones.conjuntos_Set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Set_numbers {

	public static void main(String[] args) {
		// Creamos un conjunto de números enteros
		Set<Integer> numberSet = new HashSet<Integer>();

		// Leemos por teclado números enteros positivos
		// hasta que el usuario introduzca el 0 (cero)
		// y los almacenamos en el conjunto

		Scanner sc = new Scanner(System.in);

		try {
			// Pedimos números al usuario
			System.out.println("Introduce números enteros para un conjunto (0 para terminar)");
			System.out.print("Primer número: ");
			int num = sc.nextInt();
			while (num!=0) {
				// Si es menor que 0 mostramos
				if (num<0)
					System.out.println(num+" es un número entero negativo");
				// Si ya está mostramos
				else if (numberSet.contains(num))
					System.out.println(num+" ya se encuentra en el conjunto");
				// Sino, añadimos al conjunto
				else
					numberSet.add(num);
				// Leemos el siguiente número
				System.out.print("Otro número: ");
				num=sc.nextInt();
			}
			// Mostramos tamaño del conjunto y elementos almacenados
			System.out.println("\nTamaño del conjunto: "+numberSet.size());
			System.out.println("> Conjunto: "+numberSet.toString());

		} catch (Exception e) {
			System.err.println(">> ERROR. El tipo de dato no es válido");
			System.out.println("> La ejecución del programa finalizará");
		} finally {
			sc.close();
		}

	}

}
