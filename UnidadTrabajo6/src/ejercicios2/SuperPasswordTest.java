package ejercicios2;

public class SuperPasswordTest {

	public static void main(String[] args) {
		
		// Creamos una instancia con constructor por defecto
		SuperPassword s = new SuperPassword();
		
		// Creams otra instancia con constructor con parámetros
		SuperPassword p = new SuperPassword(10);
		
		System.out.println(s.getContraseña());
		System.out.println(p.getContraseña());
		
		if (s.esFuerte()) {
			System.out.println("Yesss");
		}
		if (p.esFuerte())
			System.out.println("yesssss");

	}

}
