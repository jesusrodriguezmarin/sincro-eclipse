package ejemplos.ejercicios2;

import java.util.Scanner;

public class Ejer4_clase {

	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		
		// control de excepciones
		try {
			// declaración de variable para contar y suma
			int num;
			int sumaP = 0; // sumatorio de nºs positivos
			int contaP = 0; // cantidad de nºs positivos
			int sumaN = 0; // sumatorio de nºs negativos
			int contaN = 0; // cantidad de nºs negativos
			int conta0 = 0; // cantidad de ceros
			
			// pedimos los 10 números
			for (int i = 1; i <= 10; i++) {
				System.out.print("("+i+") Dime un valor: ");
				num = sc.nextInt();
				
				if (num > 0) {
					contaP++;
					sumaP += num;
				} else if (num < 0) {
					contaN++;
					sumaN += num;
				} else {
					conta0++;
				}
			}
			
			// controlamos que no haya division entre 0
			if (contaP > 0)
			// media de nºs positivos
			System.out.println("La Media de positivos es: "+((float)sumaP / contaP));
			
			// controlamos que no haya division entre 0
			if (contaN != 0)
			// media de nºs positivos
			System.out.println("La Media de negativos es: "+((float)sumaN / contaN));
			
			// mostramos cantidad de ceros
			System.out.println("La cantidad de ceros es: "+conta0);
			
		} catch (Exception e) {
			System.err.println("ERROR. Tipo de dato no válido");
		} finally {
			// cerramos lector
			sc.close();
		}

	}

}
