package recuperaciones.arrays.ejercicios1;

import java.util.Scanner;

public class Ej5_repaso {

	public static void main(String[] args) {

		// Creamos un array de enteros para rellenar con números pedidos por teclado
		int[] a = new int[5];
		
		Scanner sc = new Scanner(System.in);
		
		try {
			for (int i = 0; i < a.length; i++) {
				System.out.print("Introduce un número: ");
				int num = sc.nextInt();
				a[i] = num;
			}
			
			int mayor = a[0];
			int menor = a[0];
			
			for (int i = 1; i < a.length; i++) {
				if (a[i] > mayor) {
					mayor = a[i];
				}
				if (a[i] < menor) {
					menor = a[i];
				}
			}
			System.out.println("\nEl mayor de los elementos es: "+mayor);
			System.out.println("\nEl menor de los elementos es: "+menor);

			
		} catch (Exception e) {
			System.err.println("Error: Tipo de dato no válido.");
		} finally {
			sc.close();
		}
	}

}
