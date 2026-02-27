package examenRecuperacionUt3;

import java.util.Scanner;

public class Ejer1 {

	public static void meses(int m) {
		switch (m) {
		case 1:
			System.out.println("enero");
			break;
		case 2:
			System.out.println("febrero");
			break;
		case 3:
			System.out.println("marzo");
			break;
		case 4:
			System.out.println("abril");
			break;
		case 5:
			System.out.println("mayo");
			break;
		case 6:
			System.out.println("junio");
			break;
		case 7:
			System.out.println("julio");
			break;
		case 8:
			System.out.println("agosto");
			break;
		case 9:
			System.out.println("septiembre");
			break;
		case 10:
			System.out.println("octubre");
			break;
		case 11:
			System.out.println("noviembre");
			break;
		case 12:
			System.out.println("diciembre");
			break;

		default:
			break;
		}
	}
	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Introduce una fecha: ");
			System.out.print("Año: ");
			int año = sc.nextInt();
			if (año == 0) {
				System.out.println(">>> El año (cero) no existe");
			} else {
				System.out.print("Mes: ");
				int mes = sc.nextInt();
				boolean bisiesto = false;
				if ((año % 4 == 0 && año % 100 != 0) || (año % 400 == 0))
					bisiesto = true;
				int diasmes = 31;
				if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
					diasmes = 30;
				if (mes == 2) {
					if (bisiesto)
						diasmes = 29;
					else 
						diasmes = 28;
				}
				if (mes < 1 || mes > 12) {
					System.out.println("> Los meses van desde el 1 (enero) hasta el 12 (diciembre)");
				} else {
					System.out.print("Día: ");
					int dia = sc.nextInt();
					if (dia < 1 || dia > diasmes) {
						System.out.println("El número de día del mes que has introducido no es correcto");			
				} else {
					
					System.out.print("> Fecha introducida: "+dia+" de "); meses(mes); System.out.print(" de "+año);
				}
					
				}
			}
			
		} catch (Exception e) {
			System.err.println(">> ERROR. El tipo de datos introducido no es correcto.");
		} finally {
			sc.close();
		}

	}

}
