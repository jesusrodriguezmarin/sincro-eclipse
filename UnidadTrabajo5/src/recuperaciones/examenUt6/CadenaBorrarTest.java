package recuperaciones.examenUt6;

import java.util.Scanner;

public class CadenaBorrarTest {

	public static void main(String[] args) {
		
		// Creamos una instancia de CadenaBorrar
		CadenaBorrar c = new CadenaBorrar();
		
		// Solicitamos un String por teclado
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un nombre: ");
		
		// Asignamos con setCadena
		c.setCadena(sc.nextLine());
		
		// Mostramos con getCadena
		System.out.println("Tu nombre es: "+c.getCadena());
		System.out.println("En minúsculas: "+c.minusculas());
		System.out.println("En mayúsculas: "+c.mayusculas());
		System.out.println("Invertido: "+c.invertido());
		System.out.println("La longitud es: "+c.longitud());
		System.out.println("Tiene consonantes: "+c.consonantes());
		System.out.println("Tiene vocales: "+c.vocales());
		
		// Pedimos un caracter por teclado
		System.out.print("Introduce un caracter: ");
		char caracter = sc.nextLine().charAt(0);
		
		// Mostramos
		System.out.println("El caracter: "+caracter+" aparece "+c.caracter(caracter)+" veces");
		
		// Pedimos dos caracteres para la sustitucion
		System.out.print("Introduce el viejo caracter: ");
		char viejo = sc.nextLine().charAt(0);
		System.out.print("Introduce el nuevo caracter: ");
		char nuevo = sc.nextLine().charAt(0);
		
		// Mostramos
		System.out.print("El resultado del cambio es: ");
		c.sustituir(viejo, nuevo);
		System.out.println(c.getCadena());
		
		// Solicitamos un caracter a eliminar
		System.out.print("Introduce un caracter a eliminar: ");
		char elim = sc.nextLine().charAt(0);
		
		// Mostramos
		System.out.print("El resultado es: ");
		c.eliminar(elim);
		System.out.println(c.getCadena());
		
		sc.close();
	}

}
