package ejercicios;

public class FinanzasTest04 {

	public static void main(String[] args) {
		
		// Creamos una instancia de Finanzas para realizar cambios utilizando sus métodos de cambio
		Finanzas04 f = new Finanzas04();
		
		// Declaramos e inicializamos las variables
		double misdolares = 50;
		double miseuros = f.dolarToEuro(misdolares);
		System.out.println(misdolares);
		System.out.println(miseuros);
		System.out.println(f.EuroToDolar(miseuros));
		

	}

}
