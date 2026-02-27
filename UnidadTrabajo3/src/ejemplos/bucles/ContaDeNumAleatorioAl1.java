package ejemplos.bucles;

public class ContaDeNumAleatorioAl1 {

	public static void main(String[] args) {
		// Generamos un número aleatorio entre 1 y 25
		int num = (int) (Math.random() * 25 + 1);

		// Contamos desde 1 a num con un bucle WHILE
		System.out.println("Contamos del: "+num+ " al 1 con WHILE: ");
		int conta=num;

		while (conta>=1) {
			System.out.print(conta + " ");
			conta--;
		}
		
		// Contamos desde 1 a num con un bucle DO..WHILE
		System.out.println("\n\n\"Contamos del: "+num+" al 1 con DO..WHILE: ");
		conta=num;
		do { 
			System.out.print(conta + " ");	
			conta--;
		} while (conta>0);
		
		// Contamos desde 1 a num con un bucle FOR
		System.out.println("\n\n\"Contamos del: "+num+" al 1 con FOR: ");
		for (conta=num; conta>=1; conta--)
			System.out.print(conta + " ");	
	}

}
