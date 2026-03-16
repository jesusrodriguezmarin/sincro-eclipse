/**
 * Programa que genere de forma aleatoria cinco valores entre 1 y 10 que se guarden
 * en un array, si alguno de los números generados ya se encuentra en el array
 * no debe guardarlo para que no haya repetidos
 */

package arrays.masEjercicios;

public class E4generarArrayAleatorioSinRepetirValores {

	final static int TAM=5;			// Longitud del array
	final static int LIMITE=10;		// Limite para los elementos aleatorios
	
	/**
	 * Función que devuelve un número aleatorio entre 1 y LIMITE
	 * @return un número entero generado de forma alratoria
	 */
	public static int aleatorio(int N) {
		int num = (int)(Math.random()*N+1);
		return num;
	}
	
	/**
	 * Muestra todos los valores de un array
	 * @param A - array de números enteros
	 */
	public static void mostrar(int A[]) {
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	
	/**
	 * Función que indica si un valor N se encuentra almacenado en el array A
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
		
		// Declaramos y creamos el array A
		int A[]= new int[TAM];
		
		// Generamos los elementos para cada array
		for (int i=0; i<A.length; i++) {
			do {
				// Generamos un valor aleatorio para la posición actual
				A[i]=aleatorio(LIMITE);
				System.err.print("Muestra del valor temporal: "+A[i]);
				System.out.println();
				
			// Mientras el número ya exista
			} while (encontrado(A[i],A,i));
			
			// Si no existe salimos e imprimimos
			System.out.print("Muestra del valor final: ");
			System.out.print(A[i]+" ");
			System.out.println();

		// Volvemos al bucle para generar el siguiente valor
		}
		
	}

}
