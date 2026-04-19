package recuperaciones.colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Ej2 {

	public static void main(String[] args) {
		
		// Creamos un conjunto de enteros
		Set<Integer> conjunto = new HashSet<Integer>();
		
		// Pedimos números para introducir en el conjunto hasta introducir 0
		Scanner sc = new Scanner(System.in);
		int numero;
		
		try {
			do {
				System.out.print("Introduce un número para almacenar en el conjunto (0 para finalizar): ");
				numero = sc.nextInt();
				
				if (conjunto.contains(numero)) {
					System.out.println("El número ya se encuentra en el conjunto.");
					System.out.println("No se vuelve a almacenar, prueba con otro.");
				} else if (numero > 0) {
					conjunto.add(numero);
					System.out.println("Número almacenado");
				} else  if (numero < 0){
					System.out.println("No se ha almacenado, es un número negativo.");
				} else {
					System.out.println("Has introducido 0, fin de introducción.");
				}
			} while (numero != 0);
			
			System.out.println("\nTamaño del conjunto: "+conjunto.size());
			System.out.println("Elementos del conjunto: "+conjunto.toString());
			
			Iterator<Integer> i = conjunto.iterator();
			
			System.out.print("\n> Conjunto: ");
			while (i.hasNext()) {
				System.out.print(i.next()+" ");
			}
			
			Iterator<Integer> j = conjunto.iterator();
			
			System.out.print("\n> Elementos pares: ");
			while (j.hasNext()) {
				int valor = j.next();
				if (valor % 2 == 0) {
					System.out.print(valor+" ");
				}
			}
			
			
			
		} catch (Exception e) {
			System.err.println("Error en el tipo de dato");
		} finally {
			sc.close();
		}

	}

}
