package arrays.ordenacion;

public class E6clase {

	final static int TAM=50;
	final static int LIMITE=50;
	
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
	 * Función que calcula la media de los valores almacenados en el array
	 * @param 
	 * @return 
	 */
	public static double media(int array[]) {
		double suma = 0;
		for (int i=0; i<array.length; i++) {
			suma+=array[i];
		}
		return suma/array.length;
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
		
		// Creamos un array
		int vector[]= new int[TAM];
		
		// Creamos y almacenamos los valores en el vector
		for (int i=0; i<vector.length; i++) {
			vector[i]=aleatorio(TAM);
		}
		
		// Variables para las operaciones
		// int mayor, menor;
		// double suma = 0;
		
		// Inicializamos las variables al primer valor del array
		// mayor = menor = vector[0];
		
		/* No usamos esta forma
		// Calculamos el mayor, menor y media de los valores
		for (int i=0; i<vector.length; i++) {
			if (vector[i]>mayor)
				mayor=vector[i];
			if (vector[i]<menor)
				menor=vector[i];
			suma+=vector[i];
		}
		double media = suma/TAM;
		*/
		
		// Sacar el mayor y el menor ordenando con bubblesort y cogiendo el primero y el último
		bubblesort(vector);
		System.out.println(vector);
		
		System.out.print("10 mayores: ");
		for (int i=TAM-1; i>=TAM-10; i--) {
			System.out.print(vector[i]+" ");
		}

	}

}
