package empleado;

public abstract class Empleado {

	// Constantes
	public static final int HORAS_DEF = 20;
	public static final double SALARIO_MIN = 1000;
	
	// Atributos
	protected String nombre;
	protected int horas;
	
	/**
	 * Constructor con los 1 parámetro
	 * @param nombre del empleado
	 */
	public Empleado(String nombre) {
		this.nombre = nombre;
		this.horas = HORAS_DEF;
	}
	
	
	/**
	 * Constructor con los 2 parámetros
	 * @param nombre del empleado
	 * @param horas del empleado
	 */
	public Empleado(String nombre, int horas) {
		this.nombre = nombre;
		this.horas = horas;
	}


	/**
	 * Devuelve el nombre del empleado
	 * @return {String} nombre del empleado
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * Establece el nombre del empleado
	 * @param nombre {String} nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * Devuelve las horas del empleado
	 * @return {int} horas del empleado
	 */
	public int getHoras() {
		return horas;
	}


	/**
	 * Establece las horas del empleado
	 * @param horas {int} horas a establecer
	 */
	public void setHoras(int horas) {
		this.horas = horas;
	}

	/**
	 * Muestra la información del empleado
	 */
	@Override
	public String toString() {
		return " Nombre: " + nombre + "\n Contrato: " + horas+" horas";
	}
	
	/**
	 * Devuelve el salario base del empleado calculado en función del número de horas contratado
	 * @return {double} el salario base del empleado
	 */
	public double salarioBase() {
		double res = Empleado.SALARIO_MIN;
		if (this.horas>HORAS_DEF) {
			res += (this.horas-HORAS_DEF)*50;
		}
		return res;
	}
	
	/**
	 * Calcula el salario final, será implementado en las clases hijas
	 * @return el salario final del empleado
	 */
	public abstract double salarioFinal();
	
}
