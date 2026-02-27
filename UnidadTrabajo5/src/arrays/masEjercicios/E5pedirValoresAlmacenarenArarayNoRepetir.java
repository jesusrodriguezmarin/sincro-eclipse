/**
 * Programa pida al usuario cinco valores entre 1 y 10 que se guarden
 * en un array, si alguno de los números generados ya se encuentra en el array
 * no debe guardarlo para que no haya repetidos
 */

package arrays.masEjercicios;

import java.util.Scanner;

public class E5pedirValoresAlmacenarenArarayNoRepetir {
	
	// Constante para el tamaño del array
	final static int TAM=5;
	
	// Constante para el límite de rango en los valores a pedir
	final static int LIM=10;
	
	/**
	 * Función que comprueba si un valor se encuentra ya en un array
	 * @param N - valor a comprobar
	 * @param A - array de números enteros para comprobar con N
	 * @param pos - hasta que posición recorrer para comprobar
	 * @return TRUE si el valor se encuentra en el array
	 * 		FALSE si el valor no se encuentra en el array
	 */
	public static boolean encontrado(int N, int A[], int pos) {
		for (int j=0; j<pos; j++) {
			if (N==A[j])
				return true;
		}
		return false;
	}
	
	/**
	 * Procedimiento que muestra todos los valores de un array
	 * @param A - array de números enteros
	 */
	public static void mostrar(int A[]) {
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	
	// Programa principal
	public static void main(String[] args) {
	
		// Declaramos array
		int A[]= new int[TAM];
		
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Incicamos instrucción al usuario
		System.out.println("Introduce 5 valores comprendidos entre 1 y 10...");
		
		// Control de excepciones
		try {
			// Pedimos valores para el array
			for (int i=0; i<A.length; i++) {
				// Pedimos repetidas veces mientras no sea correcto
				do {
					System.out.print("["+(i+1)+"] Valor: ");
					A[i]=sc.nextInt();
					if ((A[i]>LIM) || (A[i]<1)) {
						System.out.println("El valor introducido no se encuentra entre 1 y "+LIM+". Vuelve a introducirlo");
					} else {
						if (encontrado(A[i], A, i)) {
							System.out.println(">> El valor introducido está repetido. Introduce otro valor.");
						}
					}
					
				} while (encontrado(A[i], A, i) || A[i]>LIM || A[i]<1);
			}
			
		} catch (Exception e) {
			System.err.println(">> ERROR: Tipo de dato no válido");
		} finally {
			sc.close();
		}
		// Mostramos los valores del array
		mostrar(A);
	
	}

}
