package ejemplos.ejercicios;

public class Ejer17bucleArbol {

	public static void main(String[] args) {
		final int TAM = 4;
		// bucle para nº filas
		for (int i = 1; i <= TAM; i++) {
			
			// imprimimos espacios en blanco
			int espacios = TAM - i;
			for ( int j = 1; j <= espacios; j++)
				System.out.print(" ");
			
			// imprimimos los astericos
			for (int j = 1; j <= i; j++)
				System.out.print("*");
			
			// salto de linea
			System.out.println();
		}

	}

}
