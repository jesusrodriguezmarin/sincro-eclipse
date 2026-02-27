package ejerciciosClase;

public class Tiempo {

	public static void main(String[] args) {

		// Declaración e inicialización
		int total=7388;
		
		
		// Declaramos las variables
		int horas=total/3600;
		int resto=total%3600;
		int min=resto/60;
		int seg=resto%60;
		
		// Imprimimos resultados
	
		System.out.println("Horas: "+horas);
		System.out.println("Minutos: "+min);		
		System.out.println("Segundos: "+seg);
		
	}

}
