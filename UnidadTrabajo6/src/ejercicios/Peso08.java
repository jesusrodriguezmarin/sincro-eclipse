package ejercicios;

public class Peso08 {

	// Atributo
	private double peso;

	/**
	 * Constructor que recibe un peso y en la medida que está tomado y lo devuelve en kg
	 * @param dato - pesaje double
	 * @param tipo - medida tomada String
	 */
	public Peso08(double dato, String tipo) {
		
		if (tipo.equals("Lb")) {
			peso = dato * 0.453;
		} else if (tipo.equals("Li")) {
			peso = dato * 14.59;
		} else if (tipo.equals("Oz")) {
			peso = dato * 0.02835;
		} else if (tipo.equals("P")) {
			peso = dato * 0.00155;
		} else if (tipo.equals("K")) {
			peso = dato;
		} else if (tipo.equals("G")) {
			peso = dato / 1000;
		} else if (tipo.equals("Q")) {
			peso = dato * 43.3;
		}
	}

	/**
	 * Recibe un dato en kg y devuelve el equivalente en libras
	 * 
	 * @return equivalente de kg a libras tipo double
	 */
	public double getLibras() {
		return peso / 0.453;
	}
	
	/**
	 * Recibe un dato en kg y devuelve el equivalente n lingotes
	 * @return peso en lingotes double
	 */
	public double getLingotes() {
		return peso / 14.59;
	}
	
	public double getOnzas() {
		return peso / 0.02835;
	}
	
	public double getPeniques() {
		return peso / 0.00155;
	}
	
	public double getKilos() {
		return peso;
	}
	
	public double getGramos() {
		return peso * 1000;
	}
	
	public double getQuintales() {
		return peso / 43.3;
	}
	
	/**
	 * Devuelve el peso en la medida que se especifique como parámetro String
	 * @param tipo String
	 * @return el peso double convertido a la medida que se le pasa como parámetro 
	 */
	public double getPeso(String tipo) {

		// Filtramos por el String y convertimos el dato recibido (kg) al tipo pasado por parámetro
		if (tipo.equals("Lb")) {
			return getLibras();
		} else if (tipo.equals("Li")) {
			return getLingotes();
		} else if (tipo.equals("Oz")) {
			return getOnzas();
		} else if (tipo.equals("P")) {
			return getPeniques();
		} else if (tipo.equals("K")) {
			return getKilos();
		} else if (tipo.equals("G")) {
			return getGramos();
		} else if (tipo.equals("Q")) {
			return getQuintales();
		} else {
			// Controlamos si el tipo introducido no existe
			return 0;
		}
	}

}
