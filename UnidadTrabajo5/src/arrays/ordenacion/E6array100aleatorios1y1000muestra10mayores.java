package arrays.ordenacion;

public class E6array100aleatorios1y1000muestra10mayores {

	// Constante para el tamaño del array
	final static int TOTAL=100;
	
	// Constante para el límite de aleatorio
	final static int LIMITE=1000;
	
	/**
	 * Procedimiento que muestra todos los valores de un array
	 * @param array de números enteros
	 */
	public static void mostrar(int array[]) {
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	/**
	 * Función que devuelve un número aleatorio entre 1 y N
	 * @param N - límite de rango para los números
	 * @return - un número entero aleatorio
	 */
	public static int aleatorio(int N) {
		int num = (int)(Math.random()*N+1);
		return num;
	}
	
	// Programa principal
	public static void main(String[] args) {
	
		// Creamos el array
		int tabla[]= new int[TOTAL];
		
		// Almacenamos los valores aleatorios en el array
		for (int i=0; i<tabla.length; i++) {
			tabla[i]=aleatorio(LIMITE);
		}
		// Mostramos los valores del array
		System.out.println("Valores del array: ");
		mostrar(tabla);
		
		// Ordenamos de mayor a menor
		for (int i=0; i<tabla.length-1; i++) {
			for (int j=0; j<tabla.length-1-i; j++) {
				if (tabla[j]<tabla[j+1]) {
					int aux = tabla[j];
					tabla[j] = tabla[j+1];
					tabla[j+1] = aux;
				}
					
			}
		}
		// Creamos el array para almacenar los 10 valores mayores
		int tabla10[]= new int[10];
		
		// Recorremos el nuevo array almacenando los 10 primeros elementos
		for (int i=0; i<tabla10.length; i++) {
			tabla10[i]=tabla[i];
		}
		
		// Mostramos los valores del nuevo array
		System.out.println("Los 10 mayores: ");
		mostrar(tabla10);

	}

}
