package recuperaciones.arrays.ejercicios1;

import java.util.Scanner;

public class Ej1_repaso {

	// Constante
	final static int TAM = 10;
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos un array
		int[] numeros = new int[TAM];
		
		// Pedimos números por teclado para rellenar un array de enteros
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce "+TAM+" números enteros para almacenar en el array");
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(" > Introduce un número: ");
			int n = sc.nextInt();
			numeros[i] = n;
		}
		
		System.out.println("\nEl array resultante según las introducciones es: ");
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i]+" ");
		}
		
		System.out.println("\nEl array invertido es: ");
		for (int i = numeros.length-1; i >=0; i--) {
			System.out.print(numeros[i]+" ");
		}
		sc.close();
	}

}
