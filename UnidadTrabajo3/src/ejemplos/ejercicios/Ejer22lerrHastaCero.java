package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer22lerrHastaCero {

	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		// control
		try {
			int num;
			// leemos el primer valor para guardarlo e ir comparando con el condicional de abajo
			System.out.print("Dime el primer valor: ");
			num = sc.nextInt();
			
			// si el nº introducido no es 0
			if (num == 0) {
				System.out.println("Fin");
			} else {
				int mayor, menor;
				mayor = menor = num;
				
				while (num != 0) {
					if (num > mayor)					
						mayor = num;
					if (num < menor)
						menor = num;
					System.out.print("Dime otro valor: ");
					num = sc.nextInt();
				}
				
				// mostramos el mayor y el menor
				System.out.println("Mayor: "+mayor+"\nMenor: "+menor);
				
			}
			
			
		} catch (Exception e) {
			System.err.println("ERROR");
		}
		
		
		// cierre
		sc.close();

	}

}
