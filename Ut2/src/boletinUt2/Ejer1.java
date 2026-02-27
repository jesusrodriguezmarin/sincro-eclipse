package boletinUt2;

public class Ejer1 {

	
	/**
	 * Funcion que cálcula el vulumen de una esfera
	 * @param radio variable tipo int
	 * @return resultado de la formula de la esfera tipo double
	 */
	public static double volumen(int radio) {
		final double PI=3.1416;
		return (double)4/3*PI*radio*radio*radio;
	}
	
	// Programa principal
	public static void main(String[] args) {

		int r=3;
		// Llamada de la funcion del volumen
		System.out.println("Radio:"+r);
		System.out.println("Volumen de la esfera: "+volumen(r));
			
		}
	}

