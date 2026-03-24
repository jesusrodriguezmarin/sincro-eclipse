package ejemplos.bucles;

public class ContaDeNum1aNum2 {

	public static int aleatorio(int N) {
		return (int)(Math.random()*N+1);
	}
	
	public static void main(String[] args) {
		// Generamos un núnero aleatorio entre 1 y 25
		int a=aleatorio(50);
		int b=aleatorio(50);
		
		
		System.out.println("Contamos desde: "+a+" a "+b);
		// 	Si (a) es mayor que (b) la cuenta es ascendente
		if (a<b) {
			for (int conta=a; conta<=b; a++)
			System.out.print(conta+" ");
		} else {
			// Si (a) es mayor o igual que (b), la cuenta es descendente
		for (int conta=a; conta>=b; conta--)
			System.out.print(conta+" ");
		
		// HAY BUCLE INFINITO, ARREGLAR
		
		}
		
	}

}
