package date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Edad01ParaExamen_V2 {

	/**
	 * Calcula la edad de una persona en función a su fecha de nacimiento
	 * pasada como parámetro
	 * @param a - año de nacimiento
	 * @param m
	 * @param d
	 * @return edad de una persona dada su fecha de nacimiento
	 */
	private static int edad(int a, int m, int d) {
		// Creamos la fecha actual y la formateamos para obtener el año, mes y dia
		// creando una clase Date
		Date hoy = new Date();
				
		// creamos un objeto SimpleDateFormat
		SimpleDateFormat formato;
				
		// usamos el objeto formato
		formato = new SimpleDateFormat("yyyy");
		int aHoy = Integer.parseInt(formato.format(hoy));
				
		// reusamos el objeto formato
		formato = new SimpleDateFormat("MM");
		int mHoy = Integer.parseInt(formato.format(hoy));
				
		// reusamos el objeto formato
		formato = new SimpleDateFormat("dd");
		int dHoy = Integer.parseInt(formato.format(hoy));
		
		// Cálculamos la edad
		int e = aHoy - a;
		if (mHoy < m)
			e--;
		else if (mHoy == m) {
			if (dHoy < d)
				e--;
		}
		return e;
	}
	
	public static void main(String[] args) {

		// Pedimos al usuario que introducza su fecha de nacimiento
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Introduce tu fecha de nacimiento: ");
			System.out.print(" Día: ");
			int d = sc.nextInt();
			System.out.print(" Mes: ");
			int m = sc.nextInt();
			System.out.print(" Año: ");
			int a = sc.nextInt();
			
			// Mostramos lo que ha introducido el usuario
			System.out.println("\nHas introducido "+a+"/"+m+"/"+d);
			
			// Mostramos la edad por consola
			System.out.println("Tu edad es: "+edad(a, m, d));
			
		} catch (InputMismatchException ime) {
			System.err.println(">> Error en la introducción de datos");
		} finally {
			sc.close();
		}

	}

}
