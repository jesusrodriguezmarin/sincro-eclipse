package recuperaciones.colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ej3 {

	public static void main(String[] args) {
		
		// Creamos un arrayList para poder repetir String en la lista
		List<String> nombres = new ArrayList<String>();
		
		// Rellenamos la lista con String
		nombres.add("MICHAEL");
		nombres.add("ROBE");
		nombres.add("UHOHO");
		nombres.add("ROSEN");
		
		// Pedimos un nombre por teclado
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un nombre: ");
		String nom = sc.nextLine().toUpperCase();
		sc.close();
		
		// Comprobamos
		if (!nombres.contains(nom)) {
			System.out.println("El nombre no está en la lista de manera única.");
			if (nombres.add(nom))
				System.out.println("Se ha introducido: "+nom+" en la lista.");
		} else {
			System.out.println("El nombre está en la lista.");
			if (nombres.add(nom))
				System.out.println("Se ha introducido otra vez en dif posición.");
		}
		
		Iterator<String> muestra = nombres.iterator();
		while (muestra.hasNext()) {
			System.out.print(muestra.next()+" ");
		}
	}

}
