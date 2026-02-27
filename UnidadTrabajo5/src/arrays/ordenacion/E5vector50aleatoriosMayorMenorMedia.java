package arrays.ordenacion;

public class E5vector50aleatoriosMayorMenorMedia {

	// Constante para el tamaño
	final static int TAM=50;
	
	/**
	 * Procedimiento que muestra todos los valores/elementos de un array
	 * @param a - array de números enteros
	 */
	public static void mostrar(int a[]) {
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	/**
	 * Función que devuelve números aleatorios desde 1 hasta N
	 * @param N - límite de rango para los números que se generan
	 * @return - números aleatorios
	 */
	public static int aleatorio(int N) {
		int num = (int)(Math.random()*N+1);
		return num;
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos vector con 50 números aleatorios
		int vector[]= new int[TAM];
		
		// Variables para mayor, menor y media
		int mayor, menor;
		double suma = 0, media = 0;
		
		// Almacenamos los valores en el vector
		for (int i=0; i<vector.length; i++) {
			// Usamos la constante de tamaño TAM también para el límite de rango aleatorio
			vector[i]=aleatorio(TAM);
		}
		
		// Mostramos los valores del array
		System.out.println("Valores: ");
		mostrar(vector);
		
		// Inicializamos mayor y menor al primer valor del array
		mayor = menor = vector[0];
		
		// Corremos el array buscando el mayor y el menor
		for (int i=0; i<vector.length; i++) {
			if (vector[i]>mayor)
				mayor=vector[i];
			if (vector[i]<menor)
				menor=vector[i];
			suma += vector[i];
		}
		media = suma/vector.length;
	
		
		// Mostramos el mayor
		System.out.print("\nMayor valor: "+mayor);
		
		// Mostramos el menor
		System.out.print("\nMenor valor: "+menor);
		
		// Mostramos la media
		System.out.print("\nMedia: "+media);

	}

}
