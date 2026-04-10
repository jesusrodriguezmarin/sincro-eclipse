package recuperaciones.arrays.ejerciciosRepaso;

public class Ej2 {

	// Constantes para tamaño de los arrays y limite de los aleatorios
	final static int TAM = 5;
	final static int LIM = 10;
	
	/**
	 * Procedimiento que muestra todos los elementos de un array
	 * @param a - array
	 */
	public static void mostrar (int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	/**
	 * Función que muestra la cantidad de elementos que coinciden entre ambos arrays
	 * @param a - array
	 * @param b - array
	 * @return {int} cantidad de coincidendias
	 */
	public static int encontrar (int[] a, int[] b) {
		int conta = 0;
		
		for (int i = 0; i < TAM; i++) {
			for (int j = 0; j < TAM; j++ ) {
				if (a[i] == b[j]) {
					conta++;
				}
			}
		}
		return conta;
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos el primer array
		int[] a = new int[TAM];
		
		// Creamos el segundo array
		int[] b = new int[TAM];
		
		for (int i = 0; i < TAM; i++) {
			a[i] = (int)(Math.random()*LIM+1);
			b[i] = (int)(Math.random()*LIM+1);
		}
		
		System.out.println("a: ");
		mostrar(a);
		System.out.println("\nb: ");
		mostrar(b);
		
		System.out.println("\nLos arrays a y b tienen en común: "+encontrar(a,b)+" elementos");
	}

}
