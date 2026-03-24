package ejemplos.entero;

import java.util.Scanner;

public class EnteroTest02 {

	public static void main(String[] args) {
		// Creamos un objeto
		Entero miObjeto = new Entero();
		
		// mostramos el número inicial
		System.out.println("Inicialmente tenemos: "+miObjeto.getEntero());
		
		// abrimos lector
		Scanner reader = new Scanner(System.in);

		// control de excepciones
		try {
			// pedimos un número al usuario
			System.out.print("Introduce un número entero: ");
			
			// modificamos el objeto 'miObjeto' con set + scanner
			miObjeto.setEntero(reader.nextInt());
			
			// mostramos por consola la actualización del objeto
			System.out.println("Ahora tenemos: "+miObjeto.getEntero());
						
		} catch (Exception e) {
			System.err.println(">> ERROR. Tipo de dato no válido.");
		} reader.close();
		
		// llamamos al método para ver comprobar cero
		if (miObjeto.esCero())
			System.out.println(miObjeto.getEntero()+" podemos ver que es cero.");
		else
			System.out.println(miObjeto.getEntero()+" podemos ver que no es cero.");
		
		// llamamos al método para comprobar cero e imprimir lo correspondiente
		if (!miObjeto.esCero())
			System.out.println("Valor del númro: "+miObjeto.getEntero());
		else
			System.out.println("Valor del número: "+miObjeto.getEntero()+" (cero)");
	}

}
