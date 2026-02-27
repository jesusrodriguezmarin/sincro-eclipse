package ejemplos.escaner;

import java.util.Scanner;

public class Introduce2numEnteros_v1 {

	public static void main(String[] args) {
		// Introducimos lector
		Scanner sc = new Scanner(System.in);
		try {
			// Pedimos 2 números enteros
			System.out.print("Introduce número entero: ");
			int num1 = sc.nextInt();
			System.out.print("Introduce otro número entero: ");
			int num2 = sc.nextInt();
		
			// aplicamos las operaciones con los datos recibidos y mostramos en pantalla
			System.out.println(num1+" + "+num2+" es igual a: "+(num1+num2));
			System.out.println(num1+" - "+num2+" es igual a: "+(num1-num2));
			System.out.println(num1+" * "+num2+" es igual a: "+(num1*num2));
			System.out.println(num1+" / "+num2+" es igual a: "+(num1/num2));
			System.out.println(num1+" % "+num2+" es igual a: "+(num1%num2));
		} catch (Exception e) {
			System.err.println("ERROR!!! tipo de dato no válido");
		}
		sc.close();

	}

}
