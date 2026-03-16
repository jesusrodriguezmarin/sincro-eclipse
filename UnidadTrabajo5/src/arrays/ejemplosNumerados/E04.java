package arrays.ejemplosNumerados;

public class E04 {

	/**
	 * Procedimiento que muestra los valores del array
	 * @param A - array pasado por parámetro
	 */
	public static void mostrar(int A[]) {
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		// Creamos el array
		int A[]= {1,2,3,4,5,6,7,8};
		
		// Visualizamos el array
		mostrar(A);
		
		// Incrementamos los valores pares y decrementamos los imprares
		for (int i=0; i<A.length; i++) {
			if (A[i]%2==0) {
				A[i]++;
			} else {
				A[i]--;
			}
		}
		
		// Mostramos los nuevos valores
		mostrar(A);
		
		// Multiplicamos por 10 los valores impares
		for (int i=0; i<A.length; i++) 
			if (A[i]%2!=0)
				A[i]*=10;
		
		// Mostramos los nuevos valores
		mostrar(A);
	}

}
