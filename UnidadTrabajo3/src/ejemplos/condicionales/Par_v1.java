package ejemplos.condicionales;

public class Par_v1 {

	public static void main(String[] args) {
		// generamos el valor aleatorio entre 1 y 50
		int num=Mayor_v3_fAleatorio.aleatorio(50);
		
		// indicamos si el número es par o impar
		if (num%2==0)
			System.out.println(num+" es PAR");
		else
			System.out.println(num+" es IMPAR");
	}

}
