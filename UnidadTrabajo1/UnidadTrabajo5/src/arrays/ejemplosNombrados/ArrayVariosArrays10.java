package arrays.ejemplosNombrados;

public class ArrayVariosArrays10 {
	
	/**
	 * Procedimiento para mostrar los valores del array
	 * @param v
	 */
	private static void mostrar(int[] v) {
		for (int i=0; i<v.length; i++)
			System.out.print(v[i]+" ");
		System.out.println();
	}
	
	// Programa principal
	public static void main(String[] args) {
		// Creamos el primer array
		int[] A= {1,3,5,7,9};
		
		// Creamos el segundo array
		int B[]= {2,4,6,8,10};
		
		// Mostramos A
		System.out.println("Vector A: ");
		mostrar(A);
		
		// Mostramos B
		System.out.println("Vector B: ");
		mostrar(B);

		// Creamos el tercer array con las distancias de A y B
		int C[]= new int[A.length+B.length];
		System.out.println("Vector C: ");
		mostrar(C);
		
		int i=0; // Indice para el array C
		
		// Copiamos los valores de A en C
		for (int j=0; j<A.length; j++) {
			C[i]=A[j];
			i++;
		}
		// Copiamos los valores de B en C
		for (int j=0; j<B.length; j++) {
			C[i]=B[j];
			i++;
		}	
		System.out.println("Vector C: ");
		mostrar(C);
	}

}
