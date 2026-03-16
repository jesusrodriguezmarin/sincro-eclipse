package arrays.ejercicios;

import java.util.Scanner;

public class E1Leer10MostrarOrdeneInverso {

	final static int TOTAL = 5;
	
	public static void main(String[] args) {
		
		// Creamos el array que almacenará los números por teclado
		int[] vector = new int[TOTAL];
		
		// Leemos los números introducidos por teclado y los almacenamos en vector
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Introduce los números para almacenar");
			for (int i=0; i<vector.length; i++) {
				System.out.print("Introduce un número: ");
				vector[i] = sc.nextInt();
			}
		} catch (Exception e) {
			System.err.println("Error en la introducción de datos");
		} finally {
			sc.close();
		}
		
		// Mostramos los números en el mismo orden en el que se introdujeron
		System.out.println("\nNúmeros (en el orden de introducción): ");
		for (int i=0; i<vector.length; i++) {
			System.out.print(vector[i]+" ");
		}
		
		// Mostramos los números en el orden inverso en el que se introdujeron
		System.out.println("\nNúmeros (en el orden inverso de introducción): ");
		for (int i=vector.length-1; i>=0; i--) {
			System.out.print(vector[i]+" ");
		}	
		
	}

}
