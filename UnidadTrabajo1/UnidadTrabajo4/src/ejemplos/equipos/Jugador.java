package ejemplos.equipos;

// CLASE
public class Jugador {
	
	// ENCAPSULAMIENTO, lineas de código inalterables
	// atributos privados
	private int codigo;		// código del jugador
	private String nombre;	// nombre del jugador
	private double altura;	// altura del jugador
	private int sueldo;		// sueldo del jugador
	

	// CONTSTRUCTOR (el constructor se llama igual que la clase)
	// puede haber varios constructores SOBRECARGA de constructores
	// los constructores NO MUESTRAN NI DEVUELVEN NADA
	/**
	 * @param codigo - código del jugador
	 * @param nombre
	 * @param altura
	 * @param sueldo
	 */
	public Jugador(int codigo, String nombre, double altura, int sueldo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.altura = altura;
		this.sueldo = sueldo;
	}
	
	// GETTERS Y SETTERS

	/**
	 * 
	 * @return el código de un jugador
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Establece el código del jugador
	 * @param codigo a establecer para el jugador
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return
	 */
	public double getAltura() {
		return altura;
	}

	/**
	 * 
	 * @param altura
	 */
	public void setAltura(double altura) {
		this.altura = altura;
	}

	/**
	 * 
	 * @return
	 */
	public int getSueldo() {
		return sueldo;
	}

	/**
	 * 
	 * @param sueldo
	 */
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	
	// procedimiento para mostar por consola
	
	/**
	 * Muestra por pantalla la info del jugador
	 */
	public void mostrarJugador() {
		System.out.println("JUGADOR: "+codigo+" : ");
		System.out.println(nombre+", ("+altura+"m) --> Salario: "+sueldo+"€\n");
	}
	
	
}
