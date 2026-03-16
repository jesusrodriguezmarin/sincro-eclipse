package ejemplos.apuntes.condicionales;

public class MayorDeDos_func_aleat_v2 {

	public static void main(String[] args) {
		// Llamada a las funciones de otros programas
		int a = MayorDeDos_aleatorio.aleatorio(50);
		int b = MayorDeDos_aleatorio.aleatorio(50);
		
		System.out.println("Valores: "+a+" y "+b);
		System.out.println("El mayor es: "+MayorDeDos_func_aleat.mayor(a, b));
	}

}
