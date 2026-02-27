/**
 * Programa que genere de forma aleatoria cinco valores entre 1 y 10 que se guarden
 * en un array, si alguno de los números generados ya se encuentra en el array
 * debe indicar un mensaje
 */

package arrays.masEjercicios;

public class E3repetidos_v2encontradosMain {

	final static int TAM=10;			// Longitud del array
	final static int LIMITE=10;		// Limite para los elementos aleatorios
	
	/**
	 * Función que devuelve un número aleatorio entre 1 y LIMITE
	 * @return un número entero generado aleatoriamente
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
		for (int i=0; i<A.length; i++) {
			
			// Generamos elemento para esta iteración
			A[i]=aleatorio(LIMITE);
			
			// Mostramos la posición
			System.out.print(A[i]);
			
			// Recorremos todos los valores anteriores desde 0 hasta la iteración actual
			for (int j=0; j<i; j++) {
				
				// Comparamos la iteración actual de i for genaral
				// con la iteración actual j for anidado
				if (A[i]==A[j]) {
					
					// Si en alguan iteración de j coincide con la actual de i
					// Imprime repetido
					System.out.print(" -->Repetido");
					
					// Si entra aquí  es porque está repetidp 
					// y por tanto imprime repetido, sale con break
					// sigue hacia el for principal otra vez para comprobar otro
					break;
				}
						
			}
			// Salto después del for general
			System.out.println();

		}	
	
	}

}
