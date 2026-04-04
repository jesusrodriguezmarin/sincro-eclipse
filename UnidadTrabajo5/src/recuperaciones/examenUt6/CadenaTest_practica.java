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
		
		// Establecemos el dato solicitadp por consola como cadena con -set y parámetro
		c.setCadena(nombre);
		
		// Mostramos con -get
		System.out.print(" > El nombre introducido es: "+c.getCadena());
		
		// Mostramos en mayúsculas con el método creado
		System.out.print("\n > El nombre en mayúsculas es: "+c.mayus());
		
		// Mostramos en minúsculas con el método creado
		System.out.print("\n > El nombre en minúsculas es: "+c.minus());
		
		// Mostramos la cadena invertida con el método creado
		System.out.print("\n > El nombre invertido es: "+c.reverso());
		
		// Mostramos la longitud de la cadena
		System.out.println("\n > El nombre tiene: "+c.longi()+ "letras");
		
		// Mostramos el números de vocales de la cadena
		System.out.println(" > El nombre tiene: "+c.voc()+" vocales");
		
		// Mostramos el número de consonantes
		System.out.println(" > El nomnbre tiene: "+c.cons()+" consonantes");
		
		// Mostramos el número de apariciones de el caracter introdiucido
		System.out.print("\nIntroduce un caracter para contarlo: ");
		char contar = sc.nextLine().charAt(0);
		System.out.println(" > El caracter: "+contar+" aparece "+c.carac(contar)+" veces");
		
		// Reemplazamos un caracter de la cadena por otro
		System.out.print("Introduce un caracter a reemplazar: ");
		char viejo = sc.nextLine().charAt(0);
		System.out.print("Introduce el nuevo caracter: ");
		char nuevo = sc.nextLine().charAt(0);
		
		c.reemp(viejo, nuevo);
		System.out.println(" > El nombre con reemplazos es: "+c.getCadena());
		
		// Eliminamos el caracter pasado por parámetro
		System.out.print("Introduce un caracter a eliminar: ");
		char caracter = sc.nextLine().charAt(0);
		c.borra(caracter);
		System.out.println(" > El nombre con borrados es: "+c.getCadena());
			
		sc.close();

	}

}
