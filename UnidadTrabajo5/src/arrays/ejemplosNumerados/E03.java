package arrays.ejemplosNumerados;

public class E03 {

	/**
	 * Procedimiento que muestra todos los elementos de un array en su orden
	 * @param A - array de números enteros
	 */
	public static void mostrar(int A[]) {
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	
	/**
	 * Procedimiento que muestra todos los elementos de un array en orden inverso
	 * @param A - array de números enteros
	 */
	public static void inverso(int A[]) {
		for (int i=A.length-1; i>=0; i--) {
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos un array
		int lista[]= {1,2,3,4,5,6,7,8,9,10};
		
		// Mostramos todos los valores del vector en orden 
		mostrar(lista);
		
		// Mostramos todos los valores del vector en orden inverso
		inverso(lista);
		
		// Mostramos el primer valor del array
		System.out.println("primera: "+lista[0]);
		
		// Mostramos el último valor del array
		System.out.println("última: "+lista[lista.length-1]);
		
		// Mostramos el segundo valor del array 
		System.out.println("segunda: "+lista[1]);
	
		// Mostramos el penúltimo valor del array
		System.out.println("penúltima: "+lista[lista.length-2]);
		
		// Mostramos el tercer valor del array
		System.out.println("tercera: "+lista[2]);
		
		// Mostramos el antepenúltimo valor del array
		System.out.println("antepenúltima: "+lista[lista.length-3]);
		
	}

}
