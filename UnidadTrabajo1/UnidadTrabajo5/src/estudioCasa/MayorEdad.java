// Determina la edad de una persona que mete su fecha por teclado
// En base a la fecha de hoy

package estudioCasa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MayorEdad {

	public static void hoy() {
	
		// Sacamos la fecha de hoy creando una instancia de la clase Date
		Date hoy = new Date();

		// Formateamos la fecha obtenida en Date
		SimpleDateFormat formato;

		formato = new SimpleDateFormat("yyyy");
		String year = formato.format(hoy);
		formato = new SimpleDateFormat("MM");
		String month = formato.format(hoy);
		formato = new SimpleDateFormat("dd");
		String day = formato.format(hoy);

		System.out.println("Fecha actual en void: " + year + "/" + month + "/" + day);
	}

	/**
	 * Función que calcula la edad de un usuario a partir de su fecha pasada por parámetro
	 * @param a - año de nacimiento
	 * @param m - mes de nacimiento
	 * @param d - día de nacimiento
	 * @return int fecha de nacimiento
	 */
	public static int tuEdad(int a, int m, int d) {
		// Variable para mostrar
		int edad = 0;

		// Sacamos la fecha de hoy creando una instancia de la clase Date
		Date hoy = new Date();

		// Formateamos la fecha obtenida en Date
		SimpleDateFormat formato;

		formato = new SimpleDateFormat("yyyy");
		String year = formato.format(hoy);
		formato = new SimpleDateFormat("MM");
		String month = formato.format(hoy);
		formato = new SimpleDateFormat("dd");
		String day = formato.format(hoy);

		System.out.println("Fecha actual en función: " + year + "/" + month + "/" + day);

		// Convertimos/parseamos cada String a un int con parseInt
		int ahoy = Integer.parseInt(year);
		int mhoy = Integer.parseInt(month);
		int dhoy = Integer.parseInt(day);

		edad = ahoy - a;

		if (mhoy < m) {
			edad--;
		} else if (mhoy == m) {
			if (dhoy < d) {
				edad--;
			}
		}
		return edad;
	}

	// Programa principal
	public static void main(String[] args) {

		// Creamos lector para pedir la fecha por teclado
		Scanner sc = new Scanner(System.in);

		// Control de excepciones ya que vamos a pedir int
		try {
			// Pedimos la fecha al usuario
			System.out.println("Introduce tu fecha de nacimiento...");
			System.out.print("Año: ");
			int a = sc.nextInt();
			System.out.print("Mes: ");
			int m = sc.nextInt();
			System.out.print("Día: ");
			int d = sc.nextInt();

			// Mostramos la fecha de hoy
			hoy();
			
			// Llamamos a la funión para mostrar la edad
			int edad = tuEdad(a, m, d);
			System.out.println("Tu edad es: "+edad+" años");
			
			// Filtramos si el usuario es mayor de edad o no
			if (edad<18) {
				System.out.println("¡Oh!. Eres menor de edad");
			} else {
				System.out.println("¡Genial!. Eres mayor de edad.");
			}

		} catch (Exception e) {
			System.err.println(">> ERROR. Tipo de dato no válido.");
		} finally {
			sc.close();
		}

	}

}
