package examen;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ej1 {

	public static void main(String[] args) {

		// Creamos un objeto Date
		Date hoy = new Date();
		
		SimpleDateFormat formato;
		formato = new SimpleDateFormat("HH");
		String hora = formato.format(hoy);
		formato = new SimpleDateFormat("mm");
		String min = formato.format(hoy);
		formato = new SimpleDateFormat("ss");
		String seg = formato.format(hoy);
		
		System.out.println("La hora actual en España es: ");
		System.out.println("> "+hora+":"+min+":"+seg+" en la península");
		
		int h = Integer.parseInt(hora);
		
		System.out.println("> "+(h-1)+":"+min+":"+seg+" en las Islas Canarias");

	}

}
