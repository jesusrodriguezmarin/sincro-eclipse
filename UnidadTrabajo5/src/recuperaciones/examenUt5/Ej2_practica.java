package recuperaciones.examenUt5;

import java.util.Scanner;

public class Ej2_practica {

	// Constantes
	final static int TAM = 8;	// Tamaño del array
	final static int LIM = 10;	// Límite superior de los números del array
	
	/**
	 * Genera números enteros aleatorios
	 * @param a - límite superior de los números a generar
	 */
	public static int generar(int a) {
		return (int)(Math.random()*a+1);
	}
	
	/**
	 * Muestra todos los elementos de un array
	 * @param a - array de números enteros
	 */
	public static void mostrar(int a[]) {
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	/**
	 * Busca un número dentro de un array y confirma si se encuentra o no en este
	 * @param a - array de números enteros donde buscar
	 * @param n - número a buscar
	 * @return True si se encuentra, False si no se encuentra
	 */
	public static boolean encontrar(int a[], int n) {
		for (int i=0; i<a.length; i++) {
			if (a[i] == n) {
				return true;
			}
		}
		return false;
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Declaramos un array de números enteros de tamaño TAM
		int array[] = new int[TAM];
		
		// Asignamos valores aleatorios al array con tope LIM y hasta cantidad TAM
		for (int i=0; i<TAM; i++) {
			array[i] = generar(LIM);
		}
		
		// Mostramos el contenido del array
		mostrar(array);
		
		Scanner sc = new Scanner(System.in);
		try {
			// Pedimos un número por teclado para comprobar si se encuentra en el array
			System.out.print("Introduce un número: ");
			int num = sc.nextInt();
			
			if (!encontrar(array, num)) {
				System.out.println("\nEl número: "+num+" no se encuentra en el array.");
				System.out.println("Fin del programa. BYE!");
			} else {
				System.out.println("El número: "+num+" se encuentra en el array.");
				// Solicitamos al usuario otro número por el cual remplazar el anterior
				System.out.print("Introduce un número para reemplazar por el anterior: ");
				int nuevo = sc.nextInt();
				int conta = 0;
				
				// Sustituinos todas las apariciones de num por nuevo
				for (int i=0; i<array.length; i++) {
					if (array[i] == num) {
						array[i] = nuevo;
						conta++;
					}
				}
				
				System.out.println("Se han realizado: "+conta+" reemplazos.");
				System.out.println("Nuevo array: ");
				mostrar(array);
			}
			
		} catch (Exception e) {
			System.err.println("ERROR: Tipo de dato no válido.");	
		} finally {
			sc.close();
		}
		
		
		
	}

}