package herenciaEjemplo;

public class Lavadora extends Electrodomestico {

	// Constantes
	private final static int CARGA_DEF = 5;

	// Atributo
	private int carga; // Carga de la lavadora

	public Lavadora() {
		super();
		this.carga=CARGA_DEF;
	}
	
	public Lavadora(double precioBase, double peso) {
		this(CARGA_DEF, precioBase, peso, CONSUMO_DEF, COLOR_DEF);
	}
	
	/**
	 * Constructor
	 * LLamamos al constructor super() con 4 parámetros, se los introducimos para
	 * invocarlo
	 * 
	 * @param carga {int}
	 * @param precioBase {double}
	 * @param peso {double}
	 * @param consumoEnergetico {char}
	 * @param color {String}
	 */
	public Lavadora(int carga, double precioBase, double peso, char consumoEnergetico, String color) {
		super(precioBase, peso, consumoEnergetico, color);
		this.carga = carga;
	}

	/**
	 * Devuelve la carga de la lavadora
	 * @return the carga {int}
	 */
	public int getCarga() {
		return carga;
	}

	/**
	 * Calcula y devuelve el precio final de la lavadora
	 * @return {double} precio final de la lavadora
	 */
	public double precioFinal() {
		// Invocamos el método precio final del padre super.precioFinal();
		double preciofin = super.precioFinal();
		
		if (carga>30)
			preciofin += 50;
		
		return preciofin;
	}
	
	/**
	 * Método para devolver información del electrodoméstico
	 */
	@Override
	public String toString() {
		return "Lavadora: color "+color+", peso"+peso+" kg, consumo energético "+consumoEnergetico+", carga "+carga+", precio final "+this.precioFinal()+" euros";
	}
	
}
