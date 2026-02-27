package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer26entre_100y100 {

	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		// control
		try {
			int num, mayor, menor;
			
			// pedimos un número hasta que se encuentre dentro del rango
			do {
				System.out.print("Dime un número: ");
				num = sc.nextInt();
			} while (num < -100 || num > 100);
			
			// inicializamos mayor y menor con el valor del primer número leido dentro del rango
			mayor = menor = num;
			
			// leemos números hasta que se teclee cero
			while (num != 0) {
				// si el número está entre -100 y 100
				if (num >= -100 && num <= 100) {
					if (num > mayor)
						mayor = num;
					if (num < menor)
						menor = num;
				} else {
					System.out.println("El nº introducido no está entre -100..100");
				}
				System.out.print("Dime otro número: ");
				num = sc.nextInt();
			}
			
			// mostramos por pantalla el menor y mayor de los números introducidos
			System.out.println("Mayor número introducido: "+mayor);
			System.out.println("Menor número introducido: "+menor);
			
			// declaramos y calculamos la media e imprimimos
			double media = (menor + mayor) / 2.0;
			System.out.println("Media = ("+menor+" + "+mayor+") / 2 = "+media);
			
		} catch (Exception e) {
			System.err.println(">>> ERROR! No has introducido un valor válido");
		}
			
		// cierre
		sc.close();

	}

}
