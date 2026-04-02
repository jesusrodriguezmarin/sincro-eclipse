package recuperaciones.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Edad {

	public static void main(String[] args) {
		
		// En base a la fecha de hoy y la fecha de nacimiento 
		// introducida por teclado
		// determinamos la edad de una persona
		
		// Sacamos la fecha de hoy creando una instancia de Date
		Date hoy = new Date();
		
		// Separamos la fecha con Format para trabajar con los números
		SimpleDateFormat formato;
		
		// Creamos instancia para año
		formato = new SimpleDateFormat("yyyy");
		String year = formato.format(hoy);
		
		// Creamos instancia para mes
		formato = new SimpleDateFormat("MM");
		String month = formato.format(hoy);
		
		// Creamos instancia para día
		formato = new SimpleDateFormat("dd");
		String day = formato.format(hoy);
		
		System.out.println("La fecha de hoy es: "+day+"/"+month+"/"+year);
		
		// Convertimos los String a int para realizar cálculos
		int aHoy = Integer.parseInt(year);
		int mHoy = Integer.parseInt(month);
		int dHoy = Integer.parseInt(day);
		
		// Pedimos fecha de nacimiento al usuario
		Scanner sc = new Scanner(System.in);
		System.out.println("\n--Introduce tu fecha de nacimiento--");
		System.out.print("Año: ");
		int y = sc.nextInt();
		System.out.print("Mes: ");
		int m = sc.nextInt();
		System.out.print("Día: ");
		int d = sc.nextInt();
		sc.close();
		
		
		
		// Formula para la edad restando al año actual el año introducido
		int edad = aHoy-y;
		
		// Si el mes introcucido es mayor o igual, condicionamos según el día introducido
		if (mHoy<m) {
			edad--;
		} else if (m==mHoy) {
			if (d>dHoy) {
				edad--;
			}
		}
		
		// Mostramos la edad
		System.out.println("\nTu edad es: "+edad+" años.");

	}

}
