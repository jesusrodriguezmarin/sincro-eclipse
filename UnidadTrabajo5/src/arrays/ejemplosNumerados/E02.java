package arrays.ejemplosNumerados;

public class E02 {

	public static void main(String[] args) {
		
		// Creamos el primer array
		int A[] = new int[10];
		
		// Creamos el segundo array
		int B[] = {10,20,30,40};
		
		// Mostramos la longitud de A[]
		System.out.println("Longitud de A[]: "+A.length);
		
		// Mostramos la longitud de B[]
		System.out.println("Longitud de B[]: "+B.length);

		// Mostramos los valores de las posiciones del primer array
		System.out.print("\nValores de A[]: ");
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
		

		// Almacenamos nuevos valores en el array
		for (int i=0; i<A.length; i++) {
			A[i] = i+1; 
		}
		// Mostramos valores nuevos de A[]
		System.out.print("\nValores nuevos de A[]: ");
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
		
		// Mostramos los valores de A[] en orden inverso
		System.out.print("\nA[] en orden inverso: ");
		for (int i=A.length-1; i>=0; i--) {
			System.out.print(A[i]+" ");
		}
		
		// Mostramos los valores de las posiciones del segundo array
		System.out.print("\n\nValores de B[]: ");
		for (int i=0; i<B.length; i++) {
			System.out.print(B[i]+" ");
		}
		// Mostramos los valores de B[] en orden inverso
		System.out.print("\nB[] en orden inverso: ");
		for (int i=B.length-1; i>=0; i--) {
			System.out.print(B[i]+" ");
		}
		
	}

}
