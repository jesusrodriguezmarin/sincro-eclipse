package ejemploBoletinUt3;

public class Ejer2 {

	public static void main(String[] args) {
		final int TAM = 8;
		// bucle para controlar las filas hasta la mitad
		for (int i = 1; i <= TAM; i++) {
			
			// imprimimos espacios en blanco por cada fila
			int espacios = TAM - i;
			for (int j = 1; j <= espacios; j++)
				System.out.print(" ");
			
			// calcculamos el numero de asteriscos por linea e imprimimos
			int asteriscos = 2 * i - 1;
			for (int j = 1; j <= asteriscos; j++)
				System.out.print("*");
			
			// salto de linea
			System.out.println();
		}
		
		
		// Bucle para controlar las siguientes filas
		for (int i = TAM - 1; i >= 1; i--) {
			
			// bucle para controlar espacios
			int espacios = TAM - i;
			for (int j = 1; j <= espacios; j++)
				System.out.print(" ");
			
			// bucle para controlar asteriscos
			int asteriscos = 2 * i - 1;
			for (int j = 1; j <= asteriscos; j++)
				System.out.print("*");
			
			System.out.println();
		}
			
	}

}
