package ejemplos.condicionales;

public class Par_v2_fPar {

	public static boolean esPar(int numero) {
		if (numero%2==0)
			return true;
		return false;
		
	}
	public static void main(String[] args) {
		// generamos el valor aleatorio entre 1 y 50
		int num1=Mayor_v3_fAleatorio.aleatorio(50);
		int num2=Mayor_v3_fAleatorio.aleatorio(50);
		int num3=Mayor_v3_fAleatorio.aleatorio(50);
		
		// indicamos si el número es par o impar
		if (esPar(num1)==true)
			System.out.println(num1+" es PAR");
		else
			System.out.println(num1+" es IMPAR");
		if (esPar(num2)==true)
			System.out.println(num2+" es PAR");
		else
			System.out.println(num2+" es IMPAR");
		if (esPar(num3)==true)
			System.out.println(num3+" es PAR");
		else
			System.out.println(num3+" es IMPAR");
		
	}

}
