package arrays.ordenacion;

public class E2burbujaFlag {

	// Constantes para tamaño y límite
	final static int TAM=50;
	final static int LIM=100;
	
	/**
	 * Función que genera números aleatorios entre N y 1
	 * @param N - nº entero positivo
	 * @return
	 */
	public static int aleat(int N) {
		return (int)(Math.random()*N+1);
	}
	
	/**
	 * Procedimiento que ordena un array por el método de burbuja
	 * @param array de números enteros
	 */
	public static void burbuja(int array[]) {
		int aux;
		boolean cambio;	// Toma TRUE cuando se produzca un intercambio
		
		// Recorremos todas las posiciones del array
		for (int i=array.length; i>0; i--) {
			cambio = false;
			for (int j=0; j<i-1; j++) {
				if (array[j]>array[j+1]) {
					// Intercambiamos valores
					aux = array[j+1];
					array[j+1] = array[j];
					array[j] = aux;
					cambio = true;
				}
			}
			if (!cambio)
				return;
		}
	}
	
	/**
	 * Procedimiento que muestra todos los elementos de un array
	 * @param a - array de números enteros
	 */
	public static void mostrar(int a[]) {
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos un array con 50 valores aleatorios entre 1 y 100
		int tabla[]= new int[TAM];
		
		// Generamos los valores para almacenaralos en el array
		for (int i=0; i<TAM; i++) {
			tabla[i]=aleat(LIM);
		}
		// Mostramos la lista desordenada
		System.out.println("Valores desordenados: ");
		mostrar(tabla);
		
		// Ordenamos los valores con bubblesort
		burbuja(tabla);
		
		// Mostramos lo lista ordenada 
		System.out.println("\nValores ordenados: ");
		mostrar(tabla);

	}

}
