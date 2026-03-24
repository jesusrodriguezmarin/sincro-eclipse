package arrays.ejemplosNombrados;

import java.util.Scanner;

public class ArrayIntroduce5numeros02 {

	// Creamos una constante fuera del main
	// le ponemos static para poder usar en el main
	final static int TAM = 5;
	
	public static void main(String[] args) {
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		try {
			// Declaración y creación del array
			int numeros[] = new int[TAM];
			
			// Leemos los números 
			for (int i=0; i<TAM; i++) {
				System.out.print("Dime un número: ");
				numeros[i] = sc.nextInt();
			}
			
			// Mostramos los números introducidos en el mismo orden
			System.out.print("Números (mismo orden): ");
			for (int i=0; i<TAM; i++) 
				System.out.print((numeros[i]+" "));
						
			// Mostramos los nº introducidos en orden inverso
			System.out.print("\nNúmeros (orden inverso): ");
			for (int i=TAM-1; i>=0; i--) 
				System.out.print(numeros[i]+" ");
						
			// Mostramos el primer y último nº
			System.out.println("\nEl primer valor: "+numeros[0]);
			System.out.println("El último valor: "+numeros[TAM-1]);
			
			
		} catch (Exception e) {
			System.err.println(">> ERROR: No has introducido un tipo de datos válido");
		} finally {
			sc.close();
		}

	}

}
