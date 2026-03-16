package ejemplos.ejercicios;

public class Ejer19de1a100 {

	public static void main(String[] args) {
		// bucle para mostrar nºs del 1 al 100
		for (int i = 1; i <= 100; i++)
			// condicional para excluir los multiplos de 5
			if (i % 5 != 0) {
			System.out.print(i+" ");
			}
	}

}
