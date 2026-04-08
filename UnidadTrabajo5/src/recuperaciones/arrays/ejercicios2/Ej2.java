package recuperaciones.arrays.ejercicios2;

import java.util.Scanner;

public class Ej2 {

	public static void main(String[] args) {
		
		// Creamos un array de números enteros
		int[] a = new int[10];
		
		// Pedimos los números al usuario 
		Scanner sc = new Scanner(System.in);

		double pos = 0;
		double neg = 0;
		int cn = 0;
		int cp = 0;
		
		for (int i = 0; i < a.length; i++) {
			System.out.print("Introduce un número entero: ");
			int n = sc.nextInt();
			a[i] = n;
			
			if (n < 0) {
				neg += n;
				cn++;
			} else if (n > 0) {
				pos += n;
				cp++;
			}
		}

		if (cn == 0) {
			System.out.println("No se han introducido números positivos.");
		} else {
			System.out.println("La media de los positivos almacenados en el array es: "+pos/cp);
			
		}
		
		if (cp == 0) {
			System.out.println("No se han introducido números negativos.");
		} else {
			System.out.println("La media de los negativos almacenados en el array es: "+neg/cn);
			
		}
		sc.close();
	}

}
