package ejemplos.escaner;

import java.util.Scanner;

public class LeerNum_v2 {

	public static void main(String[] args) {
		// Creamos el lector
		Scanner sc = new Scanner(System.in);
			int num;
			
			try {
				// Pedimos un valor de tipo entero
				System.out.print("Dime un valor tipo entero: ");
				num = sc.nextInt();
				
			} catch (Exception e) {
				num = 0;
			}
			
			if (num == 0)
			System.out.print("Puede que no hayas introducido un valor entero");
		
		// Cerramos el lector
		sc.close();
		

	}

}
