package ejemplos.ejercicios2;

import java.util.Scanner;

public class Ejer2 {

	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		
		// control
		try {
			// declaración de variable
			int num;
			
			// pedimos nº entre 1 y 99999
			System.out.print("Introduce un nº entre 1 y 99999: ");
			num = sc.nextInt();
			
			// guardamos num original para comparar
			int original = num;
			
			// declaramos variable para invertirlo
			int invertido = 0;
			
			// descomponemos el nº num en u, d y c y lo invertimos
			while (num > 0) {
				int digito = num % 10;	// sacamos el último dígito
				// para situar el primero en invertido
				
				// comenzamos a montar el invertido
				invertido = (invertido * 10) + digito;
				
				// recortamos el num para seguir el bucle hacia 0
				num /= 10;
			}
			// mostramos ambos por pantalla
			System.out.println("El original es: "+original);
			System.out.println("El invertido es: "+invertido);
			
			if (original == invertido) {
				System.out.println("Es capicúa");
				System.out.println(original+" y "+invertido+" son iguales.");
			} else {
				System.out.println("No es capicúa");
				System.out.println(original+" y "+invertido+" son diferentes.");
			}
			
		} catch (Exception e) {
			System.out.println(">> ERROR. Tipo de dato no válido");
		} finally {
			// cerramos lector
			sc.close();
		}
		

	}

}
