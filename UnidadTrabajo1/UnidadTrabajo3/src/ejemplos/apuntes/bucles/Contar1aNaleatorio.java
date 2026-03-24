package ejemplos.apuntes.bucles;

public class Contar1aNaleatorio {

	/**
	 * Función que devuelve un número entero aleatorio
	 * @param N - número entero límite superio
	 * @return un número entero aleatorio
	 */
	public static int aleatorio(int N) {
		return (int)(Math.random()*N+1);
	}
	
	// Programa principal
	public static void main(String[] args) {
		// Declaración e inicialización de un num aleatorio llamando a función
		int num = aleatorio(25);
		int conta;
		
		// Con WHILE
		System.out.println("Contamos del 1 al "+num+" con WHILE");
		conta = 1;
		while (conta <= num) {
			System.out.print(conta+" ");
			conta++;
		}
		
		// Con DO WHILE
		System.out.println("\n\nContamos desde 1 hasta "+num+" con DO WHILE");
		conta = 1;
		do {
			System.out.print(conta+" ");
			conta++;
		} while (conta <= num);
		
		// Con FOR
		System.out.println("\n\nContamos de 1 a "+num+" con FOR");
		for (conta = 1; conta <= num; conta++)
			System.out.print(conta+" ");

	}

}
