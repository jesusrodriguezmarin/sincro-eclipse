package date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Edad01ParaExamen {

	public static void main(String[] args) {
		
		// Creamos la fecha actual y la formateamos para obtener el año, mes y dia
		Date hoy = new Date();
		SimpleDateFormat formato;
		formato = new SimpleDateFormat("yyyy");
		String year = formato.format(hoy);
		formato = new SimpleDateFormat("MM");
		String month = formato.format(hoy);
		formato = new SimpleDateFormat("dd");
		String day = formato.format(hoy);
		System.out.println("Fecha actual: "+day+"/"+month+"/"+year);
		
		// convertimos cada string a in int con un parseint
		int aHoy = Integer.parseInt(year);
		int mHoy = Integer.parseInt(month);
		int dHoy = Integer.parseInt(day);
		
	
		
		// Pedimos al usuario que introducza su fecha de nacimiento
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("\nIntroduce tu fecha de nacimiento: ");
			System.out.print(" Día: ");
			int d = sc.nextInt();
			System.out.print(" Mes: ");
			int m = sc.nextInt();
			System.out.print(" Año: ");
			int a = sc.nextInt();
			
			// Cálculamos la edad
			int edad = aHoy - a;
			if (mHoy < m)
				edad--;
			else if (mHoy == m) {
				if (dHoy < d)
					edad--;
			}
			
			System.out.println("\nEdad: "+edad);
			
		} catch (InputMismatchException ime) {
			System.err.println(">> Error en la introducción de datos");
		} finally {
			sc.close();
		}

	}

}
