package ejemplos.condicionales;

public class Mayor4_v1 {

	public  static int mayor(int x, int y) {
		if (x>y)
			return x;
		return y;
	}
	/**
	 * Función para el mayor de tres valores enteros pasados por parámetros
	 * @param x
	 * @param y
	 * @param z
	 * @return el mayor valor entre x, y, z.
	 */
	public static int mayor(int x, int y, int z) {
		return mayor(mayor(x, y), z);
	}
	
	public static int mayor(int x, int y, int z, int v) {
		return mayor(mayor(x, y, z), v);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b, c, d;
		// Llamada a fúncion public aleat para cada variable
		a=Mayor3_v1.aleat(10);
		b=Mayor3_v1.aleat(10);
		c=Mayor3_v1.aleat(10);
		d=Mayor3_v1.aleat(10);
		
		// Muestra los tres valores aleatorios en pantalla
		System.out.println("Valores: "+a+" "+b+" "+c);
		// Muestra la función de mayor en pantalla
		System.out.println("El mayor entre "+a+" y "+b+": "+mayor(a, b));
		System.out.println("El mayor entre "+a+" y "+c+": "+mayor(a, c));
		System.out.println("El mayor entre "+b+" y "+c+": "+mayor(b, c));
		System.out.println("El mayor entre "+a+" y "+b+": "+mayor(a, b, c));
		System.out.println("El mayor entre "+a+" y "+b+": "+mayor(a, b, c, d));	// Esta es la línea que cambia en el _v2
	}

}
