package ejemplos.escaner;

import java.util.Scanner;

public class ContarDe1aN {

	public static void main(String[] args) {
		// Creamos el lector
		Scanner entrada = new Scanner(System.in);
		
		// Pedimos el número y leemos la entrada por el teclado como un número entero
		System.out.print("Dime un valor: ");
		int num = entrada.nextInt();
		
		// Mostramos la cuenta desde el 1 hasta num
		System.out.println("Vamos a contar hasta "+num);
		for (int conta=1; conta<=num; conta++)
			System.out.print(conta+" ");
		
		// Cerramos el lector
		entrada.close();

	}

}
