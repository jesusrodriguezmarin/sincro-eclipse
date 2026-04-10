package recuperaciones.arrays.ejerciciosRepaso;

public class Ej3 {

	// Constantes para tamaño y limite de aleatorios
	final static int TAM = 5;
	final static int LIM = 10;
	
	/**
	 * Función que genera un número aleatorio entre 1 y N
	 * @param N - Límite superior del los números a generar
	 * @return {int} un número aleatorio
	 */
	public static int aleatorio (int N) {
		return (int)(Math.random()*N+1);
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos array
		int[] a = new int[TAM];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = aleatorio(LIM);
			for (int j = 0; j < i; j++) {
				if (a[i] == a[j]) {
					System.out.println("--> Repetido");
					break;
				}
			}
		}
		
		System.out.println("\nArray a: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}

}
