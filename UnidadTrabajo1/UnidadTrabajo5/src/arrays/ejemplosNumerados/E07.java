package arrays.ejemplosNumerados;

public class E07 {

	/**
	 * Procedimiento que muestra los valores almacenados en el array
	 * @param a - array de números enteros
	 */
	public static void mostrar(int a[]) {
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		// Creamos el primer vector/array A
		int A[]= {1,3,5,7,9};
		
		// Mostramos los valores almacenados
		System.out.print("Vector A: ");
		mostrar(A);
		
		// Creamos el segundo vector/array B
		System.out.print("Vector B: ");
		int B[]= {2,4,6,8,10};
		
		// Mostramos los valores almacenados
		mostrar(B);

		// Creamos el tercer vector/array con A+B
		int C[]= new int[A.length+B.length];
		
		// Mostramos los valores almacenados
		System.out.print("Vector C: ");
		mostrar(C);
		
		// Indice para el array C
		int i=0;
		
		// Almacenamos en el tercer vector/array A
		for (int j=0; j<A.length; j++) {
			C[i]=A[j];
			i++;
		}
		
		// Almacenamos en el tercer vector/array B
		for (int j=0; j<B.length; j++) {
			C[i]=B[j];
			i++;
		}
		
		// Mostramos los valores almacenados
		System.out.print("Vector C: ");
		mostrar(C);
	}

}
