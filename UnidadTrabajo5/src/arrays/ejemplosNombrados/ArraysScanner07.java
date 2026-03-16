package arrays.ejemplosNombrados;

import java.util.Scanner;

public class ArraysScanner07 {
	
	final static int CANT = 5;

	public static void main(String[] args) {
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		try {
			// Declaramos y creamos el array
			int array[] = new int[CANT];
			
			// Pedimos los valores
			System.out.println("Introduce "+CANT+" valores de tipo entero...");
			for (int i=0; i<array.length; i++) {
				System.out.print("Valor["+(i+1)+"]: ");
				array[i] = sc.nextInt();
			}
			
			// Visualizamos los valores
			System.out.println("\nValores introducidos por teclado:");
			for (int i=0; i<array.length; i++) {
				System.out.print(array[i]+" ");
			}
				
			// Mostramos el mayor valor introduido
			int mayor=array[0];		// Mayor toma el valor del primer puesto del array 0
			
			// Ahora i empieza a recorrer el array desde la segunda posicion 1
			for (int i=1; i<array.length; i++) {
				// Mayor va tomando el mayor valor de cada posicion
				if (mayor<array[i])
					mayor=array[i];
			}
			
		} catch (Exception e) {
			System.err.println(">> ERROR: Has introducido un valor incorrecto");
		} finally {
			sc.close();
		}

	}

}
