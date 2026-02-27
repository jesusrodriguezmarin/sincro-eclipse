package arrays.ejemplosNumerados;

import java.util.Scanner;

public class E05 {

	// Constante para el tamaño del array
	final static int TAM = 5;
	
	/**
	 * Procedimiento que muestra todos los valores de un array
	 * @param V - array pasado por parámetro
	 */
	public static void mostrar(int V[]) {
		for (int i=0; i<V.length; i++) {
			System.out.print(V[i]+" ");
		}
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Creamos el array o vector
		int vector[] = new int[TAM];
		
		// Control de excepciones
		try {
			// Pedimos los valores por teclado
			System.out.println("Introduce "+TAM+" valores tipo entero: ");
			for (int i=0; i<vector.length; i++) {
				System.out.print("Posición ["+i+"], valor ["+(i+1)+"]: ");
				vector[i]=sc.nextInt();
			}
			// Mostramos los valores introducidos y almacenados en el array
			System.out.print("Los valores del array son: ");
			mostrar(vector);
		
			// Declaramos la variable para mayor e inicializamos al primer valor del array
			int mayor = vector[0];	
			
			// Calculamos el mayor de los valores del array
			for (int i=0; i<vector.length; i++) {
				if (vector[i]>mayor)
					mayor = vector[i];
			}
			// Mostramos el mayor valor del array
			System.out.print("\nEl mayor valor es: "+mayor);
			
			
		} catch (Exception e) {
			System.err.println(">> ERROR");
		} finally {
			sc.close();
		}

	}

}
