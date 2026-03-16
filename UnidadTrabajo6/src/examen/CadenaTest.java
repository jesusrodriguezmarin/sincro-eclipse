package examen;

import java.util.Scanner;

public class CadenaTest {

	public static void main(String[] args) {

		// Pedimos un nombre por teclado
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un nombre: ");
		String n = sc.nextLine();
		
		// Creamos una instancia Cadena
		Cadena c = new Cadena(n);
		
		// Mostramos el nombre
		System.out.println("\n> Nombre original: "+c.getCadena());
		
		// Mostramos el nombre en mayúsculas y minúsculas
		System.out.println("> Nombre en mayúsculas: "+c.mayusculas());
		System.out.println("> Nombre en mayúsculas: "+c.minusculas());
		
		// Mostramos invertido
		System.out.println("> Nombre invertido: "+c.ivertir());
		
		// Mostramos el nº de caracteres
		System.out.println("> Número de caracteres: "+c.longitud());
		
		// Mostramos el nº de vocales
		System.out.println("> Número de vocales: "+c.contarVocales());
		
		// Mostramos el nº de vocales
		System.out.println("> Número de consonantes: "+c.contarConsonantes());
		
		
		
		c.eliminar('E');
		c.reemplazar('E', 'a');
		
		System.out.println(c.getCadena());
		
	
		
		
		sc.close();
	}

}
