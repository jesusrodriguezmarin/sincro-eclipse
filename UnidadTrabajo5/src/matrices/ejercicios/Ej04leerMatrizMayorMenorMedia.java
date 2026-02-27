package matrices.ejercicios;

import java.util.Scanner;

public class Ej04leerMatrizMayorMenorMedia {

	// Costante para el tamaño de las filas de la matriz
	final static int F=5;
	
	// Costante para el tamaño de las columnas de la matriz
	final static int C=3;
	
	/**
	 * Procedimiento que muestra el menor de los elementos de una matriz
	 * @param M - matriz de números enteros
	 */
	public static void menor(int M[][]) {
		// Inicializamos menor a la primera coordenada  de la matriz
		int num=M[0][0];
		
		for (int f=0; f<M.length; f++) {
			for (int c=0; c<M[f].length; c++) {
				if (num>M[f][c]) {
					num=M[f][c];
				}
			}
		}
		System.out.println("Menor: "+num);
	}
	
	/**
	 * Función que devuelve el mayor de los elementos de una matriz
	 * @param M - matriz de números enteros
	 * @return el elemento de mayor valor de una matriz
	 */
	public static int mayor(int M[][]) {
		// Declaramos e inicializamos al valor de la primera coordenada de la matriz
		int num=M[0][0];
		
		for (int f=0; f<M.length; f++) {
			for (int c=0; c<M[f].length; c++) {
				if (num<M[f][c]) {
					num=M[f][c];
				}
			}
		}
		return num;
	}
	
	/**
	 * Función que devuelve la media de entre todos los elementos de una matriz
	 * @param M - matriz de números enteros
	 * @return la media de los elementos de la matriz
	 */
	public static double obtenerMedia(int M[][]) {
		// Variable para sumar los valores de la matriz
		double suma=0;
		// Contador para dividir suma entre la cantidad de elementos
		double conta=0;
		
		for (int f=0; f<M.length; f++) {
			for (int c=0; c<M[f].length; c++) {
				suma+=M[f][c];
				conta++;
			}
		}
		if (conta!=0)
			return suma/conta;
		return 0;	
	}
	
	/**
	 * Procedimiento para mostrar todos los valores de una matriz
	 * @param M - matriz de números enteros
	 */
	public static void mostrar(int M[][]) {
		for (int f=0; f<M.length; f++) {
			for (int c=0; c<M[f].length; c++) {
				System.out.print(M[f][c]+"\t");
			}
			System.out.println();
		}
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos matriz de 5x3
		int M[][]= new int[F][C];
		
		// Creamos lector 
		Scanner sc = new Scanner(System.in);
		
		// Control de excepciones
		try {
			// Pedimos los elementos al usuario
			System.out.println("Introduce los elementos de una matriz 5x3:");
			for (int f=0; f<M.length; f++) {
				for (int c=0; c<M[f].length; c++) {
					System.out.print("Valor["+f+"]["+c+"]: ");
					M[f][c]=sc.nextInt();
				}
			}
			
		} catch (Exception e) {
			System.err.println(">> ERROR: Tipo de dato no válido.");
		} finally {
			sc.close();
		}
		// Mostramos la matriz
		System.out.println("\nMatriz: ");
		mostrar(M);
		
		// Mostramos el mayor elemento de la matriz
		System.out.println("\nMayor: "+mayor(M));
		
		// Mostramos el menor elemento de la matriz
		menor(M);
		
		// Mostramos la media de los elementos de la matriz
		System.out.println("Media: "+obtenerMedia(M));
		
	}

}
