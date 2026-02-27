package ejerciciosClase;

public class Intercambio {

	public static void main(String[] args) {

		// Declaramos e inicializamos variables
		int a=5;
		int b=10;
		
		
		// Realizamos el intercambio de valores
		
		int aux=a;		// Declaramos una variable auxiliar para guardar el valor de a y no chafarlo con b.
		a=b;
		b=aux;
		
		// Mostramos las variables por pantalla
		System.out.println("a: "+a);
		System.out.println("b: "+b);

	}

}
