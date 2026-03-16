/**
 * Programa que genere de forma aleatoria dos conjuntos de valores enteros y los almacene
 * cada uno en un array. El programa debe indicar cuántos valores comunes almacenan los
 * arrays (es decir, que valores aparecen tanto en el primer como en el segundo array)
 */

package arrays.masEjercicios;

public class E2comparaDosArraysCuentaRepeticionesBreak {

	final static int TAM=5;
	final static int LIMITE=10;
	
	/**
	 * Función que devuelve un número aleatorio entre 1 y LIMITE
	 * @return un número entero generado de forma aleatoria
	 */
	public static int aleatorio(int N) {
		int num = (int)(Math.random()*N+1);
		return num;
	}
	
	/**
	 * Muestra los valores de un array
	 * @param A - array de números enteros
	 */
	public static void mostrar(int A[]) {
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	
	/**
	 * Función que cuenta cuantas veces se repiten los elementos de un array con otro
	 * @param A - array de numeros enteros
	 * @param B - array de numeros enteros
	 * @return - cantidad de repeticiones
	 */
	public static int comunes(int A[], int B[]) {
		// Declaramos conta a 0
		int conta = 0;
		// Recorremos el primer array de posicion en posicion
		for (int i=0; i<A.length; i++) {
			// En cada vuelta (posicion) del primero recorremos el segundo array completo
			for (int j=0; j<B.length; j++) {
				// Si coincide la posición del primer array con alguna del segundo
				if (A[i]==B[j]) {
					// Conta suma una vez
					conta++;
					// Para las comprobaciones de ese elemento
					break;
				}
					
			}
		}
		// terminados los dos recorridos, imprimimos el número de repeticiones total
		return conta;
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos un array A
		int A[]= new int[TAM];
		
		// Creamos un array B
		int B[]= new int[TAM];
		
		// Generamos los elementos para cada array
		for (int i=0; i<A.length; i++) {
			A[i]=aleatorio(LIMITE);
		}
		
		for (int i=0; i<B.length; i++) {
			B[i]=aleatorio(LIMITE);
		}
		
		// Mostramos los elementos de los arrays
		System.out.print("A: ");
		mostrar(A);
		System.out.print("B: ");
		mostrar(B);
		
		System.out.println("Se repiten: "+comunes(A,B)+" veces");
	}

}
