package ejemplos.escaner;

import java.util.Scanner;

public class LeerNum_v1 {

	public static void main(String[] args) {
		// Creamos el lector
		Scanner entrada = new Scanner(System.in);
		
		try {
			// Leemos desde el teclado un número con decimales
			System.out.print("Dime un valor con decimales");
			float num = entrada.nextFloat();
			
			// Mostramos en pantalla el valor introducido
			System.out.println("Has introducido el valor: "+num);
			
		} catch (Exception e) {
			System.err.println("ERROR");
			System.out.println("Debes introducir un número con decimales");
		}
		// Cerramos el lector
		entrada.close();
	
	}

}
