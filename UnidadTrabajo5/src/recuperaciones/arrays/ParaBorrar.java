package recuperaciones.arrays;

import java.util.Scanner;

public class ParaBorrar {

	// Constantes
	final static int TAM = 5;	// Tamaño del array de números enteros
	final static int LIM = 10;	// Limite superior para generar aleatorios
	
	/**
	 * Muestra los elementos contenidos en un array de String
	 * @param a - array de String a mostrar
	 */
	public static void mostrar (String[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println("Posición: "+i+" : "+a[i]);
		}
	}
	
	/**
	 * Muestra los elementos contenidos en un array de enteros
	 * @param a - array de enteros
	 */
	public static void mostrarEnteros (int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println("Posición: "+i+" : "+a[i]);
		}
	}
	
	/**
	 * Devuelve el mayor de los elementos de un array de números enteros
	 * @param a - array de números enteros
	 * @return el mayor de los elementos del array
	 */
	public static int mayor (int[] a) {
		int mayor = a[0];
		
		for (int i = 0; i < a.length; i++) {
			if (mayor < a[i]) {
				mayor = a[i];
			}
		}
		
		return mayor;
	}
	
	/**
	 * Devuelve el menor de los elementos contenidos en un array
	 * @param a - array de números enteros a comprobar
	 * @return {int} el menor de los elementos numéricos del array
	 */
	public static int menor (int[] a) {
		int menor = a[0];
		
		for (int i = 0; i < a.length; i++) {
			if (menor > a[i]) {
				menor = a[i];
			}
		}
		
		return menor;
	}
	
	/**
	 * Devuelve si un número pasado por parámetro se encuentra en el array
	 * Si se encuentra indica cuantas veces está
	 * @param a - array a comprobar
	 * @param n - número a comprobar
	 * @return la cantidad de veces que aparece n o 0 si no aparece
	 */
	public static int contar (int[] a, int n) {
		int conta = 0;
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] == n) {
				conta++;
			}
		}
		return conta;
	}
	
	/**
	 * Ordena de menor a mayor los elementos contenidos en un array de números enteros
	 * @param a - array de números enteros
	 */
	public static void ordenar (int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				int aux;
				if (a[j] > a[j +1]) {
					aux = a[j];
					a[j] = a[j +1];
					a[j +1] = aux;
				}
			}
		}
	}
	
	/**
	 * Devuelve si un String se encuentra entre los elementos de un array de String
	 * @param a - array de String
	 * @param n - String a buscar
	 * @return true si está, false si no está
	 */
	public static boolean encontrar (String[] a, String n) {
		boolean ok = false;
		
		for (int i = 0; i < a.length; i++) {
			if (a[i].equalsIgnoreCase(n)) {
				ok = true;
				break;
			}
		}
		
		return ok;
	}
	
	/**
	 * Devuelve la media resultado de todos los elementos que contiene el array
	 * @param a - array para realizar la media
	 * @return {double} media total
	 */
	public static double media (int[] a) {
		double suma = 0;
		
		for (int i = 0; i < a.length; i++) {
			suma += a[i];
		}
		
		return suma/a.length;
	}
	
	/**
	 * Multiplica todos los elementos del array por un número pasado por parámetro
	 * @param a - array a multiplicar
	 * @param n {int} para multiplixar
	 */
	public static void multiplicar (int[] a, int n) {
		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] * n;
		}
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos un array de números enteros
		int[] numeros = new int[TAM];
		
		// Creamos un array de String
		String[] nombres = {"Paco", "Ana", "Pepa", "Luis"};
		
		// Mostramos el array de enteros asignando un valor en ese momento
		System.out.println("El array de números contiene: ");
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (int)(Math.random()*LIM+1);
			System.out.println("Posición: "+i+" : "+numeros[i]);
		}
		
		// Mostramos el array de String
		System.out.println("\nEl array de String contien: ");
		mostrar(nombres);
		
		// Mostramos el mayor de los elementos del array
		System.out.println("\nEl mayor de los elementos del array es: "+mayor(numeros));
		
		// Mostramos el menor de los elementos del array
		System.out.println("El menor de los elementos del array es: "+menor(numeros));
		
		// Mostramos el número total de elementos
		System.out.println("El número total de elementos del array es: "+numeros.length);
		
		// Mostramos el primer elemento del array
		System.out.println("El primer elemento del array es: "+numeros[0]);
		
		// Mostramos el último elemento del array
		System.out.println("El último elemento del array es: "+numeros[numeros.length-1]);
		
		// Indicamos cuantas veces aparece un número pasado por parámetro en el array
		System.out.print("\nIntroduce un número a buscar: ");
		Scanner sc = new Scanner(System.in);
	
		try {
			int n = Integer.parseInt(sc.nextLine());
			if (contar(numeros, n) > 0) {
				System.out.println("El número introducido: "+n+" se encuentra "+contar(numeros, n)+" veces");
			} else {
				System.out.println("El número introducido: "+n+" no se encuentra en el array.");
			}
			
		} catch (Exception e) {
			System.err.println("Error: Tipo de dato no válido");
		}
	
		
		// Mostramos el array de números enteros ordenado
		System.out.println("\nEl array ordenado es: ");
		ordenar(numeros);
		mostrarEnteros(numeros);
		
		// Mostramos el primer elemento del array de String
		System.out.println("\nEl primer elemento del array es: "+nombres[0]);
		
		// Mostramos el último del String
		System.out.println("El último elemento del array es: "+nombres[nombres.length-1]);
		
		// Comprobamos si un nombre se encuentra en el array de nombres
		System.out.print("\nIntroduce un String para comparar: ");
		String nom = sc.nextLine();
		
		if (encontrar(nombres, nom)) {
			System.out.println("\nEl nombre introducido se encuentra en el array.");
		} else {
			System.out.println("\nEl nombre introducido no se encuentra en el array.");
		}
		
		// Mostramos la media del array
		System.out.println("\nLa media de los elementos del array es: "+media(numeros));
		
		// Pedimos un multiplicador y mostramos el resultado
		System.out.print("\nIntroduce un multiplicador: ");
		int mul = Integer.parseInt(sc.nextLine());
		System.out.println("\nEl array multiplicado por "+mul+" es: ");
		multiplicar(numeros, mul);
		mostrarEnteros(numeros);
		
		sc.close();
	}

}
