package recuperaciones.arrays.ejercicios1;

public class Ej6_repaso {

	/**
	 * Procedimiento que muestra todas las posiciones de un array
	 * @param a - array de números enteros
	 */
	public static void mostrar (int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos un array a de números enteros
		int[] a = {1,3,5,7,9};
		
		// Creamos un array b de números enteros
		int[] b = {2,4,6,8,10};
		
		// Creamos un array c con el tamaño de a + b
		int[] c = new int[a.length + b.length];
		
		// Almacenamos a en las primeras posiciones y b en las restantes
		for (int i = 0; i < a.length; i++) {
			c[i] = a[i];
		}
		for (int i = 0; i < b.length; i++) {
			c[i+a.length] = b[i];
		}
		
		// Mostramos
		mostrar(a);
		mostrar(b);
		mostrar(c);

	}

}
