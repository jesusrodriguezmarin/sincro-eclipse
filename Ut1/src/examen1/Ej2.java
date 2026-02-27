package examen1;

public class Ej2 {

	public static void main(String[] args) {

		// Declaración de variables
		int horas=1;
		int min=59;
		int seg=61;
		int total;
		
		// Iinicialización de variabless
		total=(1*3600)+(59*60)+(61);
		
		// Cálculo del total en horas, min y seg
		System.out.println(horas+"h "+min+"m "+seg+"s");
		
		// Cálculo del total en horas, min y seg correctamente
		horas=(total/3600);
		total=(total%3600);
		min=(total/60);
		total=(total%60);
		seg=(total);
		
		// Resultado impreso en pantalla
		System.out.println(horas+"h "+min+"m "+seg+"s");
		
		
		
	}

}
