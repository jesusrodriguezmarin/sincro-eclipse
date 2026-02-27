package ejemplos.ejercicios;

public class Ejer18bucleArbo_v2 {

	public static void main(String[] args) {
		final int TAM = 4;
		// bucle para nº filas
		for (int i = 1; i <= TAM; i++) {
			
			// imprimimos espacios en blanco
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
			// bucle para el tronco
			int espTronco = TAM - 1;
			int largoTronco = 2;
			for (int i = 1; i <= largoTronco; i++) {
				for (int j = 1; j <= espTronco; j++) {
					System.out.print(" ");
				}
				
			// impresion del asterisco del tronco
			System.out.println("*");
		
		} 

	} 

}
