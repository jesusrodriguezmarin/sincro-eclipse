package ejemploBoletinUt3;

import java.util.Scanner;

public class Ejer1 {

	public static void meses(int mes, int dia) {
		switch (mes) {
		case 1: System.out.println("Dia: "+dia+" de enero.");
			break;
		case 2: System.out.println("Dia: "+dia+" de febrero.");
			break;
		case 3: System.out.println("Dia: "+dia+" de marzo.");
			break;
		case 4: System.out.println("Dia: "+dia+" de abril.");
			break;
		case 5: System.out.println("Dia: "+dia+" de mayo.");
			break;
		case 6: System.out.println("Dia: "+dia+" de junio.");
			break;
		case 7: System.out.println("Dia: "+dia+" de julio.");
			break;
		case 8: System.out.println("Dia: "+dia+" de agosto.");
			break;
		case 9: System.out.println("Dia: "+dia+" de septiembre.");
			break;
		case 10: System.out.println("Dia: "+dia+" de octubre.");
			break;
		case 11: System.out.println("Dia: "+dia+" de noviembre.");
			break;
		case 12: System.out.println("Dia: "+dia+" de diciembre.");
			break;
		}
	}
	
	// programa principal
	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		
		// control de excepciones
		try {
			// variables para mes y dia
			int mes, dia;
			
			do {
				System.out.println("Introduce número de día y mes de una fecha...");
				// pedimos mes hasta que este en el rango
				System.out.print("Mes: ");
				mes = sc.nextInt();
				
				// controlamos el mes  con mensaje de error
				if (mes > 12 || mes < 1) {
					System.out.println(">> Los meses van desde el 1 (enero) hasta el 12 (diciembre)");
					
				// si es correcto pedimos dia
				} else {
					// pedimos dia
					System.out.print("Dia: ");
					dia = sc.nextInt();
			
					// controlamos los dias impares
					if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
						
						// si no es correcto mostramos error
						if (dia > 31 || dia < 1) {
						System.out.println(">> El número de día dentro del mes que has introducido no es correcto.");		
						} else {
							// si es correcto mostrar el nombre y dia del mes
							meses(mes, dia);
						}
					} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
						
						// sino es correcto mostramos mensaje de error
						if (dia > 30 || dia < 1) {
							System.out.println(">> El número de día dentro del mes que has introducido no es correcto.");
						} else {
							// sino mostrar el nombre y dia del mes
						}	meses(mes, dia);
					} else if (mes == 2) {						
						// sino es correcto mostramos error
						if (dia > 28 || dia < 1) {
							System.out.println(">> El número de día dentro del mes que has introducido no es correcto.");
						} else {
							// si es correcto mostrar el nombre y dia del mes
							meses(mes, dia);
						}
					}	
					
				}	
				
			// condicion del bucle
			} while (mes > 12 || mes < 1);
				
			
		} catch (Exception e) {
			System.err.println(">> ERROR. El tipo de datos introducido no es corrrecto.");
		} finally {
			// cierre lector
			sc.close();
		}
		
	}

}
