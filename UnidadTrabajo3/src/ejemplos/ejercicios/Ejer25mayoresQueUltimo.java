package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer25mayoresQueUltimo {

	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		// control
		try {
			int errores = 0;
			
			System.out.print("Dime un valor: ");
			int num = sc.nextInt();
			
			int ultimo = num;
			
			while (num != 0) {
				System.out.print("Dime un valor: ");
				num = sc.nextInt();
				if (num != 0) {
					if (num <= ultimo) {
						System.out.println("El valor introducido es menor que el anterior.");
						System.out.println("Debes introducir un valor mayor que: "+ultimo);
						errores++;
					} else 
						ultimo = num;
				}
			}
			System.out.println("FIN");
			System.out.println("Errores cometidos: "+errores);
			
		} catch (Exception e) {
			System.err.println("ERROR");
		}
		
		//cierre
		sc.close();

	}

}
