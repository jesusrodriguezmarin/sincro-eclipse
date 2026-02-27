package strings.expicacionClase;

import java.util.Scanner;

public class Ejp02EjemploString {

	public static void main(String[] args) {
		
		// 1. Pedimos al usuario que introduzca su nombre
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime tu nombre: ");
		
		// Usamos el método .nextLine() para leer por el objeto sc creado de la clase Scanner
		// Usamos el método .trim() para quitar los espacios si los hubiera
		// Usamos el método .toLowerCase() para convertir todo lo que entra por sc a minúscula
		String nombre = sc.nextLine().trim().toUpperCase();
		sc.close();
		
		// 2. Mostramos por pantalla el nombre
		System.out.println("Nombre: "+nombre);
		
		// 3. Mostrar la longitud del nombre
		System.out.println("Longitud: "+nombre.length());
		
		// 4. Mostramos el nombre escrito con mayúsculas
		System.out.println("En minúscula: "+nombre.toLowerCase());
		// El nombre no se ha modificado, solo para mostrarlo
		System.out.println("Original: "+nombre);
		
		// 5. Mostramos la inicial del nombre
		System.out.println("Inicial: "+nombre.charAt(0));
		
		// 6. Mostramos el último carácter del nombre
		System.out.println("Final: "+nombre.charAt(nombre.length()-1));
		
		// 7. Mostramos el nombre intercalando espacios en blanco
		System.out.print("Espaciado: ");
		for (int i=0; i<nombre.length(); i++) {
			System.out.print(nombre.charAt(i)+" ");
		}
		System.out.println();
		
		// 8. Mostramos el nombre al revés
		System.out.print("Nombre al revés: ");
		for (int i=nombre.length()-1; i>=0; i--)
			System.out.print(nombre.charAt(i)+" ");
		System.out.println();
		
		// 9. Mostramos solo las vocales
		System.out.print("Vocales: ");
		char c;
		for (int i=0; i<nombre.length(); i++) {
			c=nombre.charAt(i);
			if (c=='a' || c=='e'|| c=='i'|| c=='o'|| c=='u') {
				System.out.print(c+" ");
			}
			if (c=='A' || c=='E'|| c=='I'|| c=='O'|| c=='U') {
				System.out.print(c+" ");
			}
		}
		System.out.println();
		System.out.print("Vocales minúsculas: ");
		for (int i=0; i<nombre.length(); i++) {
			c=nombre.toLowerCase().charAt(i);
			if (c=='a' || c=='e'|| c=='i'|| c=='o'|| c=='u') {
				System.out.print(c+" ");
			}
			
		}
		
		
	}

}
