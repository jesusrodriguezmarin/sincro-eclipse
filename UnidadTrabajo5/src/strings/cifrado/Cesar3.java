package strings.cifrado;

public class Cesar3 {

	private static final int CLAVE=3;	// Clave a aplicar para el cifrado
	
	public static void main(String[] args) {
		
		// Bucles para imprimir el abecedario
		System.out.println("Abecedario:");
		for (int i = 65; i < 91; i++) {
			System.out.print((char) i);
		}
		
		// Método de sustitución
		System.out.println("\n\nEncriptado CESAR3:");

		for (int i = 'a'; i <= 'z'; i++) {
			System.out.print((char)i);
		}
		System.out.println();

		int caracter;
		for (int i = 'a'; i <= 'z'; i++) {
			caracter = i + CLAVE;
			if ((char) caracter > 'z')
				caracter -= 26;
			System.out.print((char) caracter);
		}

		System.out.println("\n\nEncriptado CESAR3:");

		for (int i = 'A'; i <= 'Z'; i++) {
			System.out.print((char) i);
		}
		System.out.println();

		for (int i = 'A'; i <= 'Z'; i++) {
			caracter = i + CLAVE;
			if ((char) caracter > 'Z')
				caracter -= 26;
			System.out.print((char) caracter);
		}
	}

}
