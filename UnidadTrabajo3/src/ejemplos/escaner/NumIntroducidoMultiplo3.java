package ejemplos.escaner;

import java.util.Scanner;

public class NumIntroducidoMultiplo3 {

	// Leer un número y decir si es multiplo de 3
	public static void main(String[] args) {
		// Introducimos el lector
		Scanner sc = new Scanner(System.in);
		int num;
		
		try {
		// Pedimos un valor entero
		System.out.println("Dime un valor entero: ");
		num = sc.nextInt();
		
		// 	Comprobamos si el número es multiplo de 3
		if (num%3==0)
			System.out.println(num+" es multiplo de 3");
		else
			System.out.println(num+"  no es multiplo de 3");
				
	} catch (Exception e){
		System.err.println("ERROR");
	}
		sc.close();		
	}

}
