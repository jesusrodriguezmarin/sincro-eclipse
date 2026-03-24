package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer23mediaFinNegativo_v2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// control
		try {
			// variables para realizar el cálculo de la media
			int suma = 0; // variable que utilizaremos para SUMAR los números que introduciremos por teclado
			int conta = 0; // variable que utilizamos para contar los nº introducidos
			
			System.out.print("Introduce un nº entero: ");
			int num = sc.nextInt(); // num es la variable de control
			while (num >= 0) {
				// actualizamos variables para realizar el cálculo
				suma+=num;
				conta++;
				
				// pedimos siguiente nº
				System.out.print("Introduce un nº entero: ");
				num = sc.nextInt();
			}
			// mostramos resultados con un if para que no de errer al dividir entre 0
			if (conta == 0) {
				System.out.println("No has introducido valores para el cálculo");
			} else {
			System.out.println("Suma: "+suma);
			System.out.println("Conta: "+conta);
			System.out.println("Media: "+((float)suma/conta));
						}
		} catch (Exception e) {
			System.err.println("ERROR");
		}
	
		// cierre
		sc.close();

	}

}
