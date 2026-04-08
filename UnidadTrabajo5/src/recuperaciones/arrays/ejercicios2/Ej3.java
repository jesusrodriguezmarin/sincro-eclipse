package recuperaciones.arrays.ejercicios2;

import java.util.Scanner;

public class Ej3 {

	public static void main(String[] args) {
		
		// Pedimos el número de personas al usuario para establecer el array
		Scanner sc = new Scanner(System.in);
		System.out.print("¿Cuantas personas van a participar?: ");
		int personas = sc.nextInt();
		
		// Creamos el array con el número de personas
		double[] alturas = new double[personas];
		
		// Pedimos las alturas por teclado
		double suma = 0;
		
		for (int i = 0; i < alturas.length; i++) {
			System.out.print("Introduce tu altura: ");
			double altura = sc.nextDouble();
			alturas[i] = altura;
			suma += altura;
		}
		// Mostramos la altura media
		double media = suma/alturas.length;
		System.out.println("La altura media es: "+media);
		
		// Mostramos mas altas y mas bajas que la media
		int mayor = 0;
		int menor = 0;
		int igual = 0;
		
		for (int i = 0; i < alturas.length; i++) {
			if (alturas[i] > (media)) {
				mayor++;
			} else if (alturas[i] < (media)) {
				menor++;
			} else {
				igual++;
			}
		}
		System.out.println("Hay: "+mayor+" personas por encima de la media, "+menor+" personas por debajo de la media, y "+igual+" iguales a la media");
		
		sc.close();
	}

}
