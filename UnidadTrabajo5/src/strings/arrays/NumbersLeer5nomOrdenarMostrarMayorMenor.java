package strings.arrays;

import java.util.Scanner;

public class NumbersLeer5nomOrdenarMostrarMayorMenor {

	// Número de elementos del vector
	final static int TOTAL=5;
	
	/**
	 * Procedimiento que muestra todos los elementos de un array
	 * @param array
	 */
	private static void mostrar(int array[]) {
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
	
	/**
	 * Procedimiento que ordena un array de menor a mayor
	 * @param array de números enteros
	 */
	private static void ordenar(int array[]) {
		int aux;
		for (int i=array.length-1; i>=0; i--) {
			for (int j=0; j<i; j++) {
				if (array[j]>array[j+1]) {
					aux=array[j];
					array[j]=array[j+1];
					array[j+1]=aux;
				}
			}
		}
	}
	
	/**
	 * Función que devuelve el mayor de los elementos de un array
	 * @param array de números enteros
	 * @return el mayor de los elementos
	 */
	private static int mayor(int array[]) {
		int res=array[0];
		for (int i=0; i<array.length; i++) {
			if (array[i]>res) {
				res=array[i];
			}
		}
		return res;
	}
	
	/**
	 * Función que devuelve el menor de los elementos de un array
	 * @param array de números enteros
	 * @return el mayor de los elementos
	 */
	private static int menor(int array[]) {
		int res=array[0];
		for (int i=0; i<array.length; i++) {
			if (array[i]<res) {
				res=array[i];
			}
		}
		return res;
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Creamos array
		int[] vector= new int [TOTAL];

		try {
			// Pedimos nombre al usuario 5 números
			for (int i=0; i<TOTAL; i++) {
				System.out.println("Introduce los valores("+TOTAL+") de un array...");
				System.out.print(""+(i+1)+"): ");
				vector[i]=sc.nextInt();
			}
			
		} catch (Exception e) {
			System.err.println(">> ERROR: Tipo de dato no válido.");
		} finally {
			sc.close();
		}
		// Mostramos los valores
		System.out.println("\nArray: ");
		mostrar(vector);
		System.out.println("\nArray ordenado: ");
		ordenar(vector);
		mostrar(vector);
		System.out.println("\nMayor: "+mayor(vector));
		System.out.println("Menor: "+menor(vector));
		
	}

}
