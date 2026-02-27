package arrays.ejemplosNombrados;

public class ArrayIncrementoDecremento08 {

	/**
	 * Procedimiento que muestra por pantalla todos los valores del array
	 * @param v
	 */
	private static void visualizar(int[] v) {
		for (int i=0; i<=v.length-1; i++)
			System.out.print(v[i]+" ");
		System.out.println();
	}
	
	/**
	 * Programa principal
	 * @param args
	 */
	public static void main(String[] args) {
		// 1. Declaramos y creamos el array
		int[] vector = {1,2,3,4,5,6,7,8};
		
		// 2. Visualizamos el array
		visualizar(vector);
		
		// 3. Incrementamos los valores pares y decrementamos los valores impares
		for (int i=0; i<vector.length; i++) {
			if (vector[i]%2==0)
				vector[i]++;
			else 
				vector[i]--;
		}
			
		// 4. Visualizamos el array con las actualizaciones
		visualizar(vector);
		
		// 5. Multiplicamos por 10 los valores impares
		for (int i=0; i<vector.length; i ++)
			if (vector[i]%2!=0)
				vector[i] *= 10;
			
		
		// 6. Visualizamos el array con los valores actuales
		visualizar(vector);
	}

}
