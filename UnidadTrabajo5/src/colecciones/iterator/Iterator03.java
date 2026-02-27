package colecciones.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Iterator03 {

	/**
	 * Muestra por pantalla los elementos almacenados en una lista de enteros
	 * @param l - array de enteros
	 */
	private static void printList(ArrayList<Integer> l) {
		Iterator<Integer> i = l.iterator();
		while(i.hasNext()) {
			System.out.print(i.next()+" ");
		}
	}
	
	// Programa principal
	public static void main(String[] args) {

		// Creamos una lista de números enteros
		ArrayList<Integer> lista = new ArrayList<Integer>();

		// Creamos lector
		Scanner sc = new Scanner(System.in);

		// Pedimos números enteros hasta que meta el 0
		// Almacenamos los valores en la lista
		try {
			System.out.println("Introduce números enteros (0 para terminar)");
			int num;

			System.out.print("Dime el primer número: ");
			num = sc.nextInt();
			while (num != 0) {
				lista.add(num);
				System.out.print("Dime otro número: ");
				num = sc.nextInt();
			}

			/*
			 * Otra opcion, perdir con do-while do { System.out.print("Dime un número: ");
			 * num=sc.nextInt(); lista.add(num); } while(num!=0);
			 */

			// Mostramos el tamaño de la lista y los elementos almacenados
			System.out.println("\n> Número/cantidad de valores introducidos: " + lista.size());
			System.out.println("\n> lista: " + lista);
			
			System.out.print("\n> lista: ");
			printList(lista);

			lista.sort(null);
			System.out.print("\n> lista ordenada: ");
			printList(lista);

		} catch (Exception e) {
			System.err.println(">> ERROR. Tipo de datos no válido!");
		} finally {
			sc.close();
		}

	}

}
