package ejemplos.apuntes.bucles;

public class ContarImpar50 {

	public static void main(String[] args) {
		// Declaración de variable contador
		int conta;
		// Con while inicialización de variable contador par (conta+= 2)
		conta = 1;
		while (conta <= 50) {
			System.out.print(conta+" ");
			conta+= 2;
		}
		// Salto de linea
		System.out.println();
		
		// Con while e if para par (conta % 2! = 0)
		conta = 1;
		while (conta <= 50) {
			if (conta % 2 != 0)
				System.out.print(conta+" ");
			conta++;
		}

	}

}
