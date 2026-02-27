package ejemplos.RepasoUt3;

public class Arbol {

	public static void main(String[] args) {
		final int TAM = 4;
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
		
	}

}
