package ejemplos.entero;

import java.util.Scanner;

public class EnteroEjercicioFinal {

	public static void main(String[] args) {
		// creamos un nuevo objeto
		Entero num = new Entero();
		
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		
		// control de excepciones
		try {
			System.out.print("Dime un número entero: ");
			num.setEntero(sc.nextInt());
			
		} catch (Exception e) {
			System.out.println(">> ERRER. Tipo de dato no válido.");
		} finally {
			sc.close();
		}
		
		// hacemos uso de los métodos creados en la clase Entero
		System.out.println("\nNúmero: "+num.getEntero());
		System.out.println("Doble: "+num.doble());
		System.out.println("Triple: "+num.triple());
		System.out.println("Mitad: "+num.mitad());
		System.out.println("Elevado a 0: "+num.potencia(0));
		System.out.println("Elevado a 1: "+num.potencia(1));
		System.out.println("Elevado a 2: "+num.potencia(2));
		System.out.println("Elevado a 3: "+num.potencia(3));
		
		if (num.esPar())
			System.out.println("Es un nº par");
		else
			System.out.println("Es un nº impar");
		
		if (num.esPrimo())
			System.out.println("Es un nº primo");
		else
			System.out.println("No es un nº primo");
		
		System.out.println("Conversión a double: "+num.toDouble());

	}

}
