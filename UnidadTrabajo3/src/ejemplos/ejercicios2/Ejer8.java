package ejemplos.ejercicios2;

import java.util.Scanner;

public class Ejer8 {

	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		
		// control de excepciones
		try {
			// declaración de variables sobre las que vamos a realizar la busquda
			// inicialmente es una busqueda con limites inf y sup entre 1 y 100 
			int inferior = 1;	// limite inferior
			int superior = 100;	// limite superior
			
			// variable para guardar los números que va generando el programa
			int num;
			
			// variable para guardar el nº de fallos
			int fallos = 0;
			
			// variable boolean para mostrar TRUE cuando lo hayamos encontrado
			// inicializamos en FALSE (aun no lo hemos encontrado)
			boolean encontrado = false;
			
			// variable para guardar la opcion tecleada por el usuario
			int opcion;
			
			// pedimos al usuario que piense en el nº
			System.out.println("Piensa un número entre 1 y 100 para poder adivinarlo...");
			System.out.print("Pulsa 1 para continuar cuando lo hayas pensado: ");
			// variable temporal para parar el programa
			int temporal = sc.nextInt();
			
			// iniciamos el proceso
			if (temporal == 1) {
				// aplicamos bucle con condicion boolean para encontrar el nº
				while (!encontrado) {
					// probamos con el nº que se encuentra a mitad del intervalo
					// busqueda binaria, reducimos en cada paso a la mitad
					num = (superior + inferior) / 2;
					
					// mostramos por pantalla el resultado y preguntamos
					// usamos un menú numérico con 1, 2 y 3
					System.out.println("Tu nº es "+num+"?");
					System.out.println("Pulsa: ");
					System.out.println("Pulsa 1) si "+num+" es el número que has pensado.");
					System.out.println("Pulsa 2) si "+num+" es MENOR que el nº que has pensado.");
					System.out.println("Pulsa 3) si "+num+" es MAYOR que el nº que has pensado.");
					
					// leemos la opción por teclado
					System.out.print("Opción elegida: ");
					opcion = sc.nextInt();
					
					// switch para filtrar la opción del usuario
					switch (opcion) {
						case 1: System.out.println("Encontrado!!!"); 
						// con esta opcion cambiamos a TRUE para salir del bucle
								encontrado = true; break;
						case 2: inferior = num + 1; fallos++; break;
						case 3: superior = num - 1; fallos++; break;

						default: System.out.println("La opcion tecleada es incorrecta."); break;
					}	
				}
			}
			// finalmente mostramos el nº de fallos
			System.out.println("El nº de intentos fallidos ha sido: "+fallos);
			
		} catch (Exception e) {
			System.err.println("ERROR. Tipo de datos no válido");
		} finally {
			// cierre lector
			sc.close();
		}
	
	}

}
