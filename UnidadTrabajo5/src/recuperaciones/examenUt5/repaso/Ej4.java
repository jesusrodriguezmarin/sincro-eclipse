package recuperaciones.examenUt5.repaso;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ej4 {

	public static void main(String[] args) {

		// Generamos un conjunto con TreeSet para mantener los datos ordenados
		Set<String> nombres = new TreeSet<String>();
		
		// Solicitamos los nombres por teclado para almacenar en el conjunto
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce un nombre para el conjunto: ");
		String nomteclado = sc.nextLine().toUpperCase();
		
		while (nomteclado.equals("fin") || nomteclado.equals("FIN")) {
			System.out.println("No puedes finalizar aún.");
			System.out.print("Introduce un nombre para el conjunto: ");
			nomteclado = sc.nextLine().toUpperCase();
		}
		
		nombres.add(nomteclado);
		System.out.println("Nombre añadido.");
		
		do {
			System.out.print("Introduce otro nombre para el conjunto: ");
			nomteclado = sc.nextLine().toUpperCase();
			
			if (!nomteclado.equalsIgnoreCase("fin")) {
				if (nombres.add(nomteclado)) {
					System.out.println("Nombre añadido.");
				} else {
					System.out.println("El nombre ya está en la lista.");
				}
			} else {
				System.out.println("Fin de introducción de nombres.");
			}

		} while (!nomteclado.equalsIgnoreCase("fin"));
		
		// Mostramos
		System.out.println("El conjunto de nombres es el siguiente:");
		Iterator<String> i = nombres.iterator();
		while (i.hasNext()) {
			System.out.print(i.next()+" ");
		}
		
		System.out.print("\nIntroduce un nombre a eliminar: ");
		String eliminar = sc.nextLine().toUpperCase();
		
		if (nombres.contains(eliminar)) {
			nombres.remove(eliminar);
			System.out.println("Nombre eliminado.");
		} else {
			do {
				System.out.println("El nombre no se encuentra en la lista.");
				System.out.print("Introduce otro nombre a eliminar: ");
				eliminar = sc.nextLine().toUpperCase();
				
			} while (!nombres.contains(eliminar));
			nombres.remove(eliminar);
			System.out.println("Nombre eliminado.");
		}
		Iterator<String> j = nombres.iterator();
		while (j.hasNext()) {
			System.out.print(j.next()+" ");
		}
		
		sc.close();
				
	}

}
