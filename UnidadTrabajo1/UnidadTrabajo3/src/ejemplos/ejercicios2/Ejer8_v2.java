package ejemplos.ejercicios2;

import java.util.Scanner;

public class Ejer8_v2 {

	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		
		// control 
		try {
			// declaración e inicialización de variables 
			// para los límites mayor y menor
			int inferior = 1;
			int superior = 100;
			
			// declaración e inicialización de variable 
			// para nº de intentos/fallos
			int intentos = 0;
			
			// declaración e inicialización de variable boolean en FALSE
			// para mostrar el acierto en TRUE
			boolean acierto = false;
			
			// pedimos que se piense un nº
			System.out.println("Piensa un nº entre 1 y 100 para adivinarlo...");
			
			// paramos el programa y pedimos continuación por teclado
			System.out.print("Escribe ok y pulsa intro para continuar: ");
			
			// bucle de repetición de cálculo binario
			// hasta dar con true
			while (acierto == false) {
				// declaración e inicialización con el cálculo binario
				int num = (inferior + superior) / 2;
				
				// mensajes de comunición para pedir opciones
				System.out.println("Tu nº es "+num+"?");
				System.out.println("Si es correcto pulsa: 1");
				System.out.println("Si "+num+" es MENOR pulsa: 2");
				System.out.println("Si "+num+" es MAYOR pulsa: 3");
				
				// declaramos opcion para registrar y filtar la respuesta
				System.out.print("Introduce la opcion correcta entre 1, 2 y 3: ");
				int opcion = sc.nextInt();
				
				// switch de filtro
				switch (opcion) {
				
				// es igual, mostramos mensaje de genial y pasamos
				case 1: acierto = true; System.out.println("genial");
					break;
				
				// num es menor, tomamos num como limite inferior
				// sumamos 1 intento
				case 2: inferior = num +1; intentos++;
					break;
					
				// num es mayor, tomamos num como limite superior
				// sumamos 1 intento
				case 3: superior = num -1; intentos++;
					break;
				default: System.err.println("No has introducido un nº correcto");
					break;
				}
			}
			// mostramos los fallos
			System.out.println("Hemos necesitado: "+intentos+" intentos");
			
		} catch (Exception e) {
			System.err.println("ERROR. Tipo de dato no válido.");
		}
		
		// cierre de lector
		sc.close();

	}

}
