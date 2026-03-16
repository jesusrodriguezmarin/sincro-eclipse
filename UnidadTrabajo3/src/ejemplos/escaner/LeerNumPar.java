package ejemplos.escaner;

import java.util.Scanner;

public class LeerNumPar {

	// Leer un número y decir si es par o impar
	public static void main(String[] args) {
		// Creamos el lector
		Scanner sc = new Scanner(System.in);
		int  num;
		
	
		// Pedimos un valor tipo entero
		System.out.println("Dime un valor tipo entero");
		num = sc.nextInt();
		
		// indicamos si el número es par o impar
		if (num%2==0)
			System.out.println(num+" es PAR");
		else
			System.out.println(num+" es IMPAR");
		
		sc.close();

	}

}
