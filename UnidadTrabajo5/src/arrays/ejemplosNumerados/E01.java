package arrays.ejemplosNumerados;

import java.util.Scanner;

public class E01 {

	// Declaramos e inicializamos constante para asignar el tamaño del array
	final static int TAM = 4;
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Creamos array
		int[] A = new int[TAM];
		
		// Control de excepciones
		try {
			// Pedimos los valores por teclado para almacenar en el array
			System.out.println("Introduce "+TAM+" valores enteros.");
			for (int i=0; i<A.length; i++) {
				System.out.print("Introduce un valor, posición en el array["+i+"], posición pedida ["+(i+1)+"]: ");
				A[i] = sc.nextInt();
			}
			
		} catch (Exception e) {
			System.err.println(">> ERROR");
		} finally {
			sc.close();
		}

		// Mostramos por pantalla en el orden introducido
		System.out.print("Los valores del array en orden de introducción: ");
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
		// Mostramos por pantalla en el orden inverso al introducido
		System.out.print("\nLos valores del array en orden inverso de introducción: ");
		for (int i=A.length-1; i>=0; i--) {
			System.out.print(A[i]+" ");
		}
	}

}
