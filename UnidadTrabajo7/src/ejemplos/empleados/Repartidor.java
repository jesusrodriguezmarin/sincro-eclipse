package ejemplos.empleados;

public class Repartidor extends Empleados {

	// Atributos
	private String zona;

	/**
	 * Constructor con 4 parámetros
	 * @param nombre del repartidor
	 * @param edad del repartidor
	 * @param salario del repartidor
	 * @param zona de reparto
	 */
	public Repartidor(String nombre, int edad, double salario, String zona) {
		super(nombre, edad, salario);
		this.zona = zona;
	}

	/**
	 * Devuelve la zona de reparto del repartidor
	 * @return {String} zona de reparto del repartidor
	 */
	public String getZona() {
		return zona;
	}

	/**
	 * Establece la zona de reparto del repartidor
	 * @param zona {STring} zona a establecer
	 */
	public void setZona(String zona) {
		this.zona = zona;
	}

	@Override
	public String toString() {
		return "\nRepartidor: " + super.toString()+"\nZona: " + zona;
	}

	/**
	 * Aplica el plus al salario del repartidor si cumple los siguientes requisitos:
	 * - Si tiene menos de 25 años y reparte en la zona 3.
	 */
	@Override
	public boolean plus() {
		if (this.edad<25 && this.zona.equalsIgnoreCase("zona 3")) {
			this.salario+=Empleados.PLUS;
			return true;
		}
		return false;
	}
	
	
	
}
