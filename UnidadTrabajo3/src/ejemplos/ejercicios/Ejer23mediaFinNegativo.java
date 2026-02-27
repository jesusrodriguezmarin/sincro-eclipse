package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer23mediaFinNegativo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// control de excepciones
		try {
			int num;
			float suma = 0; // variable que utilizaremos para SUMAR los números que introduciremos por teclado
			int conta = 0; // variable que utilizamos para contar los nº introducidos
			
			// pedimos numeros hasta introducir un valor negativo
			do {
				System.out.print("Introduce un nº entero: ");
				num = sc.nextInt();
		
				// actualizamos variables para realizar el cálculo
				if (num >= 0) {
					suma += num;
					conta++;
				}
			} while (num >= 0);
			
			// mostramos resultados con un if para que no de errer al dividir entre 0
			if (conta == 0) {
				System.out.println("No has introducido valores para el cálculo");
			} else {
			System.out.println("Suma: "+suma);
			System.out.println("Conta: "+conta);
			System.out.println("Media: "+(suma/conta));
			}
			
		} catch (Exception e) {
			System.err.println("ERROR");
		}
	
		// cierre de lector
		sc.close();

	}

}
