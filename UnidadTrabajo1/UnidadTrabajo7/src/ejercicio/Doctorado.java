package ejercicio;

public class Doctorado extends Alumno {

	// Constantes
	public final static double NOTA_TESIS_DEF = 8.50;
	
	// Atributos
	private double notaTesis;
	private String nombreTesis;
	
	/**
	 * @param nombre
	 * @param titulo
	 * @param notaTesis
	 * @param nombreTesis
	 */
	public Doctorado(String nombre, double nota, String titulo, double notaTesis, String nombreTesis) {
		super(nombre, nota, titulo);
		this.notaTesis = notaTesis;
		this.nombreTesis = nombreTesis;
	}

	/**
	 * Devuelve la nota de la tesis
	 * @return the notaTesis {double} de la tesis
	 */
	public double notaTesis() {
		return notaTesis;
	}

	/**
	 * Establece las horas totales de la tesis
	 * @param horasTesis the horasTesis {int} a establecer
	 */
	public void notaTesis(double notaTesis) {
		this.notaTesis = notaTesis;
	}

	/**
	 * Devuelve el nombre de la tesis
	 * @return the nombreTesis {String} de la tesis
	 */
	public String getNombreTesis() {
		return nombreTesis;
	}

	/**
	 * Establece el nombre de la tesis
	 * @param nombreTesis the nombreTesis {String} a establecer
	 */
	public void setNombreTesis(String nombreTesis) {
		this.nombreTesis = nombreTesis;
	}

	@Override
	public String toString() {
		return super.toString() + "\nTesis doctoral: " + nombreTesis + " ("+this.notaTesis+" nota obtenida)";
	}
	
	/**
	 * Devuelve la nota media entre la nota del titulo y la nota de la tesis
	 */
	public double notaFinal() {
		return (nota +this.notaTesis)/2;
	}
	
}
