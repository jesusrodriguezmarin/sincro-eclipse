package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class hora01 {

	public static void main(String[] args) {

		// Creamos un objeto Date con la fecha de hoy
		Date hoy = new Date();		// la devuelve en inglés
		System.out.println("Fecha (sin formato): "+hoy);
	
		// Mostramos la hora
		SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
		System.out.println("Hora: "+f.format(new Date()));

	}

}
