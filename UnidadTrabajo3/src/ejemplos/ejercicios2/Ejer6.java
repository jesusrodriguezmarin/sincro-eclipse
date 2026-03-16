package ejemplos.ejercicios2;

import java.util.Scanner;

public class Ejer6 {

	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		// control
		try {
			// declaración de constantes y contadores
			final int cantidadA = 5;
			int edad = 0;
			double altura = 0;
			
			// variables contadoras
			double sumaEdad = 0.0;
			double sumaEstatura = 0.0;
			
			// variables de conteo
			int adultos = 0;
			int altos = 0;
			
			// bucle de lectura y procesamiento
			for (int i = 1; i <= cantidadA; i++) {
				
				// pedimos la edad y validamos edad dentro de la cota 6..35 años
				do {
					System.out.print("Introduce tu edad: ");
					edad = sc.nextInt();
					if (edad < 6 || edad > 35) {
						System.out.println("La edad no es correcta.");
					}
				} while (edad < 6 || edad > 35);
				
				// conteo de adultos mayores de 18 años
				if (edad > 18) {
					adultos ++;
				}
				// suma de las edades correctas introducidas en la cota
				sumaEdad += edad;
			
				//  bucle para pedir la altura dentro de la cota 1..2,20
				do {
					System.out.print("Introduce tu altura: ");
					altura = sc.nextDouble();
				} while (altura < 1.00 || altura > 2.20);
				
				// conteo de altos
				if (altura > 1.75)
					altos ++;
				
				// suma de la estatura
				sumaEstatura += altura;
			}	
			// salto de linea
			System.out.println();
			
			// media de la edad
			System.out.println("La edad media es: "+(double)sumaEdad/cantidadA+" años.");
			
			// media de la altura
			System.out.println("La estatura media es: "+(double)sumaEstatura/cantidadA+" metros.");
			
			// mayores de 18 años segun el contador adultos - si los hubiese
			if (adultos > 0) {
				System.out.println(adultos+" alumnos son mayores de 18 años.");
			} else {
				System.out.println("No hay alumnos mayores de 18 años.");
			}
			
			// mas altos de 1,75 segun el contador altos - si los hubiese
			if (altos > 0) {
				System.out.println(altos+" alumnos son mas altos de 1,75 metros.");
			} else {
				System.out.println("No hay alumnos mas altos de 1,75 metros.");
			}
			
			
		} catch (Exception e) {
			System.err.println("ERROR DE DATOS.");
		} finally {
			// cierre lector
			sc.close();
		}
		
	}

}
