package recuperaciones.examenUt5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ej1_practica {

	public static void main(String[] args) {
		
		// Creamos una instancia de la clase Date para obtener la fecha actual
		Date hoy = new Date();
		// Mostramos la fecha según sale 
		System.out.println("La fecha de hoy es: "+hoy);
		
		// Creamos una isntancia de SimpleDateFormat para dar formato a Date
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = formato.format(hoy);
		System.out.println("Fecha formateada: "+fecha);
		
		formato = new SimpleDateFormat("hh:mm:ss a");
		String hora12 = formato.format(hoy);
		System.out.println("La hora (12h): "+hora12);
		
		formato = new SimpleDateFormat("HH:mm:ss");
		String hora24 = formato.format(hoy);
		System.out.println("La hora (24h): "+hora24);
		
		SimpleDateFormat letras = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy");
		String fechalarga = letras.format(hoy);
		System.out.println("La fecha es: "+fechalarga);
		
	}

}
