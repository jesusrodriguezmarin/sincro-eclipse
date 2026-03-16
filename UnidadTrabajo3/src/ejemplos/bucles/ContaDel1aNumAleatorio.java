package ejemplos.bucles;

public class ContaDel1aNumAleatorio {

	public static void main(String[] args) {
		// Generamos un número aleatorio entre 1 y 25
		int num = (int) (Math.random() * 25 + 1);

		// Contamos desde 1 a num con un bucle WHILE
		System.out.println("Contamos del 1 al " + num + " con WHILE: ");
		int conta = 1;

		while (conta <= num) {
			System.out.print(conta + " ");
			conta++;
		}
		
		// Contamos desde 1 a num con un bucle DO..WHILE
		System.out.println("\n\nContamos del 1 al " + num + " con DO..WHILE: ");
		conta=1;
		do { 
			System.out.print(conta + " ");	
			conta++;
		} while (conta<=num);
		
		// Contamos desde 1 a num con un bucle FOR
		System.out.println("\n\nContamos del 1 al " + num + " con FOR: ");
		for (conta=1; conta<=num; conta++)
			System.out.print(conta + " ");	
	}

}
