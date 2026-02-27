package ejemplos.ejercicios;

public class Ejer16buclesArbol_v3 {

	public static void main(String[] args) {
		// bucle
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= 4-i; j++)
				System.out.print("*");
			System.out.println();
		}

	}

}
