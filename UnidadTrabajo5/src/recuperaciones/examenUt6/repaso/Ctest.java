package recuperaciones.examenUt6.repaso;

import java.util.Scanner;

public class Ctest {

	public static void main(String[] args) {

		// Solicitamos un String por teclado
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce una cadena de texto: ");
		String cad = sc.nextLine();
		
		// Creamos un objeto cadena
		C cadena = new C();
		
		// Establecemos y mostramos la cadena
		cadena.setCadena(cad);
		System.out.println("La cadena es: "+cadena.getCadena());
		
		// Invertimos la cadena con el método de la clase
		cadena.reverse();
		System.out.println("Invertida es: "+cadena.getCadena());
		
		// Volvemos a estado original
		cadena.reverse();
		
		// Contamos vocales
		System.out.println("Contiene vocales: "+cadena.vocales());
		
		// Sustituimos por *
		cadena.sustituto();
		System.out.println("Sustituido: "+cadena.getCadena());
		
		// Convertimos los * a espacios
		System.out.print("Sustituimos * por ' ': ");
		cadena.espacios();
		System.out.println(cadena.getCadena());
		
		// Suprimimos espacios
		cadena.sin();
		System.out.println("La cadena sin espacios es: "+cadena.getCadena());
		
		sc.close();
	}

}
