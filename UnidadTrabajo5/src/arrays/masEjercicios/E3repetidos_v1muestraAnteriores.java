/**
 * Programa que genere de forma aleatoria cinco valores entre 1 y 10 que se guarden
 * en un array, si alguno de los números generados ya se encuentra en el array
 * debe indicar un mensaje
 */

package arrays.masEjercicios;

public class E3repetidos_v1muestraAnteriores {

	final static int TAM=5;			// Longitud del array
	final static int LIMITE=10;		// Limite para los elementos aleatorios
	
	/**
	 * Función que devuelve un número aleatorio entre 1 y LIMITE
	 * @return un número aleatorio
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
	
	// Programa principal
	public static void main(String[] args) {
		
		// Declaramos y creamos el array A
		int A[]= new int[TAM];
		
		// Generamos los elementos para cada array
		
		// 1. Recorremos el array itaración por iteración
		for (int i=0; i<A.length; i++) {
			
			// 2. Generamos un valor a la iteración actual
			A[i]=aleatorio(LIMITE);
			
			// 3. Mostramos el valor generado para esa iteración
			System.out.print("i= ["+i+"] "+A[i]);
			
			// 4. Mostramos mensaje de separación
			System.out.print(" --> Anteriores: ");
			
			// Recorremos todos los valores anteriores
			
			// 1. Desde 0 hasta la iteración actual
			for (int j=0; j<i; j++) {
				
				// 2. Imprimimos los anteriores si los hay
				System.out.print(A[j]+" ");
			}
			// 3. Salto de línea
			System.out.println();
		}
		
	
	}

}
