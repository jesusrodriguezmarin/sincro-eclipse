package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer21menorMayor10 {

	// 1.TAREA declaramos la constante fuera del main con static porque es para llamar en el main
	final static int total = 5; // cantidad total de números que vamos a leer por teclado 

	
	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		// Leemos los números
		
		// control
		try {
			// 2. TAREA pedimos los valores
			System.out.println("Introduce "+total+" valores por teclado...");
			int num, mayor, menor;
			
			// leemos el primer valor para guardarlo e ir comparando con el condicional de abajo
			System.out.print("Dime el primer valor: ");
			mayor = menor = sc.nextInt();
				
			
			for (int i = 1; i < total; i++) {
				System.out.print("Dime un valor: ");
				num = sc.nextInt();	
				
				// condicion de mayor y menor
				if (num > mayor)					
					mayor = num;
				if (num < menor)
					menor = num;
				}
				System.out.println("Mayor: "+mayor);
				System.out.println("Menor: "+menor);
				
			
		} catch (Exception e) {
			System.err.println(">> ERROR!. El tipo de dato introducido no es correcto.");
		}
		
		// cierre lector
		sc.close();
	}

}
