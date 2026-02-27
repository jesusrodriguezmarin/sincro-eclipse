package ejemplos.ejercicios2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones {

	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
				
		// control de excepciones, especifica y general
		try {
		// declaración de variable para ejemplo
		int num;
				
		// pedimos un nº hasta que este entre 1..999
		do {
			System.out.print("Introduce un nº entre 1 y 999: ");
			num = sc.nextInt();
		} while (num < 1 || num > 999);
		
		// declaramos e inicializamos a 0
		int valor = 0;
		System.out.println(num/valor);	// excepcion de division entre 0
		System.out.println("hola");		// No se llega a ejecutar
			
		// control de excepcion escpecífica de division
		} catch (InputMismatchException ime) {
			System.err.println(">> ERROR: Tipo de dato no válido.");
					
		// control de excepcion general para string o cualquier otra
		} catch (Exception e) {
			System.err.println(">> Se ha producido una excepcion distinta.");
		
		// para seguir despues de los catch
		} finally {
			// cierre
			sc.close();
		}

	}

}
