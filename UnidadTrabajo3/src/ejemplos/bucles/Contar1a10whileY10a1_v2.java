package ejemplos.bucles;

public class Contar1a10whileY10a1_v2 {

	public static void main(String[] args) {
		// Declaramos e inicializamos una variable contadora (contador)
		int conta=1;
		
		// Mostramos la cuenta desde el 1 hasta el 10 
		System.out.print("Contamos del 1 al 10: ");
		while (conta<=10) {
			System.out.print(" "+conta++);
		}
		// Mostramos la cuenta desde el 1 hasta el 10 
		System.out.print("\nContamos del 10 al 1: ");
		conta=10;
		while (conta>=1) {
			System.out.print(" "+conta--);
		}
		
	}

}
