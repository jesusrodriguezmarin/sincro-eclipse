package recuperaciones.colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ej4 {

	// Constante para el límite
	final static int LIM = 50;

	/**
	 * Función que devuelve un número entero aleatorio
	 * 
	 * @param N - límite superior de los números a generar
	 * @return {int} número aleatorio generado
	 */
	public static int aleatorio(int N) {
		return (int) (Math.random() * N + 1);
	}

	public static void main(String[] args) {

		// Creamos una instancia de arrayList
		List<Integer> numeros = new ArrayList<Integer>();

		// Almacenamos valores aleatorios
		numeros.add(aleatorio(LIM));
		numeros.add(aleatorio(LIM));
		numeros.add(aleatorio(LIM));
		numeros.add(aleatorio(LIM));
		numeros.add(aleatorio(LIM));
		numeros.add(aleatorio(LIM));

		// Mostramos lista inicial
		System.out.print("Lista actual:");
		System.out.println(numeros.size());
		Iterator<Integer> i = numeros.iterator();
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}

		// Introducimos otro número para poder eliminarlo sabiendo que está
		numeros.add(50);

		// Mostramos lista actual
		System.out.print("\n\nLista actual: ");
		System.out.println(numeros.size());
		Iterator<Integer> j = numeros.iterator();
		while (j.hasNext()) {
			System.out.print(j.next() + " ");
		}

		// Eliminamos el elemento de la posición 3
		numeros.remove(3);

		// Eliminamos el elemento 50
		numeros.remove(Integer.valueOf(50));
		
		// Mostramos lista actual
		System.out.print("\n\nLista actual: ");
		System.out.println(numeros.size());
		Iterator<Integer> v = numeros.iterator();
		while (v.hasNext()) {
			System.out.print(v.next() + " ");
		}

	}

}
