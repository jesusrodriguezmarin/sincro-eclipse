package ejemplos.escaner;

import java.util.Scanner;

public class EscanerMayor3 {

	public class funcionMayorTres {

		/**
		 * Función que devuelve el mayor de tres números pasados por parámetro
		 * @param x - número entero
		 * @param y - número entero
		 * @param z - número entero
		 * @return el mayor de tres números enteros
		 */
		public static int mayor(int x, int y, int z) {
			if (x>=y && x>=z) {
				return x;
			} else if (y>=x && y>=z) {
				return y;
			} else
				return z;
		}
		
		public static void main(String[] args) {
			// Creamos el lector
			Scanner sc = new Scanner(System.in);
				int num1;
				int num2;
				int num3;
				
				try {
					// Pedimos un valor de tipo entero
					System.out.print("Dime un valor tipo entero: ");
					num1 = sc.nextInt();
					System.out.print("Dime un valor tipo entero: ");
					num2 = sc.nextInt();
					System.out.print("Dime un valor tipo entero: ");
					num3 = sc.nextInt();
					
				} catch (Exception e) {
					num1 = 0;
					num2 = 0;
					num3 = 0;
					System.out.print("Puede que no hayas introducido un valor entero");
				}
				
				System.out.println(mayor(num1, num2, num3));
			// Cerramos el lector
			sc.close();

		}

	}
	
}

