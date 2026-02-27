package ejemplos.apuntes.bucles;

public class Contar1a10while {

	public static void main(String[] args) {
		// Declaración de variable contador
		int conta;
		
		// Muestra de cuenta desde 1 hasta 10
		System.out.println("Cuenta desde 1 hasta 10 :");
		conta = 1;
		while (conta <= 10) {
			System.out.print(conta+" ");
			conta++;
		}
		// Muesta de cuenta desde 10 hasta 1
		System.out.println("\n\nCuenta desde 10 hasta 1: ");
		conta = 10;
		while (conta >= 1) {
			System.out.print(conta+" ");
			conta--;
		}

	}

}
