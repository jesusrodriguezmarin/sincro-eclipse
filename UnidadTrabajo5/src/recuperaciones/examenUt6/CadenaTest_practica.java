package recuperaciones.examenUt6;

import java.util.Scanner;

public class CadenaTest_practica {

	public static void main(String[] args) {
		
		// Instanciamos un objeto cadena
		Cadena_practica c = new Cadena_practica();
		
		// Solicitamos una cadena de texto por teclado
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce tu nombre: ");
		String nombre = sc.nextLine();
		sc.close();
		
		// Establecemos la cadena solicitada por consola como cadena con -set
		c.setCadena(nombre);
		
		// Mostramos con -get
		System.out.println(c.getCadena());
		
		// Mostramos en mayúsculas con el método creado
		System.out.println(c.mayus());
		
		// Mostramos en minúsculas con el método creado
		System.out.println(c.minus());
		
		// Mostramos la cadena invertida con el método creado
		System.out.println(c.reverso());
		
		// Mostramos la longitud de la cadena
		System.out.println(c.longi());
		
		// Mostramos el números de vocales de la cadena
		System.out.println(c.voc());
		
		// Mostramos el número de consonantes
		System.out.println(c.cons());
		
		// Mostramos el número de apariciones de el caracter introdiucido
		System.out.println(c.carac('p'));
		
		// Reemplazamos un caracter de la cadena por otro
		c.setCadena(c.mayus());
		c.reemp('P', 'F');
		System.out.println(c.getCadena());
		
		// Eliminamos el caracter pasado por parámetro
		c.borra('A');
		System.out.println(c.getCadena());
			
		
	}

}
