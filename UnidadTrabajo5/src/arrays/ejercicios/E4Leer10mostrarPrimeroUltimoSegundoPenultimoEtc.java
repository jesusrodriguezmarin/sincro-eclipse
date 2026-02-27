package arrays.ejercicios;

import java.util.Scanner;

public class E4Leer10mostrarPrimeroUltimoSegundoPenultimoEtc {

	// Constante para el tamaño del array
	final static int TAM=10;
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos el array
		int A[]= new int[TAM];
		
		// Creamos el lector
		Scanner sc = new Scanner(System.in);
		
		// Control de excepcion
		try {
			System.out.println("Itroduce: "+TAM+" números enteros: ");
			for (int i=0; i<A.length; i++) {
				System.out.print("Introduce un número: ");
				A[i]=sc.nextInt();
			}
			
		} catch (Exception e) {
			System.err.println(">> ERROR: Tipo de dato no válido");
		} finally {
			sc.close();
		}

		// Mostramos los valores almacenados en el array en orden alterno
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
			System.out.print(A[A.length-1-i]+" ");
			
		}
		
	}

}
