package ejemplos.bucles;

public class ContarImpares50 {

	public static void main(String[] args) {
		int conta;
		
		// 1ª Forma
		conta=1;
		while (conta<=50) {
			if (conta%2!=0)
				System.out.print(conta+" ");
			conta++;
		}
		
		System.out.println();
		
		// 2ª Forma
		conta=1;
		while (conta<=50) {
				System.out.print(conta+" ");
			conta+=2;
		}
			
		System.out.println();

		// 3ª Forma
		conta=1;
		do {
			System.out.print(conta+" ");
			conta+=2;
		} while (conta<=50);
		
		System.out.println();
		
		// 4ª Forma
		for (conta=1; conta<=50; conta+=2)
			System.out.print(conta+" ");
	}

}
