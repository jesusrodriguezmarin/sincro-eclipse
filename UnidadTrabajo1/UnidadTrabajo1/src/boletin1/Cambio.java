package boletin1;

public class Cambio {

	public static void main(String[] args) {

		// Declaración e inicialización de variables
		int pago=50;
		int coste=7;
		int cambio;
		
		// Operación de cambio total
		cambio=pago-coste;
		
		// Declaración e inicialización de variables 
		int b20=cambio/20;
		cambio=cambio%20;
		int b10=cambio/10;
		cambio=cambio%10;
		int b5=cambio/5;
		cambio=cambio%5;
		int m2=cambio/2;
		cambio=cambio%2;
		int m1=cambio/1;
		
		// Resultado del cambio impreso en pantalla
		System.out.println("Billetes de 20€: "+b20);
		System.out.println("Billetes de 10€: "+b10);
		System.out.println("Billetes de 5€: "+b5);
		System.out.println("Monedas de 2€: "+m2);
		System.out.println("Monedas de 1€: "+m1);
	
	}
}
