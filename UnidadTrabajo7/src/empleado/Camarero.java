package empleado;

public class Camarero extends Empleado {

	// Atibutos
	private double propina;

	/**
	 * Constructor con 2 parámetros
	 * @param nombre
	 * @param propina
	 */
	public Camarero(String nombre, double propina) {
		super(nombre);
		this.propina = propina;
	}

	/**
	 * Constructor con 3 parámetros
	 * @param nombre
	 * @param propina
	 * @param horas
	 */
	public Camarero(String nombre, int horas, double propina) {
		super(nombre, horas);
		this.propina = propina;
	}

	/**
	 * Devuelve la propina del camarero
	 * @return {double} propina del camarero
	 */
	public double getPropina() {
		return propina;
	}

	/**
	 * Establece la propina del camarero
	 * @param propina {double} propina a establecer
	 */
	public void setPropina(double propina) {
		this.propina = propina;
	}

	/**
	 * Muestra la información del camarero
	 */
	@Override
	public String toString() {
		return super.toString()+ "\n Propina: " + propina + " €\n Salario: "+this.salarioFinal()+"€";
	}

	/**
	 * Calcula el salario final del empleado
	 * que se cálcula sumando la propina al salario base
	 */
	@Override
	public double salarioFinal() {
		return this.salarioBase()+this.propina;
	}
	
	
}
