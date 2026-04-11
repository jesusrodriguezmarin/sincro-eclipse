package recuperaciones.matrices;

import java.util.Scanner;

public class Ej4 {

	// Constante
	final static int TAM = 3;

	public static void main(String[] args) {

		// Creamos una matriz cuadrada
		int[][] m = new int[TAM][TAM];

		Scanner sc = new Scanner(System.in);
		
		try {
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					System.out.print("Matriz ["+i+"]["+j+"]: ");
					m[i][j] = sc.nextInt();
				}
			}
			
			System.out.println("Matriz inicializada: ");
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					System.out.print(m[i][j] + "\t");
				}
				System.out.println();
			}
			
		} catch (Exception e) {
			System.err.println("Error. Tipo de dato no válido.");
		} finally {
			sc.close();
		}
		

	}

}
