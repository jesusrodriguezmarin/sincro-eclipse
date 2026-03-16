package arrays.masEjercicios;

import java.util.Scanner;

public class E1comparaUnaFuncion {

	// Constante para el tamaño
	final static int TAM=5;
	
	/**
	 * Función que compara dos arrays y comprueba si sus valores son iguales
	 * Requisito: tener los dos la misma posición
	 * estando en el mismo orden
	 * @param A - array de números enteros
	 * @param B - array de números enteros
	 * @return - TRUE si son iguales y ordenados, FALSE si no lo son
	 */
	public static boolean iguales(int A[], int B[]) {
		for (int i=0; i<A.length; i++) {
			if (A[i]!=B[i])
				return false;
		}
		return true;
	}
	
	/**
	 * Procedimiento que ordena los valores de un array ascendentemente
	 * @param A - array de números enteros
	 */
	public static void bubblesort(int A[]) {
		int aux;
		for (int i=A.length; i>0; i--) {
			for (int j=0; j<i-1; j++) {
				if (A[j]>A[j+1]) {
					aux=A[j+1];
					A[j+1]=A[j];
					A[j]=aux;
				}
			}
		}
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
		
		// Creamos el primer array A
		int A[]= new int[TAM];
		
		// Creamos el segundo array B
		int B[]= new int[TAM];
		
		// Creamos el lector
		Scanner sc = new Scanner(System.in);
		
		// Control de excepciones
		try {
			// Pedimos los valores por teclado
			System.out.println("Introduce valores para dos arrays...");
			for (int i=0; i<TAM; i++) {
				System.out.print("A ["+i+"]: ");
				A[i]=sc.nextInt();
			}
			
			for (int i=0; i<TAM; i++) {
				System.out.print("B ["+i+"]: ");
				B[i]=sc.nextInt();
			}
		} catch (Exception e) {
			System.err.println(">> ERROR: Tipo de datos no válido");
		} finally {
			sc.close();
		}
		
		// Mostrar arrays ordenados
		System.out.println("Elementos de los arrays: ");
		System.out.print("A: ");
		mostrar(A);
		System.out.print("B: ");
		mostrar(B);
		
		
		// Mostramos por pantalla según los elementos comunes entre los arrays
		if (iguales(A,B)) {
			System.out.println("Mismos elementos, mismo orden");
		} else {
			bubblesort(A);
			bubblesort(B);
			if (iguales(A,B)) {
				System.out.println("Mismos elementos, distinto orden");
			} else {
				System.out.println("Diferentes elementos");
			}
		}

	}

}
