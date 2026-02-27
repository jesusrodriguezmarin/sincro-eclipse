package ejemplos.escaner;

import java.util.Scanner;

public class PrecioDescuentoPfinal {

	public static void main(String[] args) {
		// Introducimos lector
		Scanner sc = new Scanner(System.in);
		
		// Pedimos un valor entero precio a aplicar
		try {
			System.out.println("Introduce un precio: ");
			double precio = sc.nextDouble();
			System.out.println("Introduce un decuento: ");
			int desc = sc.nextInt();
			
			// Aplicamos el descuento al precio y mostramos precio final
			double pfinal = precio*(100-desc)/100;
			System.out.println("El precio final es: "+pfinal);	
		} catch (Exception e) {
			System.err.println("ERROR");
		}
		
		sc.close();

	}

}
