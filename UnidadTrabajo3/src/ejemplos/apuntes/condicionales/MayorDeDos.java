package ejemplos.apuntes.condicionales;

public class MayorDeDos {

	public static void main(String[] args) {
		// Declaración e inicialización de variable
		int a = 15;
		int b = 5;
		
		// Comparación e impresión
		if (a > b) {
			System.out.println(a+" mayor que "+b);
		} else if (a == b) {
			System.out.println(a+" igual que "+b);
		} else {
			System.out.println(b+" es mayor que "+a);
		}

	}

}
