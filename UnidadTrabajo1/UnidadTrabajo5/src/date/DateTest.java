package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// 	Crear la fecha actual
		Date hoy = new Date();
		System.out.println("Fecha actual (sin formato): "+hoy);

		// Formatear al fecha con SimpleDateFormat
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String fechaFormateada = formato.format(hoy);
		System.out.println("Fecha actual (formateada): "+ fechaFormateada);
		
		// Obtener partes de la fecha
		formato = new SimpleDateFormat("yyyy");
		String a = formato.format(hoy);
		formato = new SimpleDateFormat("MM");
		String m = formato.format(hoy);
		formato = new SimpleDateFormat("dd");
		String d = formato.format(hoy);
		System.out.println("\nAño: "+a+"\nMes: "+m+"\nDía: "+d);
		
		// obtener partes de la fecha
		formato = new SimpleDateFormat("hh");
		String h = formato.format(hoy);
		formato = new SimpleDateFormat("mm");
		String min = formato.format(hoy);
		formato = new SimpleDateFormat("ss");
		String s = formato.format(hoy);
		System.out.println("\nHoras: "+h+"\nMin: "+min+"\nSeg: "+s);
	}

}
