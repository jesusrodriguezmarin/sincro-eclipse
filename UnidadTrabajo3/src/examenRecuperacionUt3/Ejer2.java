package examenRecuperacionUt3;

public class Ejer2 {

	public static void main(String[] args) {
		// variable para tamaño
		int tam = 4;
		// bucle para filas
		for (int i = 1; i <= tam - 1; i++) {
			// bucle para espacios
			for (int j = tam - 1; j >= i; j--)
				System.out.print(" ");
			// bucle para asteriscos
			for (int j = 1; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}
		// bucle para filas
		for (int i = 1; i <= tam; i++) {
			// bucle para espacios
			for (int j = 1; j <= i - 1; j++)
				System.out.print(" ");
			// bucle para asteriscos
			for (int j = tam; j >= i; j--)
				System.out.print("*");
			System.out.println();
		}

	}

}
