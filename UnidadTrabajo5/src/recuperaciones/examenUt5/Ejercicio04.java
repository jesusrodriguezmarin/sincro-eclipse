package recuperaciones.examenUt5;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ejercicio04 {

	public static void main(String[] args) {
		// Creamos un conjunto
		Set<String> conjunto = new TreeSet<String>();
		String nombre = "";
		String salida = "FIN";
		// Creamos un scanner para introducir los nombres.
		Scanner tcl = new Scanner(System.in);
		System.out.println("Introduce nombres simples('FIN' para terminar)...");
		System.out.print("Primer nombre: ");
		nombre = tcl.nextLine();
		conjunto.add(nombre);
		while (!nombre.equals(salida)) {
			System.out.print("Otro nombre: ");
			nombre = tcl.nextLine();
			if (nombre.equals(salida)) {
			} else if (conjunto.contains(nombre)) {
				System.out.println("> Ya has introducido ese nombre. Introduce uno nuevo.");
			} else {
				conjunto.add(nombre);
			}
		}

		Iterator<String> i = conjunto.iterator();
		System.out.print("\n> Lista de nombres ordenada: ");
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}

		// Pedimos un nombre de la lista y lo eliminamos
		System.out.print("\n\nDime un nombre de la lista: ");
		nombre = tcl.nextLine();
		
		if (conjunto.contains(nombre)) {
			conjunto.remove(nombre);
			System.out.print("\n> Eliminamos " + nombre + " de la lista");
			
			Iterator<String> j = conjunto.iterator();
			System.out.print("\n\n> Lista de nombres: ");
			while (j.hasNext()) {
				System.out.print(j.next() + " ");
			}

		} else {
			System.out.println("\n> " + nombre + " no se encuentra en la lista de nombres");
		}
		tcl.close();

	}

}
