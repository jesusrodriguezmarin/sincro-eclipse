package examen;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ej4 {

	public static void main(String[] args) {

		// Cramos un conjunto
		Set<String> nombres = new TreeSet<String>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce nombres simples: ('FIN' para terminar)...");
		System.out.print("Primer nombre: ");
		String nombre = sc.nextLine().trim();
		nombres.add(nombre);
		
		 while (!nombre.equalsIgnoreCase("FIN")) {
			 System.out.print("Otro nombre: ");
			 nombre = sc.nextLine();
			 if (!nombre.equals("FIN")) {
				 if (nombres.add(nombre)) {
				 } else {
					 System.out.println("> Ya has introducido ese nombre. Introduce uno nuevo.");
				 }
				 
			 }
		 }
		 
		 Iterator<String> i = nombres.iterator();
		 System.out.print("\n> Lista de nombres ordenada: ");
		 while (i.hasNext()) {
			 System.out.print(i.next()+" ");
		 }
		
		 System.out.print("\n\nDime un nombre de la lista: ");
		 nombre = sc.nextLine();
		 
		 // Eliminamos
		 if (nombres.remove(nombre)) {
			 System.out.println("\n> Eliminamos a "+nombre+" de la lista");
			 Iterator<String> j = nombres.iterator();
			 System.out.print("\n> Lista de nombres ordenada: ");
			 while (j.hasNext()) {
				 System.out.print(j.next()+" ");
			 }
		 } else {
			 System.out.println("\n> "+nombre+" no se encuentra en la lista de nombres");
		 }
		
		sc.close();
	}

}
