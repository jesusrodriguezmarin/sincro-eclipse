package ejemplos.escaner;

import java.util.Scanner;

public class PruebaEscaner {

	public static void main(String[] args) {
		// Crear el lector del teclado
		Scanner teclado = new Scanner(System.in);
		
		// Se pide un dato al usuario
		System.out.println("Por favor, dime tu nombre: ");
		
		// Se lee el nombre con next.line() que retorna String
		String nombre = teclado.nextLine();
		
		// Trabajamos con el dato
		System.out.println("Te llamas "+nombre);
		
		// Trabajamos el dato con otro print
		System.out.print("Bienvenido "+nombre+"Por favor, dime tu edad: ");
		
		// Se lee y se guarda la edad con nextInt()
		int edad = teclado.nextInt();
		System.out.println("En 10 años tendras "+(edad+10)+" años");
		
		// Le pedimos la nota media
		System.out.print("Dime tu nota media: ");
		float nota = teclado.nextFloat();
		
		System.out.println(nombre+"Tu nota media es:"+nota);
		
		// Cerramos el lector
		teclado.close();
	}

}
