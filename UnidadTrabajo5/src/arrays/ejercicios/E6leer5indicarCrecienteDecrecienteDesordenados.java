package arrays.ejercicios;

import java.util.Scanner;

public class E6leer5indicarCrecienteDecrecienteDesordenados {

	// Constante para el tamaño del array
	final static int TAM=5;
	
	public static void main(String[] args) {
		
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Creamos el array/vector
		int vector[]= new int[TAM];
		
		// Control excepciones
		try {
			System.out.println("Introduce: "+TAM+" números...");
			
			// Pedimos los valores
			for (int i=0; i<vector.length; i++) {
				System.out.print("Introduce un valor: ");
				vector[i]=sc.nextInt();
			}	
		} catch (Exception e) {
			System.err.println(">> ERROR: Tipo de dato no válido");
		} finally {
			sc.close();
		}
		// Creamos variables booleanas para creciente y decreciente
		// Inicializamos a false ya que aún no hemos comprobado si alguna es correcta TRUE
		boolean creciente = false;
		boolean decreciente = false;
		
		// Recorremos el vector para asignar TRUE o FALSE
		// El recorrido es hasta length-1 porque la comparación llega hasta i+1 (para no sobrepasar el límite)
		for (int i=0; i<vector.length-1; i++) {
			if (vector[i]>vector[i+1])
				decreciente = true;
			
			if (vector[i]<vector[i+1])
				creciente = true;
		}
		
		// Comprobamos si son crecientes o decrecientes
		
		if (creciente==true && decreciente==false)
			System.out.println("La serie es creciente.");
		
		if (creciente==false && decreciente==true)
			System.out.println("La serie es decreciente.");
		
		if (creciente==true && decreciente==true)
			System.out.println("La serie está desordenada.");
		
		if (creciente==false && decreciente==false)
			System.out.println("Todos los elementos son iguales.");

	}

}
