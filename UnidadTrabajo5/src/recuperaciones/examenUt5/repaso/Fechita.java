package recuperaciones.examenUt5.repaso;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fechita {

	public static void main(String[] args) {

		// Creamos una clase Date para sacar la fecha actual
		Date hoy = new Date();
		
		SimpleDateFormat formato;
		formato = new SimpleDateFormat("yyyy");
		String year = formato.format(hoy);
		formato = new SimpleDateFormat("MM");
		String month = formato.format(hoy);
		formato = new SimpleDateFormat("dd");
		String day = formato.format(hoy);
		formato = new SimpleDateFormat("EEEE");
		String dia = formato.format(hoy);
		formato = new SimpleDateFormat("hh:mm a");
		String hora12 = formato.format(hoy);
		formato = new SimpleDateFormat("HH:mm");
		String hora24 = formato.format(hoy);
		formato = new SimpleDateFormat("MMMM");
		String mes = formato.format(hoy);
		
		System.out.println(mes);
		System.out.println(dia);
		System.out.println(year+"/"+month+"/"+day);
		System.out.println(hora12);
		System.out.println(hora24);
		
		int ahoy = Integer.parseInt(year);
		int mhoy = Integer.parseInt(month);
		int dhoy = Integer.parseInt(day);
		
		// Usuario
		int a = 1990;
		int m = 5;
		int d = 1;
		
		int edad = ahoy - a;
		if (mhoy < m)
			edad--;
		if (mhoy == m) {
			if (dhoy < d) {
				edad--;
			}
		}
		System.out.println(edad);
		
	}

}
