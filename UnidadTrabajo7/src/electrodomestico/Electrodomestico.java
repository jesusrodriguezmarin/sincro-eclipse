package electrodomestico;

public class Electrodomestico {

	// Constantes
	protected final static double PRECIO_DEF = 100;
	protected final static double PESO_DEF = 5;
	protected final static char CONSUMO_DEF = 'F';
	protected final static String COLOR_DEF = "blanco";

	// Atributos
	protected double precioBase;
	protected double peso;
	protected char consumoEnergetico;
	protected String color;

	// Constructores

	/**
	 * Constructor por defecto
	 */
	public Electrodomestico() {
		precioBase = PRECIO_DEF;
		peso = PESO_DEF;
		consumoEnergetico = CONSUMO_DEF;
		color = COLOR_DEF;
	}

	/**
	 * Constructor con dos parámetros: precipBase y peso del electrodoméstico
	 * 
	 * @param precioBase {double} Precio del electrodoméstico
	 * @param peso       {double} Peso del electrodoméstico
	 */
	public Electrodomestico(double precioBase, double peso) {
		this();
		this.precioBase = precioBase;
		this.peso = peso;
	}

	/**
	 * Constructor con cuatro parámetros
	 * 
	 * @param precioBase        {double} Precio del electrodoméstico
	 * @param peso              {double} Peso del electrodoméstico
	 * @param consumoEnergetico {Char} Consumo del electrodoméstico
	 * @param color             {String} Color del electrodoméstico
	 */
	public Electrodomestico(double precioBase, double peso, char consumoEnergetico, String color) {
		this.precioBase = precioBase;
		this.peso = peso;
		this.comprobarConsumoElectrico(consumoEnergetico);
		this.comprobarColorElectrodomestico(color);
	}

	// Getters

	/**
	 * Devuelve el precio base del electrodoméstico
	 * 
	 * @return the precioBase {double} Precio base del electrodoméstico
	 */
	public double getPrecioBase() {
		return precioBase;
	}

	/**
	 * Devuelve el peso del electrodoméstico
	 * 
	 * @return the peso {double} el peso del electrodoméstico
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * Devuelve el consumo energéticdo del electrodoméstico
	 * 
	 * @return the consumoEnergetico {char} el consumo energéticdo del
	 *         electrodoméstico
	 */
	public char getConsumoEnergetico() {
		return consumoEnergetico;
	}

	/**
	 * Devuelve el color del electrodoméstico
	 * 
	 * @return the color {String} el color del electrodoméstico
	 */
	public String getColor() {
		return color;
	}

	// Métodos

	/**
	 * Comprueba el consumo energético
	 * @param letra {char} correspondiente al consumo del electrodoméstico
	 */
	private void comprobarConsumoElectrico(char letra) {
		// if (letra >= 65 && letra <= 70)
		if (letra >= 'A' && letra <= 'F') {
			this.consumoEnergetico = letra;
		} else {
			this.consumoEnergetico = CONSUMO_DEF;
		}
	}
	
	private void comprobarColorElectrodomestico(String color) {
		String colores[] = {};
		
	}

}
