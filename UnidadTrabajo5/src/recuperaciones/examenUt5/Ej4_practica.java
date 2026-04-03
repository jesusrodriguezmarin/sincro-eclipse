package recuperaciones.examenUt5;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ej4_practica {

	public static void main(String[] args) {

		// Creamos un conjunto TreeSet que se crea ordenado y no permite duplicados
		Set<String> conjunto = new TreeSet<String>();

		// Pedimos nombres de persona por teclado al usuario
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un nombre: ");
		String nombre = sc.nextLine().toUpperCase();

		// Añadinos el nombre al conjunto
		while (nombre.equals("FIN")) {
			System.out.println("Error. Introduce al menos un nombre.");
			System.out.print("Introduce un nombre: ");
			nombre = sc.nextLine().toUpperCase();
		}
			
		conjunto.add(nombre.toUpperCase());
		System.out.println("Nombre guardado en la colección");

		// Condición para no repetir nombre
		while (!nombre.equals("FIN")) {
			System.out.print("Introduce otro nombre: ");
			nombre = sc.nextLine().toUpperCase();

			// Si ya existe no se guarda y si es fin finaliza
			if (conjunto.contains(nombre.toUpperCase())) {
				System.out.println("> El nombre " + nombre + " ya está en la lista");
			} else {
				if (nombre.equals("FIN")) {
					System.out.println("Fin de la lista");
				} else {
					conjunto.add(nombre);
					System.out.println("Nombre guardado en la colección");
				}
			}

		}

		// Mostramos la lista de nombres
		Iterator<String> i = conjunto.iterator();
		System.out.println("\nLa lista ordenada: ");

		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}

		// Solicitamos un nombre para eliminar de la lista
		System.out.print("\nIntroduce un nombre de la lista a eliminar: ");
		String eliminar = sc.nextLine().toUpperCase();
		
		while (!conjunto.contains(eliminar)) {
			System.out.println(eliminar+" no está en la lista");
			System.out.print("Prueba con otro: ");
			eliminar = sc.nextLine().toUpperCase();
		}
		
		if (conjunto.contains(eliminar)) {
			conjunto.remove(eliminar);
			System.out.println(eliminar+" ha sido eliminado.");
		}
		
		
		Iterator<String> j = conjunto.iterator();
		System.out.println("Conjunto acutal ordenado: ");
		
		while (j.hasNext()) {
			System.out.print(j.next()+" ");
		}
		sc.close();

	}

}
