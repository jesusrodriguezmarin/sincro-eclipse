package arrays.ejercicios;

import java.util.Scanner;

public class E7array10fijadosLeer8leer1y1posicionInsertarDesplazando {

	// Constante para el tamaño del array
	final static int TAM=10;
	
	// Constante para lectura del usuario
	final static int LIM=8;
	
	/**
	 * Procedimiento que muestra todos los elementos del array
	 * @param A - array de números enteros
	 */
	public static void mostrar(int A[]) {
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		// Creamos un array con 10 números almacenados
		int tabla[]= new int[TAM];
		
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Declaramos variable para la posición
		int pos=0;
		
		// Declaramos variable para el elemento
		int num=0;
		
		// Control de excepciones
		try {
			// Leemos 8 números
			System.out.println("Elementos de la tabla: ");
			for (int i=0; i<LIM; i++) {
				System.out.print("Introduce un número ["+(i)+"]: ");
				tabla[i]=sc.nextInt();
			}
			// Pedimos el número a insertar
			System.out.print("Nuevo elemento: ");
			num = sc.nextInt();
			
			
			do {
				// Pedimos la posición donde insertar el número
				System.out.print("Elige la posición: ");
				pos = sc.nextInt();
			} while (pos>LIM || pos<0);
			
		} catch (Exception e) {
			System.err.println("Error en la introducción de datos");
		} finally {
			sc.close();
		}
		
		// Desplazamos los números de posición
		for (int i=TAM-2; i>=pos; i--) {
			tabla[i+1]=tabla[i];
		}
		// Inseramos el número introducido en la posición indicada
		tabla[pos]=num;

		// Mostramos los elementos del array
		mostrar(tabla);
	}

}
