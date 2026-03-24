package ejemplos.condicionales;

public class Par_v3 {

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
		int num4=Mayor_v3_fAleatorio.aleatorio(50);
				
		System.out.println("Valores: "+num1+" "+num2+" "+num3+" "+num4);
		System.out.print("PARES: ");			// Quito el ln para que aparezca todo en la misma línea
		
		if (esPar(num1))
			System.out.print(num1+" ");			// Imprime en la misma línea de arriba
		if (esPar(num2))
			System.out.print(num2+" ");			// Imprime en la misma línea de arriba
		if (esPar(num3))
			System.out.print(num3+" ");			// Imprime en la misma línea de arriba
		if (esPar(num4))
			System.out.print(num4+" ");			// Imprime en la misma línea de arriba
	}

}
