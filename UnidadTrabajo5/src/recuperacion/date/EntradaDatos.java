package recuperacion.date;

import java.util.Scanner;

public class EntradaDatos {

	public static void main(String[] args) {
		
		// Pedimos datos al usuario
		Scanner sc = new Scanner(System.in);
		
		// Pedimos nombre y leemos en String
		System.out.print("Introduce tu nombre: ");
		String nombre = sc.nextLine();
		
		// Pedimos edad, leemos en String y parseamos a int para evitar salto de carro
		System.out.print("Introduce tu edad: ");
		int edad = Integer.parseInt(sc.nextLine());
		
		// Pedimos dirección y leemos con String
		System.out.print("Introduce tu dirección: ");
		String direccion = sc.nextLine();
		
		// Mostramos información
		System.out.println(" >Nombre: "+nombre+"\n >Edad: "+edad+"\n >Dirección: "+direccion);

		// Cerramos scanner
		sc.close();
	}

}
