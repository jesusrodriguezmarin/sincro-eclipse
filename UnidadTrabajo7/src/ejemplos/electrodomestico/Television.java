package ejemplos.electrodomestico;

public class Television extends Electrodomestico {

	// Constante
	public static final double RES_DEF = 20;
	
	
	// Atributos
	protected double resolucion;

	
	
	/**
	 * Constructor por defecto
	 */
	public Television() {
		super();
		this.resolucion = RES_DEF;
	}

	/**
	 * Consturctor con dos parámetros
	 * @param precio_base
	 * @param peso
	 */
	public Television (double precio_base, double peso) {
		super(precio_base, peso);
		this.resolucion = RES_DEF;
	}

	/**
	 * @param precio_base
	 * @param peso
	 * @param consumo
	 * @param color
	 */
	public Television(double precio_base, double peso, char consumo, String color, double resolucion) {
		super(precio_base, peso, consumo, color);
		this.resolucion = resolucion;
	}

	/**
	 * Devuelve la resolucion de la televisión
	 * @return the resolucion {double}
	 */
	public double getResolucion() {
		return resolucion;
	}
	
	@Override
	public double precioFinal() {
		double precio = super.precioFinal();
		if (this.resolucion>40)
			precio += (precio*30)/100;
		return precio;
	}

	@Override
	public String toString() {
		return "Televisón: "+super.toString()+"resolucion=" + resolucion;
	}
	
	
}
