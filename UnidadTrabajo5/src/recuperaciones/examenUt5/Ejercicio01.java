package recuperaciones.examenUt5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ejercicio01 {

	public static void main(String[] args) {
		// Creamos una clase DATE
		Date actual=new Date();
		
		// La formateamos
		SimpleDateFormat formato= new SimpleDateFormat();
		
		// Mostramos el dia actual
		System.out.print(formato.format(actual));
		
		formato=new SimpleDateFormat("\nhh:mm:ss aaaa");
		
		System.out.print(formato.format(actual));

	}

}
