package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer5HorasMinSeg {

	public static void main(String[] args) {
		try {
		// Pedimos horas, minutos y segundos
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la hora");
		System.out.print("Introduce las horas:");
		int horas = sc.nextInt();
		System.out.print("Introduce los minutos:");
		int min = sc.nextInt();
		System.out.print("Introduce los segundos:");
		int seg = sc.nextInt();
		sc.close();
		
		// Comprobamos si son correctos
		if (horas >= 0 && horas <= 23) {
			if (min >= 0 && min <= 59) {
				if (seg >= 0 && seg <=59)
					System.out.println("La hora: "+horas+" : "+min+" : "+seg+" es correcta");
				else
					System.out.print("Los segundos no son correctos");
			} else 
				System.out.print("Los minutos no son correctos");
		} else
			System.out.print("Las horas no son correctas");
		
		} catch (Exception e) {
			System.err.print("ERROR. El valor introducido no es correcto");
		}
		
	}

}
