package recuperaciones.arrays.ejercicios2;

import java.util.Scanner;

public class Ej4 {

	// Constante para los tamaños de arrays
	final static int TAM = 4;

	// Programa principal
	public static void main(String[] args) {

		// Creamos un array de String para almacenar los nombres
		String[] nombres = new String[TAM];

		// Creamos un array de double para almadenar los sueldos
		double[] sueldos = new double[TAM];

		// Pedimos por teclado el nombre y el sueldo de 5 empleados
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 1; i++) {
			System.out.print("Introduce tu nombre: ");
			String nombre = sc.nextLine();
			System.out.print("Introduce tu salario: ");
			double sueldo = Double.parseDouble(sc.nextLine());
			nombres[i] = nombre;
			sueldos[i] = sueldo;
		}
		// Variables para mayor y menor sueldo
		String nombre_mas = nombres[0];
		String nombre_menos = nombres[0];
		double mayor = sueldos[0];
		double menor = sueldos[0];

		for (int i = 1; i < TAM; i++) {
			System.out.print("Introduce tu nombre: ");
			String nombre = sc.nextLine();

			try {
				System.out.print("Introduce tu salario: ");
				double sueldo = Double.parseDouble(sc.nextLine());

				nombres[i] = nombre;
				sueldos[i] = sueldo;

				if (sueldos[i] > mayor) {
					mayor = sueldos[i];
					nombre_mas = nombres[i];
				}

				if (sueldos[i] < menor) {
					menor = sueldos[i];
					nombre_menos = nombres[i];
				}

			} catch (Exception e) {
				System.err.println("ERROR.");
				i--;
			}
		}

		System.out.println("El empleado que mas gana es: " + nombre_mas + " con un salario de : " + mayor);
		System.out.println("El empleado que menos gana es: " + nombre_menos + " con un salario de : " + menor);

		sc.close();
	}

}
