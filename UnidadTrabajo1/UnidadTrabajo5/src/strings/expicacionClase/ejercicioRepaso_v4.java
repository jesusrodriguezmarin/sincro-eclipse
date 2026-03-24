// Función que recorra una cadena String y nos devuelva 
// la posición del primer espacio

package strings.expicacionClase;

import java.util.Scanner;

public class ejercicioRepaso_v4 {
	
	public static void main(String[] args) {
		
		// Pedimos al usuario
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime tu nombre: ");
		String nombre = sc.nextLine();
		sc.close();
		
		// Sacamos la posición del espacio directamente con .indexOf(' ');
		int pos = nombre.indexOf(' ');	// Asignamos en una variable
		
		// Condicionamos para mostrar el mensaje
		if (pos==1) {
			System.out.println("Tenemos una inicial");
		} else {
			System.out.println("Tenemos un nombre");
		}
	}

}
