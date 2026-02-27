package ejemplos.apuntes.bucles;

public class TablasMultiplicar {

	/**
	 * Procedimiento que muestra tabla de multiplicar
	 * @param N - número pasado por parámetro
	 */
	public static void tabla(int N) {
		for (int conta = 1; conta <= 10; conta++)
			System.out.println(N+" x "+conta+" = "+(N*conta));
	}
	
	// Programa principal
	public static void main(String[] args) {
		// Bucle con for y llamada al procedimiento tabla
		for (int num = 1; num <= 11; num++) {
			tabla(num);
			System.out.println();
		}

	}

}
