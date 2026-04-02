package recuperaciones.examenUt5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ejercicio01 {

	public static void main(String[] args) {
		
		// Creamos una clase DATE
		Date hoy = new Date();
		
		// Creamos una instancia para usar el constructor 
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Fecha: "+formato.format(hoy));
		
		// Creamos instancia para formatear hora
		formato = new SimpleDateFormat("hh:mm:ss a");
		System.out.println("Hora (12h): "+formato.format(hoy));
		
		// Creamos instancia para formatear hora a 24
		formato = new SimpleDateFormat("HH:mm:ss");
		System.out.println("Hora (24h): "+formato.format(hoy));
		
		// Creamos instancia para formatear el nombre del día y mes
		formato = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy");
		System.out.println("Formato largo: "+formato.format(hoy));


	}

}
