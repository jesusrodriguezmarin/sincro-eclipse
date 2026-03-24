package ejercicios2;

public class Cuenta {

	// Atributos
	private String titular;
	private double cantidad;
	
	/**
	 * Conetructor con dos parámetros
	 * @param titular - String
	 * @param cantidad - double
	 */
	public Cuenta(String titular, double cantidad) {
		this.titular = titular;
		this.cantidad = cantidad;
	}
	
	/**
	 * Conetructor un parámetro
	 * @param titular - String
	 */
	public Cuenta(String titular) {
		this.titular = titular;
		this.cantidad = 0;
	}

	/**
	 * Muestra el titular de la cuenta
	 * @return - String - el titular de la cuenta
	 */
	public String getTitular() {
		return titular;
	}

	/**
	 * Establece el titular de la cuenta
	 * @param titular - String
	 */
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	/**
	 * Muestra la cantidad de la cuenta
	 * @return - double - la cantidad de la cuenta
	 */
	public double getCantidad() {
		return cantidad;
	}
	
	/**
	 * Establece la cantidad de cuenta
	 * @param cantidad - double - de la cuenta
	 */
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Muestra el titular y la cantidad de la cuenta
	 */
	public String toString() {
		return "Cuenta [titular=" + titular + ", cantidad=" + cantidad + "]";
	}
	
	/**
	 * Ingresamos una cantidad pasada por parámetro al total de la cuenta
	 * Si el dato pasado por parámetro es negativo, no ingresamos nada
	 * @param dato double a ingresar en cuenta
	 */
	public void ingresar(double dato) {
		if (dato > 0) {
			cantidad += dato;
		} else {
			
			System.out.println("No se puede ingresar una cantidad negativa.");
		}
	}
	
	/**
	 * Retiramos una cantidad pasada por parámetro de la cuenta
	 * Si la cantidad deja la cuenta en negativo, la establece en 0
	 * @param dato double a retirar
	 */
	public void retirar(double dato) {
		cantidad -= dato;
		if (cantidad < 0) {
			cantidad = 0;
		}
	}
	
}
