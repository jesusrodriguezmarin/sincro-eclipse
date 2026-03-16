package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer6maquinaCambio {

	// Procedimiento para calcular el cambio
	static void cambio(int N) {
		int b200, b100, b50, b20, b10, b5, resto;
		// Calculamos el número de billetes de 200
		b200 = N/200;
		resto = N%200;
		// Calculamos el número de billetes de 100
		b100 = resto/100;
		resto %= 100;
		// Calculamos el número de billetes de 50
		b50 = resto/50;
		resto %= 50;
		// Calculamos el número de billetes de 20
		b20 = resto/20;
		resto %= 20;
		// Calculamos el número de billetes de 10
		b10 = resto/10;
		resto %= 10;
		// Calculamos el número de billetes de 5
		b5 = resto/5;
		resto %= 5;
		
		// Visualizamos por pantalla la cuenta de los billetes
		if (b200 > 0)
		System.out.println("Billetes de 200: " + b200);
		if (b100 > 0)
		System.out.println("Billetes de 100: " + b100);
		if (b50 > 0)
		System.out.println("Billetes de 50: " + b50);
		if (b20 > 0)
		System.out.println("Billetes de 20: " + b20);
		if (b10 > 0)
		System.out.println("Billetes de 10: " + b10);
		if (b5 > 0)
		System.out.println("Billetes de 5: " + b5);
		
		System.out.println("Sobran: "+resto+" €");
		}
		public static void main (String[] argv) {
		try {
		
			// Leemos por teclado un número
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime una cantidad (en €): ");
		int cantidad=sc.nextInt();
		sc.close();
		
		// Llamamos al procedimiento
		cambio(cantidad);

		} catch (Exception e) {
		System.out.println("ERROR: El valor introducido no es válido");
		}
	}
}
