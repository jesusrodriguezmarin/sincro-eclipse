package ejercicios;

public class MillasMetros07 {
	
	/**
	 * Recibe un dato int en millas y devuelve el equivalente en metros
	 * @param millas - int
	 * @return un double que corresponde a los metros equivalentes a las millas pasadas por parámetro
	 */
	public double millasAMetros(int millas) {
		return millas*1852;
	}
	
	/**
	 * Recibe un dato double millas y devuelve el equivalente en kms
	 * @param millas - int
	 * @return double equivalente en kms de las millas introducidas
	 */
	public double millasAKm(int millas) {
		return millas*1852/1000;
	}
	
}
