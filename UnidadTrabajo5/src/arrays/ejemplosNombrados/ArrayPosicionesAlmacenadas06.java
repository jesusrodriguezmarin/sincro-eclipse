package arrays.ejemplosNombrados;

public class ArrayPosicionesAlmacenadas06 {

	public static void main(String[] args) {
		// Creamos un vector de 10 elementos de tipo entero
		int vector[] = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
		
		// Mostramos el vector
		System.out.print("Vector: ");
		for (int i=0; i<vector.length; i++)
			System.out.print(vector[i]+" ");
		
		// Mostramos los valores almacenados
		System.out.println("\nPrimero: "+vector[0]);
		System.out.println("Último: "+vector[vector.length-1]);
		System.out.println("Segundo: "+vector[1]);
		System.out.println("Penúltimo: "+vector[vector.length-2]);
		System.out.println("Tercero: "+vector[2]);
		System.out.println("Anteprnúltimo: "+vector[vector.length-3]);

	}

}
