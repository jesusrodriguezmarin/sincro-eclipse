package ejemplos.sorteo;

public class Dado extends Sorteo {

	// Constructor
	public Dado() {
		super.posibilidades = 6;
	}

	/**
	 * Devuelve el resultado de lanzar un dado de manera aleatoria
	 * {String}
	 */
	public String lanzar() {
		int num;
		num = (int) (Math.random() * posibilidades + 1);

		String res = "";
		switch (num) {
		case 1: res= "UNO";

			break;
		case 2: res= "DOS";

			break;
		case 3: res= "TRES";

			break;
		case 4: res= "CUATRO";

			break;
		case 5: res= "CINCO";

			break;
		case 6: res= "SEIS";

			break;
		}
		return res;
	}
}
