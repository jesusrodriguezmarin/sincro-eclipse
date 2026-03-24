package ejemplos.empleados;

public abstract class Empleados {

	// Constante
	public static final double PLUS = 300;

	// Atrbutos
	protected String nombre;
	protected int edad;
	protected double salario;

	/**
	 * Constructor con 3 parámetros
	 * 
	 * @param nombre  del empleado
	 * @param edad    del empleado
	 * @param salario del empleado
	 */
	public Empleados(String nombre, int edad, double salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
	}

	/**
	 * Devuelve el nombre del empleado
	 * 
	 * @return {String} nombre del empleado
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del empleado
	 * @param nombre {String} a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve la edad del empleado
	 * @return {int} la edad del empleado
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Establece la edad del empleado
	 * @param edad {int} edad a establecer
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Devuelve el salario
	 * @return {double} salario del empleado
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * Establece el salario
	 * @param salario {double} salario a establecer
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * Muestra la información del empleado
	 */
	@Override
	public String toString() {
		return "\nNombre: " + nombre + "\nEdad: " + edad + " años\nSalario: " + salario;
	}

	// Método a implementar en las subclases
	public abstract boolean plus();
}
