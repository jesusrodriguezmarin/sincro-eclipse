package arrays.ordenacion;

public class E7clase_v1funcionBoolean {

	final static int TAM=100;
	final static int LIMIT=100;
	
	/**
	 * Función que indica si un numero N se encuentra entre los valores almacenados en array
	 * @param N - número entero
	 * @param array de números enteros
	 * @return - TRUE si N está en los valores, FALSE si no está
	 */
	public static boolean encuentra(int N, int array[]) {
		for (int i=0; i<array.length; i++) {
			if (N==array[i])
				return true;
		}
		return false;
	}
	
	/**
	 * Función que devuelve un número aleatorio entre 1 y N
	 * @param N
	 * @return
	 */
	public static int aleatorio(int N) {
		int num = (int)(Math.random()*N+1);
		return num;
	}
	
	/**
	 * Procedimiento que muestra todos los valores del array
	 * @param array
	 */
	public static void mostrar(int array[]) {
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	/**
	 * Función que ordena los valores de un array
	 * @param array
	 */
	public static void bubblesort(int array[]) {
		int aux;
		// Damos tantas pasadas como posiciones tenga el array
		for (int i=array.length; i>0; i--) {
			for (int j=0; j<i-1; j++) {
				// Intercambio de valores
				if (array[j]>array[j+1]) {
					aux = array[j+1];
					array[j+1]=array[j];
					array[j]=aux;
					
				}
			}
		}
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos el array
		int[] lista= new int[TAM];
		
		// Generamos los números aleatorios
		for (int i=0; i<TAM; i++) {
			lista[i]=aleatorio(TAM);
			
		}
		
		// Mostramos el array
		System.out.println("Lista desordenada: ");
		mostrar(lista);
		
		bubblesort(lista);
		System.out.println("Lista ordenada: ");
		mostrar(lista);
		
		// Buscamos y mostramos los valores que no estan almacenados
		System.out.println("Ausentes en lista: ");
		for (int num=1; num<=LIMIT; num++) {
			if (!encuentra(num, lista))
				System.out.print(num+" ");
		}
	}

}
