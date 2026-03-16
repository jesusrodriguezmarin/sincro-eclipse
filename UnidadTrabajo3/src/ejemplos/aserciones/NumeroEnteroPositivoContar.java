package ejemplos.aserciones;

import java.util.Scanner;

public class NumeroEnteroPositivoContar {

	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		
		// controlamos errores
		try {
			// declaracion de variable para pedir
			int num;
			
			// pedimos número entero positivo			
			System.out.print("Introduce un número entero posotivo: ");
			num = sc.nextInt();
			
			// contamos
			if (num > 0) {
				for (int conta = 3; conta <= num; conta += 2)
					System.out.println(conta+" ");
			} else {
				System.out.println("No has introducido un balor positivo");
			}
			// mostramos desde 3 al número introducido
		} catch (Exception e) {
			System.err.println("ERROR");
		} finally {
			// cierre lector
			sc.close();
		}					

	}

}
