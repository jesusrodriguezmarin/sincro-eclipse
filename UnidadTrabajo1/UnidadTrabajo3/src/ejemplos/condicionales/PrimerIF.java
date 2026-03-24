package ejemplos.condicionales;

public class PrimerIF {

	public static void main(String[] args) {
		// Declaración e inicialización de la variable
		int a=5; 
		
		// Ejemplo de condicional simple
		if (a==5) {
			System.out.println("La variable es igual a 5");
		}
		
		// Ejemplo de condicional compuesto
		if (a>6) {
			System.out.println("La variable es mayor que 6");	
		} else {
			System.out.println("La variable es menor que 7");
		}
		
		// Ejemplo condicional anidado
		if (a>6) {
			System.out.println("La variable es mayor que 6");
		} else if (a==6) {
			System.out.println("La variable es igual a 6");
		} else {
			System.out.println("La variable es menor que 6");
		}
		
	}
}