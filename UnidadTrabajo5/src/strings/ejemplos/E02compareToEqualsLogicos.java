package strings.ejemplos;

public class E02compareToEqualsLogicos {

	public static void main(String[] args) {
		// Creamos String 
		String nombre1 = "Juan";
		String nombre2 = "Juan";
		String nombre4 = "juan";
		
		// compareTo()
		System.out.println("Comparamos...");
		if (nombre1.compareTo(nombre2)==0) {
			System.out.println("Son iguales numéricamente");
		} else {
			System.out.println("Nada que ver");
		}
		if (nombre1.compareTo(nombre4)==0) {
			System.out.println("Son iguales");
		} else {
			System.out.println("Nada que ver numéricamente");
		}
		
		// equals()
		if (nombre1.equals(nombre2)==true) {
			System.out.println("Son iguales boolean");
		} else {
			System.out.println("Nada que ver");
		}
		if (nombre1.equals(nombre4)==true) {
			System.out.println("Son iguales");
		} else {
			System.out.println("Nada que ver boolean");
		}
		
		// igualdad ==
		if (nombre1==nombre2) {
			System.out.println("Son iguales con ==");
		}
		if (nombre1!=nombre4) {
			System.out.println("Nada que ver con !=");
		}
	}

}
