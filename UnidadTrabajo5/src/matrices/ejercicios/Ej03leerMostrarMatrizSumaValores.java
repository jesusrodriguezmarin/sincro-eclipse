package matrices.ejercicios;

import java.util.Scanner;

public class Ej03leerMostrarMatrizSumaValores {

	// Constante para el número de filas de la matriz
	final static int F=3;
	
	// Constante para el número de columnas de la matriz
	final static int C=4;
	
	/**
	 * Procedimiento que muestra los elementos de una matriz
	 * También muestra la suma de cada fila
	 * @param M - matriz de números enteros
	 */
	public static void mostrar(int M[][]) {
		// Variable para sumar las filas
		int suma;
		// Recorremos la fila
		for (int f=0; f<M.length; f++) {
			// Ponemos contador a cero
			suma=0;
			// Recorremos las columnas respecto a la fila
			for (int c=0; c<M[f].length; c++) {
				// Imprimimos
				System.out.print(M[f][c]+"\t");
				// Realizamos suma de la fila
				suma+=M[f][c];
			}
			// Imprimimos la suma
			System.out.println("--> Suma:"+suma);
		}
	}
	
	// Programa pricipal
	public static void main(String[] args) {
		
		// Creamos una matriz 3x4
		int M[][]= new int[F][C];
		
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Control de excepciones
		try {
			System.out.println("Introduce los valores de una matriz 3x4: ");	
			for (int f=0; f<F; f++) {
				for (int c=0; c<C; c++) {
					System.out.print("Valor["+f+"]["+c+"]: ");
					M[f][c]=sc.nextInt();
				}
				
			}
			
		} catch (Exception e) {
			System.err.println(">> ERROR: Tipo de dato no válido.");
		} finally {
			sc.close();
		}
		// Mostramos matriz
		System.out.println("\nMatriz:");
		mostrar(M);
		
	}

}
