package arrays.ejemplosNombrados;

public class ArraysVariasFormasProcedimiento05 {

	/**
	 * Procedimiento que muestre por pantalla los valores almacenados en el array
	 * @param array - array o vector de números enteros
	 */
	private static void mostrar(int[] array) {
		for (int i=0; i<array.length; i++)
			System.out.print(array[i]+" ");
	}
	
	// Programa principal
	public static void main(String[] args) {
		// Primer array
		int A[] = new int[5];			// A = [0,0,0,0,0]
		
		// Segundo array
		int[] B = {10, 20, 30, 40};		// B = [10,20,30,40]
		
		// Mostramos las longitudes de los arrays
		System.out.println("Longitud de A: "+A.length);
		System.out.println("Longitud de B: "+B.length);
		
		// Mostramos los valores que contienen los arrays
		System.out.print("\nA: ");
		mostrar(A);
		System.out.print("\nB: ");
		mostrar(B);
		
		// Aumentamos en 1 los valores almacenados en A
		for (int i=0; i<A.length; i++)
			A[i]++;
		
		// Decrementamos en 1 los valores almacenados en B
		for (int i=0; i<B.length; i++)
			B[i]--;
		
		// Mostramos los valores actualizados de A y B
		System.out.print("\nA: ");
		mostrar(A);
		System.out.print("\nB: ");
		mostrar(B);

	}

}
