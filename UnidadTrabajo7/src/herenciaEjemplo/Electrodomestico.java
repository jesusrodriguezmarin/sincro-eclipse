package herenciaEjemplo;

public class Electrodomestico {

	// Constantes
	public final static double PRECIO_DEF = 100;
	public final static double PESO_DEF = 5;
	public final static char CONSUMO_DEF = 'F';
	public final static String COLOR_DEF = "blanco";

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
		this(PRECIO_DEF, PESO_DEF, CONSUMO_DEF, COLOR_DEF);
	}

	/**
	 * @param precioBase
	 * @param peso
	 */
	public Electrodomestico(double precioBase, double peso) {
		this(precioBase, peso, CONSUMO_DEF, COLOR_DEF);
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
	 * 
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

	/**
	 * Comprueba el color del electrodoméstico
	 * @param color {String} a comprobar
	 */
	private void comprobarColorElectrodomestico(String color) {
		String colores[] = { "blanco", "negro", "rojo", "azul", "gris" };
		boolean encontrado = false;

		for (int i = 0; i < colores.length && !encontrado; i++) {
			if (colores[i].equalsIgnoreCase(color))
				encontrado = true;
		}
		
		if (encontrado) {
			this.color = color.toLowerCase();
		} else {
			this.color = Electrodomestico.COLOR_DEF;
		}

	}

	/**
	 * Calcula y devuelve el precio final del electrodméstico
	 * 
	 * @return {double} devuelve el precio final del electrodméstico
	 */
	public double precioFinal() {
		double plus = 0;
		switch (this.consumoEnergetico) {
		case 'A': plus = 100;

			break;
		case 'B': plus = 80;

			break;
		case 'C': plus = 60;

			break;
		case 'D': plus = 50;

			break;
		case 'E': plus = 30;

			break;
		case 'F': plus = 10;

			break;
		}
		
		if (peso>= 0 && peso <= 19)
			plus += 10;
		else if (peso >= 20 && peso <= 49)
			plus +=50;
		else if (peso >= 50 && peso <= 79)
			plus +=80;
		else if (peso >= 80)
			plus += 100;
		return this.precioBase + plus;
	}

	/**
	 * Método para devolver información del electrodoméstico
	 */
	@Override
	public String toString() {
		return "Electrodomestico: color "+color+", peso"+peso+" kg, consumo energético "+consumoEnergetico+", precio final "+this.precioFinal()+" euros";
	}
	

}
