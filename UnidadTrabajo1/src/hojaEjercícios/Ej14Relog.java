package hojaEjercícios;

public class Ej14Relog {

	public static void main(String[] args) {

		// Declaración e inicialización
		int t=3661;
		int horas;
		int min;
		int seg;
		
		// Cálculo en horas, min y sg
		horas=t/3600;
		min=(t%3600)/60;
		seg=(t%3600)%60;
				
		// Resultado impreso por pantalla
		System.out.println("El tiempo total en segundos es: "+t);
		System.out.println("Horas: "+horas);
		System.out.println("Minutos: "+min);
		System.out.println("Segundos: "+seg);
	
	}

}
