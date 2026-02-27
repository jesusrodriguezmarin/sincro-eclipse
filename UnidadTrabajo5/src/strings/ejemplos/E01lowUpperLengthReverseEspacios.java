package strings.ejemplos;

import java.util.Scanner;

public class E01lowUpperLengthReverseEspacios {

	public static void main(String[] args) {
		
		// Creamos un objeto String
		String nombre;
		
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		// Pedimos a usuario
		System.out.print("Introduce tu nombre: ");
		nombre = sc.nextLine().trim();	// Quitamos los espacios .trim()
		// Cerramos lector
		sc.close();
		
		// Mostramos nombre introducido
		System.out.println("Nombre introducido: "+nombre);
		
		// Mostramos la longitud del nombre
		System.out.println("Longitud: "+nombre.length()+" carácteres");
		
		// Mostramos en mayúsculas
		System.out.println("Mayúsculas: "+nombre.toUpperCase());
		
		// Mostramos en minúsculas
		System.out.println("Minúsculas: "+nombre.toLowerCase());
		
		// Le añadimos el alias
		System.out.println("Nombre: "+nombre.concat(" Cracken"));
	
		// Mostramos al revés, 
		System.out.print("Al revés: ");
		for (int i=nombre.length()-1; i>=0; i--) {
			System.out.print(nombre.charAt(i));
		}
		// Mostramos intercalando espacios
		System.out.print("\nAl revés y separado: ");
		for (int i=nombre.length()-1; i>=0; i--) {
			System.out.print(nombre.charAt(i)+" ");
		}
		// Primer
		System.out.println("\nPrimer carácter: "+nombre.charAt(0));
		
		// Último
		System.out.println("Último: "+nombre.charAt(nombre.length()-1));
		
		// Vocales
		System.out.print("Vocales: ");
		char c;
		for (int i=0; i<nombre.length(); i++) {
			c=nombre.charAt(i);
			if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u' ||
				c=='A' || c=='E' || c=='I' || c=='O' || c=='U') {
				System.out.print(c+" ");
			}
		}
		
	}

}
