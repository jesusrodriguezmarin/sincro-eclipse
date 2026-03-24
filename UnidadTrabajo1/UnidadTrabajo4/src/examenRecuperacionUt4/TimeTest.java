package examenRecuperacionUt4;

import java.util.Scanner;

public class TimeTest {

	public static void main(String[] args) {
		
		// Pedimos la hora por teclado
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Introduce un valor entero: ");
			//int n1 = sc.nextInt();
			System.out.print("Introduce otro valor entero: ");
			//int n2 = sc.nextInt();
			
		} catch (Exception e) {
			System.err.println(">> ERROR. Tipo de dato no válido");
		} finally {
			sc.close();
		}
		
		// Creamos objeto
		Time t1 = new Time();
		
		// Llamamos isValid para validar y mostramos
		if (t1.isValid()) {
			System.out.println("La hora "+t1.toString()+" es correcta");
		} else {
			System.out.println(">> No es una hora correcta.");
		}

	}

}
