package funcionesGlobales;

public class funcionMenorTres {

	/**
	 * Función que devuelve el menor de tres números enteros
	 * @param x - número entero
	 * @param y - número entero
	 * @param z - número entero
	 * @return devuelve el menor de tres números enteros
	 */
	public static int menor(int x, int y, int z) {
		if (x<y) {
			if (x<y)
				return x;
			else
				return z; 
		} else if (y<z)
			return y;
		else
			return z;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
