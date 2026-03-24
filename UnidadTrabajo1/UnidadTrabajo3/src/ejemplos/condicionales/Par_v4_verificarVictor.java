package ejemplos.condicionales;

public class Par_v4_verificarVictor {

	public static void main(String[] args) {
		
		// Generamos el valor aleatorio entre 1 y 50 llamando a la función global Mayor_v3_fAleatorio.aleatorio()
		int num1=Mayor_v3_fAleatorio.aleatorio(50);
		int num2=Mayor_v3_fAleatorio.aleatorio(50);
		int num3=Mayor_v3_fAleatorio.aleatorio(50);
		int num4=Mayor_v3_fAleatorio.aleatorio(50);
				
		System.out.println("VALORES: "+num1+" "+num2+" "+num3+" "+num4);
		System.out.print("PARES: ");			// Quito el ln para que aparezca todo en la misma línea
		
		// Llamamos a la función global para el número par Par_v2_fPar.esPar() e imprimimos el par
		if (Par_v2_fPar.esPar(num1))
			System.out.print(num1+" ");			// Sin ln Imprime en la misma línea de arriba	
		if (Par_v2_fPar.esPar(num2))
			System.out.print(num2+" ");			// Sin ln Imprime en la misma línea de arriba
		if (Par_v2_fPar.esPar(num3))
			System.out.print(num3+" ");			// Sin ln Imprime en la misma línea de arriba
		if (Par_v2_fPar.esPar(num4))
			System.out.print(num4+" ");			// Sin ln Imprime en la misma línea de arriba
		System.out.println();					// para hacer salto de línea
		
		System.out.print("IMPARES: ");	
		
		// Imprimimos el impar
		if (Par_v2_fPar.esPar(num1)) {	
		} else {
			System.out.print(num1+" ");
		}
		if (Par_v2_fPar.esPar(num2)) {	
		} else {
			System.out.print(num2+" ");
		}
		if (Par_v2_fPar.esPar(num3)) {	
		} else {
			System.out.print(num3+" ");
		}
		if (Par_v2_fPar.esPar(num4)) {	
		} else {
			System.out.print(num4+" ");
		}
	}

}
