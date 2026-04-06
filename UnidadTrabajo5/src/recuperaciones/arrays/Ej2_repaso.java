package recuperaciones.arrays;

public class Ej2_repaso {

	// Constante 
	final static int TAM = 10;
	
	/**
	 * Muestra todos los elementos contenidos en un array de números enteros
	 * @param a - array de númros enteros
	 */
	public static void mostrar (int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	public static void inverso (int[] a) {
		for (int i = a.length-1; i >= 0; i--) {
			System.out.print(a[i]+" ");
		}
	}
	
	// Programa principal
	public static void main(String[] args) {
	
		// Creamos un array de números enteros a
		int[] n = new int[TAM];
		
		// Creamos un array de números enteros b
		int[] m = {10, 20, 30 ,40};
		
		System.out.println("La longitud de n es: "+n.length);
		System.out.println("La longitud de m es: "+m.length);
		
		System.out.print("\nArray n: ");
		mostrar(n);
		System.out.print("\nArray m: ");
		mostrar(m);
		
		System.out.print("\nArray m invertido: ");
		inverso(m);
		
		// Rellenamos el array n con los números del 1 al 10
		for (int i = 0; i < n.length; i++) {
			n[i] = i+1;
		}
		System.out.print("\nArray n: ");
		mostrar(n);

	}

}
