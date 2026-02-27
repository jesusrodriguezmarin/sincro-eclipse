package ejemplos.condicionales;

public class Mayor3_v1bien {

	public static int mayor(int x, int y, int z) {
		if (x>y) {
			if (x>y)
				return x;
			else
				return z; 
		} else if (y>z)
			return y;
		else
			return z;
		}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Declaración de variables 
		int a, b, c;
		// Llamada a fúncion public aleat para cada variable
		a=Mayor3_v1.aleat(10);
		b=Mayor3_v1.aleat(10);
		c=Mayor3_v1.aleat(10);
				
		// Llamada a función de mayor para mostrar en pantalla
		int mayor=Mayor3_v1.mayor(a, b, c);
				
		// Muestra los tres valores aleatorios en pantalla
		System.out.println("Valores: "+a+" "+b+" "+c);
		// Muestra la función de mayor en pantalla
		System.out.println("Mayor: "+mayor);
	}

}
