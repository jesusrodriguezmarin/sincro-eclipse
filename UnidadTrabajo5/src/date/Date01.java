package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date01 {

	public static void main(String[] args) {

		// Creamos un objeto Date con la fecha de hoy
		Date hoy = new Date();		// la devuelve en inglés
		System.out.println("Fecha (sin formato): "+hoy);
		
		// Formateamos la fecha con SimpleDateFormat para poder llamar a la fecha de hoy
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String fechaFormateada = formato.format(hoy);
		System.out.println("Fecha (con formato): "+fechaFormateada);

		// Obtenemos parte de la fecha usando el objeto ya creado formato
		formato = new SimpleDateFormat("yyyy");
		String a = formato.format(hoy);
		System.out.println("Año: "+a);
		
		// Número de mes
		formato = new SimpleDateFormat("MM");
		String m = formato.format(hoy);
		System.out.println("Mes: "+m);
		
		// Número de día dentro del mes
		formato = new SimpleDateFormat("dd");
		String d = formato.format(hoy);
		System.out.println("Mes: "+d);
		
		// Número del dia dentro del año
		formato = new SimpleDateFormat("DD");
		String D = formato.format(hoy);
		System.out.println("Mes: "+D);
		
		// Horas
		formato = new SimpleDateFormat("HH");
		String h = formato.format(hoy);
		System.out.println("Horas: "+h);
		
		// Minutos
		formato = new SimpleDateFormat("mm");
		String min = formato.format(hoy);
		System.out.println("Minutos: "+min);
		
		// Segundos
		formato = new SimpleDateFormat("ss");
		String s = formato.format(hoy);
		System.out.println("Segundos: "+s);
	}

}
