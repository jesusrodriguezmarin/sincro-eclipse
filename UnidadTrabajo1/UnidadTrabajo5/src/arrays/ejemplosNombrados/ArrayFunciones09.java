package arrays.ejemplosNombrados;

public class ArrayFunciones09 {

	/**
	 * Procedimiento que muestra los valores almacenados en el array
	 * @param array
	 */
	public static void mostrar(int array[]) {
		for (int i=0; i<array.length; i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}
	
	/**
	 * Procedimiento que muestra los valores almacenados en el array
	 * en orden inverso
	 * @param array
	 */
	public static void inverso(int array[]) {
		for (int i=array.length-1; i>=0; i--)
			System.out.print(array[i]+" ");
		System.out.println();
	}
	
	/**
	 * Procedimiento que muestra el mayor valor del array
	 * @param array
	 */
	public static int mayor(int array[]) {
		int m = array[0];
		for (int i=1; i<array.length; i++)
			if (m<array[i])
				m=array[i];
		return m;
	}
	
	/**
	 * Procedimiento que muestra el menor valor del array
	 * @param array
	 */
	public static int menor(int array[]) {
		int mn = array[0];
		for (int i=1; i<array.length; i++)
			if (mn>array[i])
				mn=array[i];
		return mn;
	}
	
	/**
	 * Función que devuelve la media de los valores almacenados en un array
	 * @param array de los valores enteros
	 * @return - double - media de los valores almacenados
	 */
	private static double media(int array[]) {
		double suma = 0;
		for (int i=0; i<array.length; i++) {
			suma+=array[i];
		}
		return suma/array.length;
	}
	
	
	// Programa principal
	public static void main(String[] args) {
		// Creamos un array de números enteros
		int tabla[]= {11, 23, 32, 4, 51, 21, 8, -10, 17};
		
		// Mostramos el array por pantalla
		System.out.println("Valores almacenados en el array: ");
		mostrar(tabla);
		
		// Mostramos el array por pantalla en orden inverso
		System.out.println("\nValores almacenados en orden inverso: ");
		inverso(tabla);
		
		// Mostramos el mayor valor almacenado en el array
		System.out.println("\nMayor valor almacenado: "+mayor(tabla));
		
		
		// Mostramos el menor valor almacenado en el array
		System.out.println("\nMenor valor almacenado: "+menor(tabla));
		
		
		// Mostramos la media de los valores almacenados en el array
		System.out.println("\nMedia de los valores almacenados: "+media(tabla));
		
	}

}
