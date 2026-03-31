package recuperacion.arrays;

public class MostrarLongitud {

	// Constante para el tamaño del array
	final static int TAM = 10;
	
	/**
	 * Muestra todos los elementos contenidos en un array de números enteros
	 * @param array de números enteros
	 */
	public static void mostrar(int array[]) {
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Generamos un array 
		int a[] = new int[TAM];
		int b[] = {10, 20, 30, 40};
		
		// Mostramos la longitud del array
		System.out.println("La longitud de a es: "+a.length);
		System.out.println("La longitud de b es: "+b.length);
		
		System.out.print("\na: ");
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		
		System.out.print("\nb: ");
		for (int i=0; i<b.length; i++) {
			System.out.print(b[i]+" ");
		}
		
		System.out.print("\nb inverso: ");
		for (int i=b.length-1; i>=0; i--) {
			System.out.print(b[i]+" ");
		}
		
		System.out.print("\nNuevos valores para a: ");
		for (int i=0; i<a.length; i++) {
			a[i]=i+1;
			System.out.print(a[i]+" ");
		}
		
		// Hacemos uso de la función mostrar
		System.out.print("\nA: ");
		mostrar(a);
		System.out.print("B: ");
		mostrar(b);
	}

}
