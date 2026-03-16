package abstractEjemplo;

public class Dado extends Sorteo {

	/**
	 * Constructor
	 */
	Dado() {
		posibilidades = 6;
	}

	/**
	 * Devuelve el resultado de lanzar un dado
	 */
	public String lanzar() {
		int num = (int) (Math.random() * posibilidades + 1);
		String resultado = "";
		switch (num) {
		case 1:
			resultado="Uno";
			break;
		case 2:
			resultado="Dos";
			break;
		case 3:
			resultado="Tres";
			break;
		case 4:
			resultado="Cuatro";
			break;
		case 5:
			resultado="Cinco";
			break;
		case 6:
			resultado="Seis";
			break;
		}
		return resultado;
	}
}
