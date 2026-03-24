package ejemplos.RepasoUt3;

import java.util.Scanner;

public class MediaNumerosPositivosNegativosYceros {

	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		// control
		try {
			// declaración de variable para los números a pedir
			int num;
			
			// declaración e inicialización de variable para
			// números positvos, negativos y cantidad de ceros
			int positivo = 0, negativo = 0, cantidadCeros = 0;
			
			// declaramos variables para sumar los números
			double sumaP = 0;
			double sumaN = 0;
			
			// pedimos los 10 números
			for (int i = 1; i <= 10; i++) {
				System.out.print("Introduce un número: ");
				num = sc.nextInt();
				
				// positivo
				if (num > 0) {
					positivo++;
					sumaP += num;
				} else if (num < 0) {
					negativo++;
					sumaN += num;
				} else {
					cantidadCeros++;
				}
			}
			
			// declaración e inicialización de variable para la media
			double mediaP = sumaP / positivo;
			double mediaN = sumaN / negativo;
			
			// mostramos los resultados
			
			if (positivo > 0)
				System.out.println("La media de los positivos es: "+mediaP);
			else 
				System.out.println("No has introducido números positivos");
			
			if (negativo > 0)
				System.out.println("La media de los negativos es: "+mediaN);
			else
				System.out.println("No has introducido números negativos");
			
			if (cantidadCeros > 0)
				System.out.println("La cantidad de ceros es: "+cantidadCeros);
			else
				System.out.println("No has introducido ceros.");
			
			
		} catch (Exception e) {
			System.err.println("ERROR. Dato no válido.");
		} finally {
			// cerramos lector
			sc.close();
		}
		
	}

}
