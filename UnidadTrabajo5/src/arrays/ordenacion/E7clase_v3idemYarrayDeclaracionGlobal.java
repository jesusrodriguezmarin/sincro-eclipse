package arrays.ordenacion;

public class E7clase_v3idemYarrayDeclaracionGlobal {

	// Constantes comunes
	final static int TAM=100;		// Tamaño del array (número de elementos)
	final static int LIMIT=100;		// Números entre 1..LIMIT
	
	// Variable común
	static int[] lista;	// Array global
	
	/**
	 * Función que indica si un numero N se encuentra entre los valores almacenados en lista
	 * Requisito: si el array está ordenado
	 * @param N - número entero
	 * @return - TRUE si N está en los valores, FALSE si no está
	 */
	public static boolean encuentra(int N) {
		for (int i=0; i<lista.length; i++) {
			if (N==lista[i])
				return true;
			if (N<lista[i])
				return false;
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
	public static void mostrar() {
		for (int i=0; i<lista.length; i++) {
			System.out.print(lista[i]+" ");
		}
		System.out.println();
	}
	
	/**
	 * Función que ordena los valores de un array
	 * @param array
	 */
	public static void bubblesort() {
		int aux;
		// Damos tantas pasadas como posiciones tenga el array
		for (int i=lista.length; i>0; i--) {
			for (int j=0; j<i-1; j++) {
				// Intercambio de valores
				if (lista[j]>lista[j+1]) {
					aux = lista[j+1];
					lista[j+1]=lista[j];
					lista[j]=aux;
					
				}
			}
		}
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos el array
		lista= new int[TAM];
		
		// Generamos los números aleatorios
		for (int i=0; i<TAM; i++) {
			lista[i]=aleatorio(TAM);
			
		}
		
		// Mostramos el array
		System.out.println("Lista desordenada: ");
		mostrar();
		
		bubblesort();
		System.out.println("Lista ordenada: ");
		mostrar();
		
		// Buscamos y mostramos los valores que no estan almacenados
		System.out.println("Ausentes en lista: ");
		for (int num=1; num<=LIMIT; num++) {
			if (!encuentra(num))
				System.out.print(num+" ");
		}
	}

}
