package ejemplos.bucles;

public class Contar1a10for {

	public static void main(String[] args) {
		// Contamos del 1 al 10 con un bucle for
		System.out.println("Cuenta del 1 hasta el 10: ");
		for(int conta=1; conta<=10; conta++) {	// Al estar definida la variable int conta=1 dentro del bloque, cuando termina el bloque no existe
			System.out.println(conta);
		}
		
		// Contamos del 1 al 10 con un bucle for
		System.out.println("\nCuenta del 10 hasta el 1: ");
		for(int conta=10; conta>=1; conta--)	// Volvemos a declarar conta=10
			System.out.println(conta);
	}

}
