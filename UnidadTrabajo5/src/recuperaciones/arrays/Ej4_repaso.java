package recuperaciones.arrays;

public class Ej4_repaso {

	/**
	 * Procedimiento que muestra todos los elementos contenidos en un array de enteros
	 * @param a - array de enteros
	 */
	public static void mostrar (int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos un array de números enteros
		int[] a = {1,2,3,4,5,6,7,8};
		
		// Mostramos
		System.out.print("Array original: ");
		mostrar(a);
		
		// Modificamos incrementa/decrementa
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				a[i]++;
			} else {
				a[i]--;
			}
		}
		System.out.print("\nArray modificado: ");
		mostrar(a);
	
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 != 0) {
				a[i] = a[i] * 10;
			}
		}
		System.out.print("\nArray multiplicado: ");
		mostrar(a);
	}

}
