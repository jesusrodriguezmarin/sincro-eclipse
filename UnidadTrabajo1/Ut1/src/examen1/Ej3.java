package examen1;

public class Ej3 {

	public static void main(String[] args) {

		// Declaración e inicialización
		double precio=85;
		int descuento=30;
		double porcentaje;
		double descontado;
		
		// Cálculo del porcentaje de descuento
		porcentaje=precio*descuento/100;
		descontado=precio-porcentaje;
		
		// Resultado impreso en pantalla
		System.out.println("Precio (€): "+precio);
		System.out.println("Descuento (%): "+descuento);
		System.out.println("Precio rebajado (€): "+descontado);			
	}

}
