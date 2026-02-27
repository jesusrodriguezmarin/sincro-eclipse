package strings.cifrado;

public class abecedario {

	public static void main(String[] args) {

		// Recorremos los caracteres desde la 'a'=65 hasta la 'z' 91
		for (int i = 65; i < 91; i++) {
			// Hacemos un casting a la iteración para que muestre el caracter
			System.out.print((char) i);
		}

		System.out.println();

		// Recorremos de igual modo que el anterior pero poniendo los caracteres
		for (int i = 'A'; i <= 'Z'; i++) {
			// De igual modo debemos realizar el casting
			System.out.print((char)i);
		}

		System.out.println("\nEncriptado CESAR3");
		// Declaramos un caracter para inicializarlo en la iteracion mas la clave (3)
		int caracter;
		// Recorremos 
		for (int i = 'A'; i <= 'Z'; i++) {
			// El caracter es la iteracion +3 en cada vuelta
			caracter = i + 3;
			// Controlamos que si es mayor que la última se le reste toda la cantidad
			// Se hace así circular
			if ((char) caracter > 'Z')
				caracter -= 26;
			
			// Mostramos cada iteración formando la nueva palabra encriptada
			System.out.print((char) caracter);
		}
		
	}

}
