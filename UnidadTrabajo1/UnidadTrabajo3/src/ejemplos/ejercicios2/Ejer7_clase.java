package ejemplos.ejercicios2;

import java.util.Scanner;

public class Ejer7_clase {

	// declaramos un final para el limite superior
	final static int LIM = 100;
	
	public static void main(String[] args) {
		
		// abrimos scaner
		Scanner sc = new Scanner(System.in);
		
		try {
			// declaracion de variables
			int N; // nº que hay que adivinar
			int num; // nº que introduce el usuario
			int intentos; // nº de intentos para adivinar N
			
			// generamos el nº aleatorio que el usuario debe acertar
			N = (int)(Math.random()*LIM+1);
			
			// pedimos números al usuario
			System.out.println("Adivina un número entre 1 y"+LIM+"...");
			System.out.print("Dime un valor: ");
			num = sc.nextInt();
			
			// inicializamos a 1 porque ya hemos pedido uno por scaner
			// que no ha sido contado aún en el contador del bucle
			intentos = 1;
			
			while (num != N) {
				if (num < N)
					System.out.println(num+" es menor que el valor que debes adivinar");
				else
					System.out.println(num+" es mayor que el valor que debes adivinar");
				
				// incrementamos
				intentos++;
				
				System.out.print("Dime un valor: ");
				num = sc.nextInt();
			}
			
			// si llegamos aqui es porque hemos acertado el nº
			System.out.println("Acertasteeeeeee!!!");
			System.out.println(intentos+" intentos.");
			
			
		} catch (Exception e) {
			System.err.println("ERROR. Dato no válido.");
		} finally {
			sc.close();
		}
		
	}

}
