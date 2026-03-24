package ejemplos.electrodomestico;

public class Lavadora extends Electrodomestico {

	// Constante
	public static final int CARGA_DEF = 5;
	
	// Atributo
	private int carga;

	/**
	 * Constructor con todos los parámetros heredados y de la subclase
	 * @param precio_base
	 * @param peso
	 * @param consumo
	 * @param color
	 */
	public Lavadora(double precio_base, double peso, char consumo, String color, int carga) {
		super(precio_base, peso, consumo, color);
		this.carga = carga;
	}

	/**
	 * Consturctor con dos parámetros
	 * @param precio_base
	 * @param peso
	 */
	public Lavadora(double precio_base, double peso) {
		super(precio_base, peso);
		this.carga = CARGA_DEF;
	}

	/**
	 * Constructor por defecto
	 * @param carga
	 */
	public Lavadora() {
		super();
		this.carga = CARGA_DEF;
	}

	/**
	 * Devuelve la carga de la lavadora
	 * @return the carga {int}
	 */
	public int getCarga() {
		return carga;
	}
	
	@Override
	public double precioFinal() {
		double precio = super.precioFinal();
		if (this.carga>30) {
			precio += 50;
		} 
		return precio;
	}

	@Override
	public String toString() {
		return "Lavadora: "+ super.toString()+" carga: "+this.carga;
	}
	
	
}
