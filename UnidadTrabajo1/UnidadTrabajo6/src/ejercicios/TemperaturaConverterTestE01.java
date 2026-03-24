package ejercicios;

public class TemperaturaConverterTestE01 {

	public static void main(String[] args) {
		
		// Creamos una instancia de temperaturaConverter
		TemperaturaConverterE01 t = new TemperaturaConverterE01();
		
		// Realizamos comprobaciones de cambios de temperaturas en ambas direcciones
		System.out.println("0º Celsius = "+t.celsiusToFarenheit(0)+" Fareheit");
		System.out.println("0º Farenheit = "+t.farenheitToCelsius(0)+" Celsius");
		System.out.println("25º Celsius = "+t.celsiusToFarenheit(25)+" Farenheit");
		System.out.println("25º Farenheit = "+t.farenheitToCelsius(25)+" Celsius");
		System.out.println("-4º Celsius = "+t.celsiusToFarenheit(-4)+" Farenheit");
		System.out.println("77 Farenheit = "+t.farenheitToCelsius(77)+" Celsius");

	}

}
