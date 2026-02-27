package funcionesGlobales;

public class funcionMayorTres {

	/**
	 * Función que devuelve el mayor de tres números pasados por parámetro
	 * @param x - número entero
	 * @param y - número entero
	 * @param z - número entero
	 * @return el mayor de tres números enteros
	 */
	public static int mayor(int x, int y, int z) {
		if (x>=y && x>=z) {
			return x;
		} else if (y>=x && y>=z) {
			return y;
		} else
			return z;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
