package recuperaciones.arrays.ejercicios2;

import java.util.Scanner;

public class Ej6 {

	// Constante para el tamaño del array
	final static int TAM = 10;
	
	//Programa principal
	public static void main(String[] args) {
		
		// Creamos un array de números en coma flotante {double}
		double[] a = new double[TAM];

		Scanner sc = new Scanner(System.in);
		
		// Variable suma para la media
		double suma = 0;
		
		// Variables contadoras
		int aprobado = 0;
		int suspenso = 0;
		
		System.out.print("Introduce nota: ");
		double n = sc.nextDouble();
		a[0] = n;
		suma += n;
		
		if (n >= 5)
			
			aprobado++;
		else 
			suspenso++;
		
		// Variables para sacar la nota alta y la nota baja
		double baja = a[0];
		double alta = a[0];
		
		
		for (int i = 1; i < a.length; i++) {
			System.out.print("Introduce nota: ");
			n = sc.nextDouble();
			a[i] = n;
			suma += n;
			
			if (n >= 5)
				aprobado++;
			else 
				suspenso++;
			
			if (a[i] < baja) {
				baja = a[i];
			}
			
			if (a[i] > alta) {
				alta = a[i];
			}
		}
		System.out.println("La nota media es: "+(suma/a.length));
		System.out.println("La nota mas baja es: "+baja);
		System.out.println("La nota mas alta es: "+alta);
		System.out.println("El número de aprobados es: "+aprobado+" alumnos.");
		System.out.println("El número de suspensos es: "+suspenso+" alumnos.");
		sc.close();
	}

}
