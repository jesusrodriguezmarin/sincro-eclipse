package ejemplos.condicionales;

public class Mayor3_v2 {

	// Programa principal llama 2 funiones public
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
