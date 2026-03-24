package ejerciciosClase;

public class Tiempo2 {

	public static void main(String[] args) {

		// Declaración e inicialización
		int total=7388;
		
		
		// Declaramos las variables
		int horas=total/3600;
		int min=(total%3600)/60;
		int seg=(total%3600)%60;
		
		// Imprimimos resultados
	
		System.out.println("Horas: "+horas);
		System.out.println("Minutos: "+min);		
		System.out.println("Segundos: "+seg);
		
	}

}
