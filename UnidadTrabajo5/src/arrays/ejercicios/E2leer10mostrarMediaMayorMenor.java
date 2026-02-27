package arrays.ejercicios;

import java.util.Scanner;

public class E2leer10mostrarMediaMayorMenor {
	
	// Constante para el tamaño
	final static int TAM = 5;
	
	// Programa principal
	public static void main(String[] args) {	

		// Creamos el lector
		Scanner sc = new Scanner(System.in);
		
		// Creamos el array
		int[] v = new int[TAM];
		
		// Declaración de variables para los cálculos
		double suma;
		int mayor;
		int menor;
		
		// Control de excepciones
		try {
			// Pedimos los números para almacenar en v
			System.out.println("Introduce: "+TAM+" números enteros...");
			for (int i=0; i<v.length; i++) {
				System.out.print("Introduce un número "+(i+1)+" : ");
				v[i] = sc.nextInt();
			}
			
		} catch (Exception e) {
			System.err.println(">> ERROR: Tipo de dato no válido");
		} sc.close();
		
		// Inicializamos todas las variables al primer valor del array
		suma = menor = mayor = v[0];
		System.out.print("Valores procesados: "+v[0]+" ");
		
		// Recorremos el resto del vector sin la posicióon 0
		for (int i=1; i<TAM; i++) {
			System.out.print(v[i]+" ");
			// Calculamos la media
			suma += v[i];
			
			// Calculamos el mayor
			if (mayor<v[i])
				mayor = v[i];
			
			// Calculamos el menor
			if (menor>v[i])
				menor = v[i];
		}
		double media = suma/TAM;
		
		// Mostramos la media
		System.out.println("La media es: "+media);
		
		// Mostramos el mayor valor
		System.out.println("El mayor es: "+mayor);
		
		// Mostramos el menor valor
		System.out.println("El menor es: "+menor);
	}

}
