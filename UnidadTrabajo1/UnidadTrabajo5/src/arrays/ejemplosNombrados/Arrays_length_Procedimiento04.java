package arrays.ejemplosNombrados;

public class Arrays_length_Procedimiento04 {

	/**
	 * Porcedimiemto que muestra por pantalla los valores almacenados en un array
	 * @param array - array o vector de números enteros
	 */
	private static void imprimir(int array[]) {
		for (int i=0; i<array.length; i++)
			System.out.print(array[i]+" ");
	}
	
	public static void main(String[] args) {
		// Array
		int A[] = new int[10];
		
		// Mostramos la longitud del array con .length
		System.out.println("Longitud: "+A.length);
		
		// Mostramos los valores contenidos en el array por defecto (0) LLAMANDO AL PROCEDIMIENTO
		// Usamos length para la longitud establecida en la construccion del array int[10]
		System.out.print("Valores iniciales: ");
		imprimir(A);
		
		// Asignamos nuevos valores que guardaremos en las posiciones del array
		for (int i=0; i<A.length; i++)
			A[i]=i+1;
		
		// Mostramos los valores LLAMANDO AL PROCEDIMIENTO
		System.out.print("\nValores actuales: ");
		imprimir(A);
		
		// Mostramos los valores contenidos en el array en orden inverso
		System.out.print("\nValores orden inverso: ");
		for (int i=A.length-1; i>=0; i--)
			System.out.print(A[i]+" ");
		
		// Mostramos el primer y último valor (último valor es length-1)
		System.out.println("\nPrimer valor "+A[0]);
		System.out.println("Último valor: "+A[A.length-1]);

	}

}
