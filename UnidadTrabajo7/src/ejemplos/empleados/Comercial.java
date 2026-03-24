package ejemplos.empleados;

public class Comercial extends Empleados {

	// Atributos
	private double comision;

	/**
	 * Constructor con 4 parámetros
	 * @param nombre del comercial
	 * @param edad del comercial
	 * @param salario del comercial
	 * @param comision del comercial
	 */
	public Comercial(String nombre, int edad, double salario, double comision) {
		super(nombre, edad, salario);
		this.comision = comision;
	}

	/**
	 * Devuelve la comisión del empleado comercial
	 * @return {double} comision del empleado
	 */
	public double getComision() {
		return comision;
	}

	/**
	 * Establece la comisión del empleado comercial
	 * @param comision {double} comision a establecer
	 */
	public void setComision(double comision) {
		this.comision = comision;
	}

	/**
	 * Muestra la información del empleado comercial
	 */
	@Override
	public String toString() {
		return "\nComercial: " + super.toString() + "\nComision: " + comision+" euros.";
	}

	/**
	 * Aplica el plus al salario del comercial si cumple los requisitos:
	 * - Tener más de 30 años y cobrar una comisión de mas de 200€
	 */
	@Override
	public boolean plus() {
		if (this.edad>30 && this.comision>200) {
			this.salario += Empleados.PLUS;
			return true;
		}
		return false;
	}
	
	
	
}
