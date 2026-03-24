package herenciaEjemplo;

public class Television extends Electrodomestico {

	// Constantes
	private final static int RESOLUCION_DEF = 20;

	// Atributo
	private int resolucion; // Carga de la lavadora

	public Television() {
		super();
		this.resolucion = RESOLUCION_DEF;
	}

	public Television(double precioBase, double peso) {
		super();
		consumoEnergetico = CONSUMO_DEF;
		color = COLOR_DEF;
		this.resolucion = RESOLUCION_DEF;
	}

	/**
	 * Constructor LLamamos al constructor super() con 4 parámetros, se los
	 * introducimos para invocarlo
	 * 
	 * @param carga             {int}
	 * @param precioBase        {double}
	 * @param peso              {double}
	 * @param consumoEnergetico {char}
	 * @param color             {String}
	 */
	public Television(double precioBase, double peso, char consumoEnergetico, String color, int resolucion) {
		super(precioBase, peso, consumoEnergetico, color);
		this.resolucion = resolucion;
	}

	/**
	 * Devuelve la carga de la lavadora
	 * 
	 * @return the carga {int}
	 */
	public int getResolucion() {
		return resolucion;
	}

	/**
	 * Calcula y devuelve el precio final de la television
	 * 
	 * @return {double} precio final de la television
	 */
	public double precioFinal() {
		// Invocamos el método precio final del padre super.precioFinal();
		double preciofin = super.precioFinal();

		if (resolucion > 40)
			preciofin = precioBase * 0.3;

		return preciofin;
	}

	/**
	 * Método para devolver información del electrodoméstico
	 */
	@Override
	public String toString() {
		return "Lavadora: color " + color + ", peso" + peso + " kg, consumo energético " + consumoEnergetico
				+ ", resolucion " + resolucion + ", precio final " + this.precioFinal() + " euros";
	}

}
