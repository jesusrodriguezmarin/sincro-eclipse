package arrays.ordenacion;

public class E7array100aleatorio100mostrarExcluidosenRango {

	final static int TAM=100;
	
	/**
	 * Muestra todos los elementos de un array
	 * @param a - array de números enteros
	 */
	public static void mostrar(int a[]) {
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	/**
	 * Función que calcula un número aleatorio entre 1 y N
	 * @param N - límite de rango
	 * @return - un número entero aleatorio
	 */
	public static int aleatorio(int N) {
		int num = (int)(Math.random()*N+1);
		return num;
	}
	
	/**
	 * Procedimiento que ordena el array con bubblesort
	 * @param array de números enteros
	 */
	public static void bubblesort(int array[]) {
		int aux;
		boolean cambio;
		
		for (int i=0; i<array.length; i++) {
			cambio = false;
			for (int j=0; j<array.length-1-i; j++) {
				if (array[j]>array[j+1]) {
					aux = array[j];
					array[j]=array[j+1];
					array[j+1]=aux;
					cambio = true;
				}
			}
			if (!cambio)
				return;
		}
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos array
		int array[]= new int[TAM];
		
		// Creamos y almacenamo los números aleatorios en array
		for (int i=0; i<array.length; i++) {
			array[i]=aleatorio(TAM);
		}
		// Mostramos desordenados
		System.out.println("Desordenados:");
		mostrar(array);
		
		// Ordenamos los números con bubblesort
		bubblesort(array);
		
		// Mostramos los números ordenados de menor a mayor
		System.out.println("Ordenados:");
		mostrar(array);
		
		// Mostramo los números excluidos
		System.out.println("Excluidos: ");
		int esperado = 1;
		
		for (int i=0; i<array.length; i++) {
			
			// Si el número es igual al anterior lo saltamos
			if (i>0 && array[i] == array[i-1]) {
				continue;
			}
			
			// Si el número es mauor que el que esperamos hay un hueco
			while (esperado < array[i]) {
				System.out.print(esperado+" ");
				esperado++;
			}
			
			// Si el número es el que esperamos, avanzamos el contador
			if (array[i] == esperado) {
				esperado++;
			}
			
		}
		// Comprobamos si faltan números desde el último valor hasta TAM
		while (esperado<=TAM) {
			System.out.print(esperado+" ");
			esperado++;
		}

	}

}
