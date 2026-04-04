package recuperaciones.arrays;

public class ArraysDesdeCero {

	// Constantes
	final static int TAM = 5; // Para el tamaño del array
	final static int LIM = 10; // Para el límite de generación aleatoria

	public static void main(String[] args) {

		// Creamos un array de números enteros determinando las posiciones
		int[] enteros = new int[TAM];

		// Creamos un array de String rellenandolo en la declaración
		String[] nombres = { "Pepe", "Lola", "Juan", "Ana" };

		// Mostramos el array de enteros y rellenamos en cada iteración
		System.out.println("El array de números enteros es: ");
		for (int i = 0; i < enteros.length; i++) {
			System.out.println("Posición predeterminada: " + i + " : " + enteros[i]);
			enteros[i] = (int) (Math.random() * LIM + 1);
			System.out.println("Posición asignada: " + i + " : " + enteros[i]);
		}

		// Mostramos el array de nombres
		System.out.println("\nEl array de nombres es: ");
		for (int i = 0; i < nombres.length; i++) {
			System.out.println("Posición: " + i + " : " + nombres[i]);
		}

		// Buscamos el mayor de los elementos de un array de enteros
		int mayor = enteros[0];
		int menor = enteros[0];
		for (int i = 0; i < enteros.length; i++) {
			if (enteros[i] > mayor) {
				mayor = enteros[i];
			}
			if (enteros[i] < menor) {
				menor = enteros[i];
			}
		}
		System.out.println("\n> El número de elementos del array es: " + enteros.length);
		System.out.println("> El mayor de los elementos del array es: " + mayor);
		System.out.println("> El menor de los elementos del array es: " + menor);
		System.out.println("> El primer elemento del array es: " + enteros[0]);
		System.out.println("> El último elemento del array es: " + enteros[enteros.length - 1]);

		// Buscamos un número en un array
		boolean ok = false;
		int conta = 0;
		int buscar = 5;
		for (int i = 0; i < enteros.length; i++) {
			if (enteros[i] == buscar) {
				conta++;
				ok = true;

			}
		}
		if (ok) {
			System.out.println("> El elemento: " + buscar + " se encuentra " + conta + " veces.");
		} else {
			System.out.println("> El elemento: " + buscar + " no se encuentra en el array.");
		}

		// Ordenamos el array de menor a mayor
		for (int i = 0; i < enteros.length - 1; i++) {
			for (int j = 0; j < enteros.length - 1 - i; j++) {

				if (enteros[j] > enteros[j + 1]) {
					int aux = enteros[j];
					enteros[j] = enteros[j+1];
					enteros[j+1] = aux;
				}
			}
		}
		
		System.out.println("> El array ordenado de menor a mayor es: ");
		for (int i = 0; i < enteros.length; i++) {
			System.out.print(enteros[i] + " ");
		}
	}

}
