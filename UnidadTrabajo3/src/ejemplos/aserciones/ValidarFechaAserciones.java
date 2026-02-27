package ejemplos.aserciones;

import java.util.Scanner;

public class ValidarFechaAserciones {

	/**
	 * Funcion que devuelve el número de días que tiene el mes
	 * Enero (1), marzo (3), mayo (5), julio (7), agosto (8), octubre (10), diciembre (12), tienen 31 días.
	 * El resto menos febrero (2) que tiene 28 dias, tienen 30 días.
	 * @param mes - Número correspondiente al mes: 1 enero, 2 febrero..12 diciembre.
	 * @return - número de días que tiene el mes
	 */
	private static int diasMes(int mes) {
		int numDias = 31;
		if (mes == 2)
			numDias = 28;
		if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
			numDias = 30;
		return numDias;
	}
	
	// programa principal
	public static void main(String[] args) {
		// lector
			Scanner sc = new Scanner(System.in);
			// control errores
			try {
				// declaramos variables a pedir
				int day, month, year;
				
				// mensaje principal
				System.out.println("Introduce la fecha...");
				
				// pedimos el año
				System.out.print("Año: ");
				year = sc.nextInt();
				assert year != 0 : "El año 0 no existe";
					
				// pedimos los meses
				System.out.print("mes: ");
				month = sc.nextInt();
				assert month >= 1 && month <= 12 : "Los meses son desde el 1 (enero) al 12 (diciembre)";
					
					
				// pedimos los dias
				System.out.print("dia: ");
				day = sc.nextInt();
				assert day >= 1 || day <= diasMes(month) : "El número de dia introducido no es correcto.";
					
						
				System.out.println("La fecha "+day+" / "+month+" / "+year+" es correcta.");
						
										
			} catch (Exception e) {
				System.out.println("ERROR");
			
			} catch (AssertionError ae) {
				System.out.println(ae.getMessage());
			} finally {
				// cierre
				sc.close();
			}

	}

}
