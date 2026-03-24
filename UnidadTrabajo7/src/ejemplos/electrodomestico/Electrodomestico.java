package ejemplos.electrodomestico;

public class Electrodomestico {

	// Constantes
	public final static double PRECIO_DEF = 100;
	public final static double PESO_DEF = 5;
	public final static char CONSUMO_DEF = 'F';
	public final static String COLOR_DEF = "blanco";

	// Atributos
	protected double precio_base;
	protected double peso;
	protected char consumo;
	protected String color;

	/**
	 * Constructor con todos los atributos como parámetro
	 * 
	 * @param precio_base
	 * @param peso
	 * @param consumo
	 * @param color
	 */
	public Electrodomestico(double precio_base, double peso, char consumo, String color) {
		this.precio_base = precio_base;
		this.peso = peso;
		this.ComprobarConsumoEnergetico(consumo);
		this.ComprobarColor(color);
	}

	/**
	 * Constructor con dos parámetros
	 * 
	 * @param precio_base
	 * @param peso
	 */
	public Electrodomestico(double precio_base, double peso) {
		this.precio_base = precio_base;
		this.peso = peso;
		this.consumo = CONSUMO_DEF;
		this.color = COLOR_DEF;
	}

	/**
	 * Constructor por defecto
	 */
	public Electrodomestico() {
		this.precio_base = PRECIO_DEF;
		this.peso = PESO_DEF;
		this.consumo = CONSUMO_DEF;
		this.color = COLOR_DEF;
	}

	/**
	 * Devuelve el precio del electrodoméstico
	 * 
	 * @return the precio_base {double}
	 */
	public double getPrecio_base() {
		return precio_base;
	}

	/**
	 * Devuelve el peso del electrodoméstico
	 * 
	 * @return the peso {double}
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * Devuelve el consumo del electrodoméstico
	 * 
	 * @return the consumo {char}
	 */
	public char getConsumo() {
		return consumo;
	}

	/**
	 * Devuelve el color del electrodoméstico
	 * 
	 * @return the color {String}
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Comprueba si la letra es correcta, sino lo es, establece la letra por defecto
	 */
	private void ComprobarConsumoEnergetico(char letra) {
		if (letra >= 'A' && letra <= 'F') {
			this.consumo = letra;
		} else {
			this.consumo = CONSUMO_DEF;
		}
	}

	/**
	 * Comprueba que el color introducido es correcto, sino se establece el color
	 * por defecto
	 * 
	 * @param color
	 */
	private void ComprobarColor(String color) {
		String[] colors = { "blanco", "negro", "rojo", "azul", "gris" };
		boolean encontrado = false;
		
		for (int i = 0; i < colors.length; i++) {
			
			if (colors[i].equalsIgnoreCase(color)) {
				encontrado = true;
				break;
			}
		}
		if (encontrado) {
			this.color = color.toLowerCase();
		} else {
			this.color = Electrodomestico.COLOR_DEF;
		}
	}

	/**
	 * Devuelve el precio final según su precio base + los incrementos por consumo y
	 * tamaño
	 * 
	 * @param consumo - {char} corresponde a un precio a incrementar
	 * @param tamaño  {int} corresponde a un precio a incrementar
	 * @return El precio final del electrodoméstico
	 */
	public double precioFinal() {
		int pConsumo = 0;
		int pTamaño = 0;

		switch (this.consumo) {
		case 'A': pConsumo = 100;

			break;
		case 'B': pConsumo = 80;

			break;
		case 'C': pConsumo = 60;

			break;
		case 'D': pConsumo = 50;

			break;
		case 'E': pConsumo = 30;

			break;
		case 'F': pConsumo = 10;

			break;
		}
		
		if (this.peso >= 0 && this.peso  <= 19)
			pTamaño = 10;
		else if (this.peso  >= 20 && this.peso  < 50)
			pTamaño = 50;
		else if (this.peso  > 50 && this.peso  < 80)
			pTamaño = 80;
		else if (this.peso  >= 80)
			pTamaño = 100;

		return this.precio_base + pConsumo + pTamaño;
	}
	
	// Muestra la información del electrodoméstico
	@Override
	public String toString() {
		return "[precio_base=" + this.precioFinal() + ", peso=" + peso + ", consumo=" + consumo + ", color="
				+ color + "]";
	}
	
	
}
