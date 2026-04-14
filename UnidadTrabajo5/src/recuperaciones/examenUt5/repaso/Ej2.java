package recuperaciones.examenUt5.repaso;

import java.util.Scanner;

public class Ej2 {

	// Constantes 
	final static int TAM = 8;	// Para el tamaño del array
	final static int LIM = 10;	// Para el límite superior de aleatorios
	
	/**
	 * Función que genera un número aleatorio
	 * @param L - Límite superior de los números a generar
	 * @return {int} un número generado
	 */
	public static int aleatorio(int L) {
		return (int)(Math.random()*L+1);
	}
	
	/**
	 * Procedimiento que muestra todos los elementos de un array de enteros
	 * @param a - array de números enteros
	 */
	public static void mostrar(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	/**
	 * Función que comprueba si un número pasado por parámetro se encuentra en el array
	 * @param a - array a comprobar
	 * @param n - número a comprobar
	 * @return true si se encuentra, false si no se encuentra
	 */
	public static boolean encontrado(int[] a, int n) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == n) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Programa principal
	 * @param args
	 */
	public static void main(String[] args) {

		// Creamos un array y rellenamos con aleatorios
		int[] a = new int[TAM];
		
		// Almacenamos valores aleatorios en el array
		for (int i = 0; i < a.length; i++) {
			a[i] = aleatorio(LIM);
		}
		
		// Mostramos el array generado
		System.out.print("Array: ");
		mostrar(a);
		
		// Solicitamos un número al usuario para sustituir
		Scanner sc = new Scanner(System.in);
		try {
			
			System.out.print("\nElige un número del array para sustituir: ");
			int viejo = sc.nextInt();
			int conta = 0;
			
			// Comprobamos si está en el array
			if (!encontrado(a, viejo)) {
				System.out.println("El número: "+viejo+" no se encuentra en el array.");
				System.out.println("Fin del programa.");
			} else {
				System.out.println("El número se encuentra en el array");
				System.out.print("Introduce otro número para reemplazarlo: ");
				int nuevo = sc.nextInt();
				
				// Reemplazamos números
				conta = 0;
				for (int i = 0; i < a.length; i++) {
					if (a[i] == viejo) {
						a[i] = nuevo;
						conta++;
					}
				}
				System.out.println("Se han realizado: "+conta+" cambios");
				System.out.print("El array resultante es: ");
				mostrar(a);
			}
			
			
		} catch (Exception e) {
			System.err.println("Error. Tipo de dato no válido.");
		} finally {
			sc.close();
		}
	}

}
