package arrays.ejercicios;

import java.util.Scanner;

public class E9leer5desplazarDerechaNposiciones {

	final static int TAM=5;
	
	public static void mostrar(int A[]) {
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
	}
	public static void main(String[] args) {
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Creamos array
		int A[]= new int[TAM];
		
		// Variable números a desplazar
		int N = 0;
		int ultimo;
		
		// Control
		try {
			// Pedimos números
			for (int i=0; i<A.length; i++) {
				System.out.print("Introduce un número: ");
				A[i]=sc.nextInt();
			}
			
			System.out.print("Posiciones a desplazar: ");
			N = sc.nextInt();
		} catch (Exception e) {
			System.err.println("ERROR");
		} finally {
			sc.close();
		}

		// Bucle para repetir las veces que queremos desplazar de 1 a N
		for (int i=1; i<=N; i++) {
			// Cada vez que entramos guardamos el último
			ultimo=A[TAM-1];
			
			// Hacemos el desplazamiento completo
			for (int j=TAM-2; j>=0; j--) {
				A[j+1]=A[j];
			}
			// Cada vez que salimos devolvemos el último al primero
			// antes de la siguiente vuelta
			A[0]=ultimo;
		}
		System.out.println("\nVector desplazado "+N+" posiciones: ");
		mostrar(A);
		
	}

}
