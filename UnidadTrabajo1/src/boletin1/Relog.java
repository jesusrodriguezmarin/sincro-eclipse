package boletin1;

public class Relog {

	public static void main(String[] args) {

		// Declaración e inicialización 
		int horas=11;
		int min=5;
		int seg=29;
		int total;
		
		// Algorítmo tiempo total en segundos
		total=(3600*horas)+(60*min)+(seg);
		
		// Resultado impreso en pantalla
		System.out.println("El total en segundos es: "+total);
		
	}

}
