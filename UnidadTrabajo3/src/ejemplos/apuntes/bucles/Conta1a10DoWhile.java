package ejemplos.apuntes.bucles;

public class Conta1a10DoWhile {

	public static void main(String[] args) {
		// Declaración de la variabe contadora
		int conta;
		
		// Bucle con do while 1 a 10
		System.out.println("Cuenta desde 1 hasta 10:");
		conta = 1;
		do {
			System.out.println(conta++);
		} while (conta <= 10);
		
		// Bucle con do while 10 a 1
		System.out.println("Cuenta de 10 a 1");
		conta = 10;
		do {
			System.out.println(conta--);
		} while (conta >= 1);

	}

}
