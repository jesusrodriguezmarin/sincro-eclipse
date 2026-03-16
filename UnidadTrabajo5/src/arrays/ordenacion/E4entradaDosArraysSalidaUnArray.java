package arrays.ordenacion;

public class E4entradaDosArraysSalidaUnArray {

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
	
	/**
	 * Función que combina dos arrays pasados por parámetros
	 * @param a - un array de números enteros
	 * @param b - un array de números enteros
	 * @return - un array de números enteros ordendos
	 */
	public static int[] combina(int[] a, int b[]) {
		int c[] = new int[a.length+b.length];
		
		// Variable de control para recorrer c
		int i=0;
		
		// Recorremos a y guardamos sus valores en c
		for (int j=0; j<a.length; j++) {
			c[i]=a[j];
			i++;
		}
		
		// Recorremos b y guardamos sus valores en c
		for (int k=0; k<b.length; k++) {
			c[i]=b[k];
			i++;
		}
		// Ordenamos los valores en c
		burbuja(c);
		
		return c;
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos un array con 50 valores aleatorios entre 1 y 100
		int tabla1[]= new int[TAM];
		int tabla2[]= new int[TAM];
		int tabla3[]= new int[2*TAM];
	
		// Generamos los valores para almacenaralos en el array
		for (int i=0; i<TAM; i++) {
			tabla1[i]=aleat(LIM);
			tabla2[i]=aleat(LIM);
		}
		// Mostramos la lista desordenada
		System.out.println("-----Valores desordenados-----");
		mostrar(tabla1);
		mostrar(tabla2);
		
		// Ordenamos los valores con bubblesort
		burbuja(tabla1);
		burbuja(tabla2);
		
		// Mostramos lo lista ordenada 
		System.out.println("\n-----Valores ordenados-----");
		System.out.println("Array 1: ");
		mostrar(tabla1);
		System.out.println("\nArray 2: ");
		mostrar(tabla2);
		
		// Combinamos las dos tablas en la tabla final
		// Llamando a la función combina
		System.out.println("\nArray 3: ");
		tabla3=combina(tabla1, tabla2);
		mostrar(tabla3);

	}

}
