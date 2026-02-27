package strings.expicacionClase;

import java.util.Scanner;

public class ArrayString {

	public static void main(String[] args) {

		// Creamos lector
		Scanner sc = new Scanner(System.in);
				
		// 1. Pedimos al usuario una cadena de carácteres
		System.out.print("Introduce una cadena de carácteres: ");
		String cad = sc.nextLine().trim();
		
		// Cerramos lector
		sc.close();

		// 2. Transformamos el String a un array de carácteres
		char[] array = cad.toCharArray();
		
		// 3. Mostramos el primer carácter del String y el primer carácter del array
		System.out.println("Primer carácter del String: "+cad.charAt(0));
		System.out.println("Primer carácter del Array: "+array[0]);
		
		// 4. Mostramos el último
		System.out.println("Primer carácter del Array: "+cad.charAt(cad.length()-1));
		System.out.println("Primer carácter del Array: "+array[array.length-1]);
		
		// 5. Mostramos por pantalla el array 
		System.out.println("String: "+cad);
		System.out.print("Array: ");
		for (int i=0; i<array.length; i++)
			System.out.print(array[i]);
	}

}
