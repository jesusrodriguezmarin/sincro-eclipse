package date;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MayorEdad {

	/**
	 * Determina si una persona es mayor de edad en función de su fecha de nacimiento 
	 * pasada por parámetro
	 * @param a - año de nacimiento
	 * @param m - mes de nacimiento
	 * @param d - dia de nacimiento
	 * @return true si la persona es mayor de edad y false si no lo es
	 */
	public static boolean mayorEdad(int a, int m, int d) {
		// creamos objeto Date con nombre hoy
		// creando una clase Date
		Date hoy = new Date();
						
		// creamos un objeto SimpleDateFormat con nombre formato
		SimpleDateFormat formato;
						
		// usamos el objeto formato
		formato = new SimpleDateFormat("yyyy");
		int aHoy = Integer.parseInt(formato.format(hoy));
						
		// reusamos el objeto formato
		formato = new SimpleDateFormat("MM");
		int mHoy = Integer.parseInt(formato.format(hoy));
						
		// reusamos el objeto formato
		formato = new SimpleDateFormat("dd");
		int dHoy = Integer.parseInt(formato.format(hoy));
		
		// calculamos edad
		if (aHoy - a > 18)
			return true;
		else if (aHoy - a < 18)
			return false;
		// 18 == 18
		else {
			if (mHoy > m)
				return true;
			else if (mHoy < m)
				return false;
			else {
				if (dHoy >= d)
					return true;
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		// 	Pedimos al usuario que introduzca su fecha de nacimiento
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Introduce tu fecha de nacimiento...");
			System.out.print("Día: ");
			int dia = sc.nextInt();
			System.out.print("Mes: ");
			int mes = sc.nextInt();
			System.out.print("Año: ");
			int año = sc.nextInt();
			
			if (mayorEdad(año, mes, dia))
				System.out.println("Es mayor de edad");
			else
				System.out.println("No es mayor de edad");
			
		} catch (Exception e) {
			System.err.println("ERROR");
		} finally {
			sc.close();
		}
	}

}
