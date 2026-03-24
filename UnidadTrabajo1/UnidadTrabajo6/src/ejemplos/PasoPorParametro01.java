package ejemplos;

public class PasoPorParametro01 {

	/**
	 * Función que incrementa en una unidad el valor pasado por parámetro
	 * @param valor - entero a incrementar
	 * @return el valor incrementado
	 */
	static int incrementa(int valor) {
		valor++;
		return valor;
	}
	
	public static void main(String[] args) {
		
		// Variables con asignación directa y asignación por funcion
		int a = 5;
		int b = incrementa(a);
	
		// Se pueden comparar con == porque son enteros;
		if (a==b) {
			System.out.println(a+" y "+b+" son iguales");
		} else {
			System.out.println(a+" y "+b+" son distintos");
		}

	}

}
