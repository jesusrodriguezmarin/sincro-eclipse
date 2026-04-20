package examen;

import java.util.Scanner;

public class CadenaTest {

	public static void main(String[] args) {

		// Creamos un objeto cadena
		Cadena c = new Cadena();
		
		// Solicitamos una cadena por teclado
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce un nombre: ");
		String nombre = sc.nextLine();
		
		c.setCadena(nombre);
		
		// Mostramos
		System.out.println("\n> Nombre original: "+c.getCadena());
		System.out.println("> Nombre en mayúsculas: "+c.mayusculas());
		System.out.println("> Nombre en minúsculas: "+c.minusculas());
		System.out.println("> Nombre invertido: "+c.invertir());
		System.out.println("> Número de caracteres: "+c.longitud());
		System.out.println("> Número de vocales: "+c.vocales());
		System.out.println("> Número de consonantes: "+c.consonantes());
		
		System.out.print("\nEscribe un caracter: ");
		char car = sc.nextLine().charAt(0);
		
		// Variable para ok
		boolean ok = false;
		
		for (int i = 0; i < nombre.length(); i++) {
			if (nombre.charAt(i) == car) {
				ok = true;
			}
		}
		
		if (ok) {
			c.reemplazar(car, ' ');
			System.out.print("\n> Reemplazamos el caracter '"+car+"' por espacios en blanco: "+c.getCadena());
			
			c.eliminar(' ');
			System.out.print("\n> Eliminamos los espacios en blanco: "+c.getCadena());
		} else {
			System.out.println("\n> No se han encontrado ocurrencias del caracter '"+car+"' en el nombre");
		}
		
		
		
		sc.close();
	}

}
