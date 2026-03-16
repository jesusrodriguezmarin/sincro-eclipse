package arrays.ejercicios;

import java.util.Scanner;

public class E3Leer10mostrarMediaMayorMenorFunciones {

	// Constante para el tamaño del array
	final static int TAM = 10;
	
	/**
	 * Procedimiento que muestra los valores almacenados en un array
	 * @param a - array de números enteros
	 */
	final static void mostrar(int a[]) {
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	/**
	 * Función que devuelve el mayor de los valores almacenados
	 * @param a - array de números enteros
	 * @return - el mayor de los números almacenados en el array
	 */
	public static int mayor(int a[]) {
		int m = a[0];
		for (int i=0; i<a.length; i++) {
			if (m<a[i])
				m=a[i];
		}
		return m;
	}
	
	/**
	 * Función que devuelve el menor de los valores almacenados en un array
	 * @param a - array de números enteros
	 * @return - el menor de los valores almacenados
	 */
	public static int menor(int a[]) {
		int m = a[0];
		for (int i=0; i<a.length; i++) {
			if (m>a[i])
				m=a[i];
		}
		return m;
	}
	
	/**
	 * Función que devuelve el valor medio de todos los valores almacenados
	 * @param a - array de números enteros
	 * @return - el valor medio
	 */
	public static double media(int a[]) {
		double s = a[0];
		for (int i=1; i<a.length; i++) {
			s+=a[i];
		}
		return s/a.length;
	}
	
	// Programa principal
	public static void main(String[] args) {
		// Creamos un array
		int vector[]= new int[TAM];
		
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Control de exepciones
		try {
			// Pedimos los valores
			System.out.println("Introduce: "+TAM+" valires enteros");
			for (int i=0; i<vector.length; i++) {
				System.out.print("Introduce un número: ");
				vector[i]=sc.nextInt();
			}
		} catch (Exception e) {
			System.err.println(">> ERROR: Tipo de dato no válido");
		} finally {
			sc.close();
		}
		
		// Mostramos el array
		System.out.print("Valores de vector: ");
		mostrar(vector);
		
		// Mayor valor almacenado
		System.out.println("El mayor: "+mayor(vector));
		
		// Menor valor almacenado
		System.out.println("El menor: "+menor(vector));
		
		// Media de los valores almacenados
		System.out.println("La media: "+media(vector));

	}

}
