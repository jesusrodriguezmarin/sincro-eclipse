package ejemplos.escaner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Introduce2numEnteros_v3 {

	public static void main(String[] args) {
		// Introducimos lector
		Scanner sc = new Scanner(System.in);
		try {
			// Pedimos 2 números enteros
			System.out.println("Introduce dos valores enteros...");
			System.out.print("Introduce el primer número entero: ");
			int num1 = sc.nextInt();
			System.out.print("Introduce el segundo número entero: ");
			int num2 = sc.nextInt();
		
			// aplicamos las operaciones con los datos recibidos y mostramos en pantalla
			System.out.println(num1+" + "+num2+" es igual a: "+(num1+num2));
			System.out.println(num1+" - "+num2+" es igual a: "+(num1-num2));
			System.out.println(num1+" * "+num2+" es igual a: "+(num1*num2));
			System.out.println(num1+" / "+num2+" es igual a: "+(num1/num2));
			System.out.println(num1+" % "+num2+" es igual a: "+(num1%num2));
		} catch (InputMismatchException i) {
			System.err.println("ERROR!!! tipo de dato no válido");
		} catch (ArithmeticException a) {
			System.err.println("RECUERDA!!! no puedes dividir entre 0");
		}
		// 	Cerramos lector
		sc.close();

	}

}
