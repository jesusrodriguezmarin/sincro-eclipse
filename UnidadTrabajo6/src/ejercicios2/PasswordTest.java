package ejercicios2;

public class PasswordTest {

	public static void main(String[] args) {
		
		// Creamos una instancia password
		Password p = new Password("Charlie");
		
		// Realizamos pruebas
		System.out.println(p.getContraseña());
		System.out.println("La longitud es: "+p.getLongitud());
		if (p.esFuerte()) {
			System.out.println("Es fuerte");
		} else {
			System.out.println("No es fuerte, cambiala.");
		}
		p.cambiar("Charlie");
		p.cambiar("Charliess");
		System.out.println("Nueva password: "+p.getContraseña());
		if (p.esFuerte()) {
			System.out.println("Es fuerte");
		} else {
			System.out.println("No es fuerte, cambiala.");
		}

	}

}
