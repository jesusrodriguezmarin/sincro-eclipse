package arrays.ejemplosNumerados;

public class E06 {

	/**
	 * Procedimiento que muestra los valores del array
	 * @param array - array pasado por parámetro
	 */
	public static void mostrar(int array[]) {
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
		}
	
	/**
	 * Procedimiento que muestra los valores del array en oreden inverso
	 * @param array - array pasado por parámetro
	 */
	public static void inverso(int array[]) {
		for (int i=array.length-1; i>=0; i--) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	/**
	 * Función que devuelve el mayor de los valores del array
	 * @param array - array pasado por parámetro 
	 * @return el mayor de los valores del array
	 */
	public static int mayor(int array[]) {
		int m = array[0];
		for (int i=1; i<array.length; i++) {
			if (array[i]>m)
				m=array[i];
		}
		return m;
	}
	
	/**
	 * Función que devuelve el menor de los valores almacenados en el array
	 * @param array - array pasado por parámetro
	 * @return - el menor de los valores almacenados en el array
	 */
	public static int menor(int array[]) {
		int m = array[0];
		for (int i=1; i<array.length; i++) {
			if (array[i]<m)
				m=array[i];
		}
		return m;
	}
	
	/**
	 * Función que devuelve el valor medio de los valores almacenados
	 * @param array - array pasado por parámetro
	 * @return - el valor medio
	 */
	public static double media(int array[]) {
		double s = array[0];
		for (int i=1; i<array.length; i++) {
			s+=array[i];
		}
		return s/array.length;
	}
	
	// Programa principal
	public static void main(String[] args) {
		// Cremos un array con números enteros
		int tabla[]= {11,23,32,4,51,21,8,10,17};

		// Mostramos los valores almacenados en el array
		mostrar(tabla);
		
		// Mostramos los valores en oreden inverso
		inverso(tabla);
		
		// Mostramos el mayor valor
		System.out.println("Mayor: "+mayor(tabla));
		
		// Mostramos el menor valor
		System.out.println("Menor: "+menor(tabla));
		
		// Mostramos la media de los valores
		System.out.println("Media: "+media(tabla));
		
	}

}
