package colecciones.iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Iterator02 {

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
			
			// Creamos el Iterator
			Iterator<Integer> i = numberSet.iterator();
			System.out.print("> Conjunto: ");
			// .hasNext trae el elemento actual y coge el siguiente
			while (i.hasNext()) {
				System.out.print(i.next()+" ");
			}
			
			// Mostramos solo los pares
			Iterator<Integer> j = numberSet.iterator();
			int valor;
			System.out.print("\n> Pares: ");
			while (j.hasNext()) {
				// Guardamos next en valor para utilizarlo para operar
				valor = j.next();
				if(valor%2==0)
				System.out.print(valor+" ");
			}
		} catch (Exception e) {
			System.err.println(">> ERROR. El tipo de dato no es válido");
			System.out.println("> La ejecución del programa finalizará");
		} finally {
			sc.close();
		}

	}

}
