package colecciones.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Maps02 {

	public static void main(String[] args) {

		// Creamos un Map
		Map<Integer, String> ciudades = new HashMap<Integer, String>();

		// Insertamos elementos
		ciudades.put(30500, "MOLINA DE SEGURA");
		ciudades.put(30560, "ALGUAZAS");
		ciudades.put(30565, "LAS TORRES");
		ciudades.put(30600, "ARCHENA");
		ciudades.put(30820, "ALCANTARILLA");

		// Pedimos la introducción por teclado de un código postal
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Introduce un código postal: ");
			int codpostal = Integer.parseInt(sc.nextLine().trim());

			if (ciudades.containsKey(codpostal)) {
				System.out.println("> La ciudad con código postal " + codpostal + " es: " + ciudades.get(codpostal));
			} else {
				System.out.println("> La ciudad con código postal " + codpostal + " no existe en nuesto diccionario.");
			}
		} catch (Exception e) {
			System.err.println("> Error en la introducción de datos.");
		}

		// Pedimos la introducción por teclado del nombre de la ciudad
		System.out.print("\nIntroduce el nombre de un pueblo: ");
		String nombre = sc.nextLine().toUpperCase();
		sc.close();

		if (ciudades.containsValue(nombre)) {
			System.out.println("> La ciudad " + nombre + " SI se encuentra en nuestro diccionario");
		} else {
			System.out.println("> La ciudad " + nombre + " NO se encuentra en nuestro diccionario");
		}

		// Mostramos todas las ciudades
		System.out.println("\n> Ciudades: ");
		System.out.println(" CP\tNombre \n-----\t------------------");

		// a) Obtenemos el conjunto de entradas/diccionario del map (clave-valor)
		Set<Map.Entry<Integer, String>> conjunto = ciudades.entrySet();

		// b) Creamos el Iterator (iterador)
		Iterator<Map.Entry<Integer, String>> i = conjunto.iterator();

		// c) Recorremos el Iterator con while
		while (i.hasNext()) {
			Map.Entry<Integer, String> m = i.next();
			System.out.println(m.getKey() + "\t" + m.getValue());
		}

	}

}
