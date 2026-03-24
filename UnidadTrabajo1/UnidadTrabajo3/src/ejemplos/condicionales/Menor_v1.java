package ejemplos.condicionales;

public class Menor_v1 {

	/**
	 * Función que devuelve un número aleatorio entre 1 y N
	 * @param N - límite superior
	 * @return número aleatorio tipo entero
	 */
	public static int aleatorio(int N) {
		return (int)(Math.random()*N+1);
	}
	
	/**
	 * Función que devuelve un número menor entre dos números
	 * @param x - número entero
	 * @param y - número entero
	 * @return número entero menor de dos
	 */
	public static int menor(int x, int y) {
		if (x<y){					
			return x;	
		}			
		return y; 		// Mejor poner así de momento para asimilar bien
	}	
	
	/* También se puede poner así de forma reducida pero cuando solo hay una orden en el cuerpo del condicional
	public static int menor(int x, int y) {
		if (x<y)
			return x;				
		return y; 		// Importante la TABULACION en esta linea que indica que omitimos el ELSE pero significa lo mismo
	}	
	*/
	
	// Programa principal
	public static void main(String[] args) {
		// Declaramos e inicializamos las variables
		int a=aleatorio(10);
		int b=aleatorio(10);
		
		System.out.println("Valores: "+a+" , "+b);
		System.out.println("Menor: "+menor(a,b));
	
	}
}