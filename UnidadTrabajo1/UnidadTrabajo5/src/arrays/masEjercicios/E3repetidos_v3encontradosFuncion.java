/**
 * Programa que genere de forma aleatoria cinco valores entre 1 y 10 que se guarden
 * en un array, si alguno de los números generados ya se encuentra en el array
 * debe indicar un mensaje
 */

package arrays.masEjercicios;

public class E3repetidos_v3encontradosFuncion {

	// Constantes globales
	final static int TAM=5;			// Longitud del array
	final static int LIMITE=5;		// Limite para los elementos aleatorios
	
	/**
	 * Función que devuelve un número aleatorio entre 1 y LIMITE
	 * @return
	 */
	public static int aleatorio(int N) {
		int num = (int)(Math.random()*N+1);
		return num;
	}
	
	/**
	 * Muestra los valores de un array
	 * @param A
	 */
	public static void mostrar(int A[]) {
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	
	/**
	 * Función que indica si el valor se encuentra almacenado en el array A
	 * @param N - Valor entero a buscar
	 * @param A - Array de valores enteros
	 * @param pos - posición del array hasta la que vamos a comparar valores
	 * @return TRUE si N se encuentra entre los valores almacenados
	 *  	False en otro caso
	 */
	public static boolean encontrado(int N, int A[], int pos) {
		// Recorremos A
		for (int i=0; i<pos; i++) {
			if (N==A[i])
				return true;
		}
		return false;
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos el array declarado global anteriormente
		int A[] = new int[TAM];
		
		// Generamos los elementos para cada array
		for (int i=0; i<A.length; i++) {
			A[i]=aleatorio(LIMITE);
			System.out.print(A[i]);
			if (encontrado(A[i], A, i)) {
				System.out.print(" --> Repetido");
			}
					
			System.out.println();
			}
		
	}

}
