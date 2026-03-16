package ejemplos.ejercicios2;

import java.util.Scanner;

public class Ejer4 {

	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		
		// control de excepciones
		try {
			// declaración de variable para contar y suma
			int num;
			int conta0 = 0;
			int contaP = 0;
			int contaN = 0;
			int sumaP = 0;
			int sumaN = 0;
			
			System.out.println("Introduce 10 números!");
			System.out.print("Introduce el primer nº: ");
			num = sc.nextInt();
			
			// pedimos los 10 números
			for (int i = 1; i < 10; i++) {
				System.out.print("Introduce otro nº: ");
				num = sc.nextInt();
				if (num == 0) {
					conta0++;
				} else if (num > 0) {
					contaP++;
					sumaP += num;
				} else {
					contaN++;
					sumaN += num;
				}
			}
			
			// mostramos la suma de los números positivos
			System.out.println("La suma de los números positivos es: "+sumaP);
			// mostramos la suma de los números negativos
			System.out.println("La suma de los números negativos es: "+sumaN);
			
			// medias
			double mediaPositivos = sumaP / contaP;
			double mediaNegativos = sumaN / contaN;
			
			// mostramos media de números positivos
			System.out.println("La media de los números positivos es es: "+mediaPositivos);
			
			// mostramos media de números negativos
			System.out.println("La media de los números negativos es: "+mediaNegativos);
			
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
