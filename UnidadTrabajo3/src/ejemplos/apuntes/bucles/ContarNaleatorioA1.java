package ejemplos.apuntes.bucles;

public class ContarNaleatorioA1 {

	public static void main(String[] args) {
		// Llamamos función de otra clase
		// Declaración e inicialización de variable
		int num = Contar1aNaleatorio.aleatorio(25);
		
		// Bucle para contar de num a 1 con WHILE
		System.out.println("Contamos desde "+num+" a 1 con WHILE");
		while (num >= 1) {
			System.out.print(num+" ");
			num--;
		}
		
		// Bucle con DO WHILE
		num = Contar1aNaleatorio.aleatorio(25);
		System.out.println("\n\nContamos desde "+num+" hasta 1 con DO WHILE");
		do {
			System.out.print(num+" ");
			num--;
		} while (num >= 1);
		
		// Bucle con FOR
		System.out.println("\n\nContamos descendente hasta 1 con FOR");
		for (num = Contar1aNaleatorio.aleatorio(25); num >=1; num--)
			System.out.print(num+" ");

	}

}
