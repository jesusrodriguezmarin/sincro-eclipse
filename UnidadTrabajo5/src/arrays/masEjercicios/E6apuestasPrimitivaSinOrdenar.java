/**
 * Apuestas primitiva: Escribe un programa que pida los seis números de una apuesta
 * de la loteria primitiva (números enteros entre 1 y 49) y los almacene en un array.
 * 
 * En otro array almacenará los 6 números ganadores (números enteros entre 1 y 49 
 * generados de forma aleatoria, sin duplicados).
 * 
 * El programa mostrará por pantalla el número de aciertos
 */

package arrays.masEjercicios;

import java.util.Scanner;

public class E6apuestasPrimitivaSinOrdenar {
	
	// Declaramos constante global para el tamaño de los arrays
	final static int TAM=6;
	
	// Declaramos constante para el límite para generar los aleatorios y pedir a usuario
	final static int LIM=49;
	
	/**
	 * Función que genera un número entero aleatorio entre 1 y N
	 * @param N - Límite superior para generar el número
	 * @return el número aleatorio generado
	 */
	public static int aleatorio(int N) {
		int num = (int)(Math.random()*N+1);
		return num;
	}
	
	/**
	 * Función que determina si un valor se encuentra ya entre los elementos de un array
	 * @param N - el valor a comparar con los elementos del array
	 * @param A - el array de números enteros para comparar
	 * @param pos - posición del array hasta la que buscar
	 * @return TRUE si el valor comparado ya se encuentra en el array
	 * 		FALSE si el valor comparado no se encuentra
	 */
	public static boolean encontrado(int N, int A[], int pos) {
		for (int j=0; j<pos; j++) {
			if (N==A[j]) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Función que muestra todos los elementos de un array
	 * @param A - array de números enteros
	 */
	public static void mostrar(int A[]) {
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i]+"  ");
		}
		System.out.println();
	}
	
	/**
	 * Función que devuelve el número de elementos repetidos entre dos arrays
	 * @param A - primer array de números enteros
	 * @param B - segundo array de números enteros
	 * @return - número de coincidencias entre elementos
	 */
	public static int compara(int A[], int B[]) {
		int conta=0;	// Contador de coincidencias
		for (int i=0; i<A.length; i++) {
			for (int j=0; j<B.length; j++) {
				if (A[i]==B[j])
					conta++;
			}
		}
		return conta;
	}
	
	/**
	 * Procedimiento que ordena de los valores de un array de menor a mayor
	 * @param A - array de números enteros
	 */
	public static void bubblesort(int A[]) {
		int burbuja;
		for (int i=A.length-1; i>=0; i--) {
			for (int j=0; j<i; j++) {
				if (A[j]>A[j+1]) {
					burbuja=A[j];
					A[j]=A[j+1];
					A[j+1]=burbuja;	
				}
			}
		}
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Declaramos array A para generar aleatorios (ganadores)
		int A[]= new int[TAM];
		
		// Generamos los valores
		int num;	// variable para guardar temporal 
		
		for (int i=0; i<A.length; i++) {
			do {
				num=aleatorio(LIM);
				// Llamamos a la función de repetidos (encontrado) para evitar repeticiones
			} while (encontrado(num, A, i));
			
			// Si num llega aquí no está repetido y lo guardamos en la iteración del array
			A[i]=num;
		}
		
		// Declaramos array B para pedir valores (apuesta)
		int B[]= new int[TAM];
		
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		
		// Control de excepciones
		try {
			// Mensaje para el usuario
			System.out.println("Haga su apuesta para la lotería. Elige 6 números:");
			for (int i=0; i<B.length; i++) {
				do {
					System.out.print("["+(i+1)+"] Número: ");
					B[i]=sc.nextInt();
					if (encontrado(B[i], B, i)) {
						System.out.println("Mejor no repetir número. Introduce un valor diferente");
					}
					if (B[i]>LIM || B[i]<1) {
						// Informamos que el número introducido está fuera de rango
						System.out.println(">> El número elegido no es válido. Debe estar entre 1 y "+LIM);
					}
				} while (encontrado(B[i], B, i) || B[i]>LIM || B[i]<1);
			}
		} catch (Exception e) {
			System.err.println(">> ERROR: Tipo de dato no válido");
		} finally {
			sc.close();
		}
		// Ordenamos ambos arrays para mostrar
		bubblesort(A);
		bubblesort(B);
		
		// Mostramos los elementos apostados
		System.out.print("\nNúmeros apostados: ");
		mostrar(B);
		// Mostramos los ganadores
		System.out.print("\nNúmeros ganadores: ");
		mostrar(A);
		
		// Mostramos el número de aciertos
		System.out.print("\nNº de aciertos: "+compara(A,B));
		
	}

}

