package ejemplos.bucles;

public class Contar1a10dowhile {

	public static void main(String[] args) {
		// Declaramos la variable contadora
		int conta;
		
		// Mostramos la cuenta del 1 hasta el 10
		System.out.println("Cuenta del 1 hasta el 10: ");
		conta=1;
		do {
			System.out.println(conta);
			conta++;
		} while (conta<=10);
		
		// Mostramos la cuenta del 10 hasta el 1
		System.out.println("\nCuenta del 10 hasta el 1: ");
		conta=10;
		do {
			System.out.println(conta);
			conta--;
		} while (conta>=1);
	}

}
