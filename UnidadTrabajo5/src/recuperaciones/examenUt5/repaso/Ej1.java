package recuperaciones.examenUt5.repaso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ej1 {

	public static void main(String[] args) {

		// 1. Creamos una instancia de Data para sacar la fecha actual
		Date hoy = new Date();
		
		// 2. Creamos una instancia de SimpleDateFormat() para crear un molde para cada parte
		SimpleDateFormat formato;
		
		// Primero
		// Otro SimpleDateFormat formato para dia 
		formato = new SimpleDateFormat("dd");
		String dhoy = formato.format(hoy);
		System.out.print(dhoy);	// Ya tenemos el puto día
		System.out.print("/");
		
		// Segundo 
		// Otro simpleDateFormat formato para mes
		formato = new SimpleDateFormat("MM");
		String mhoy = formato.format(hoy);
		System.out.print(mhoy);	// Ya tenemos el puto mes
		System.out.print("/");
		
		// Tercero
		// Filtramos el Date hoy por el molde SimpleDateFormat formato y almacenamos en una variable
		formato = new SimpleDateFormat("yyyy");
		String ahoy = formato.format(hoy);	// Haciendo uso de .format sobre el objeto formato
		System.out.println(ahoy); 	// Ya tenemos el puto año
		
		// Vamos con la puta hora
		formato = new SimpleDateFormat("hh:mm:ss a");
		String hora12 = formato.format(hoy);
		System.out.println("La fuck hora es: "+hora12);
		
		// Vamos con la jodida hora militar
		formato = new SimpleDateFormat("HH:mm:ss");
		String hora24 = formato.format(hoy);
		System.out.println("Is the fucking: "+hora24);
		
		// Por último, popurrí absoluto
		formato = new SimpleDateFormat("EEEE d 'de' MMMM 'de' yyyy");
		String popurri = formato.format(hoy);
		System.out.println(popurri);
		
		// Pedimos fecha al usuario
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce tu fecha de nacimiento");
		System.out.print("año: ");
		int a = sc.nextInt();
		System.out.print("mes: ");
		int m = sc.nextInt();
		System.out.print("día: ");
		int d = sc.nextInt();
		
		// Parseamos las fechas para trabajar con ellas
		int year = Integer.parseInt(ahoy);
		int month = Integer.parseInt(mhoy);
		int day = Integer.parseInt(dhoy);
		
		// Calculamos edad
		int edad = year - a;
		
		// Controlamos la edad exacta
		if (m > month) {
			edad--;
		} else if (m == month) {
			if (d > day) {
				edad--;
			}
		}
		// Mostramos edad
		System.out.println("Tu edad es: "+edad);
		sc.close();
		
	}

}
