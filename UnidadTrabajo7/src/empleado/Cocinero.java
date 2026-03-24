package empleado;

public class Cocinero extends Empleado {

	// Constante
	public final static int EXPERIENCIA = 75;
	
	// Atributos
	private int experiencia;

	public Cocinero(String nombre, int experiencia) {
		this(nombre, Empleado.HORAS_DEF, experiencia);
	}
	
	/**
	 * Constructor con 3 parámetros
	 * @param nombre
	 * @param experiencia
	 */
	public Cocinero(String nombre, int horas, int experiencia) {
		super(nombre, horas);
		this.experiencia = experiencia;
	}

	/**
	 * Devuelve la experiencia del cocinero
	 * @return {int} experiencia del cocinero
	 */
	public int getExperiencia() {
		return experiencia;
	}

	/**
	 * Establece la experiencia del cocinero
	 * @param experiencia {int} experiencia to set
	 */
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	/**
	 * Muestra la información del cocinero
	 */
	@Override
	public String toString() {
		return super.toString() + "\n Experiencia: " + experiencia + " años\n Salario: "+this.salarioFinal()+"€";
	}

	/**
	 * Devuelve el salario final de los cocineros
	 */
	@Override
	public double salarioFinal() {
		double res = super.salarioBase();
		res += EXPERIENCIA * this.experiencia;
		return res;
	}
	
	
}
