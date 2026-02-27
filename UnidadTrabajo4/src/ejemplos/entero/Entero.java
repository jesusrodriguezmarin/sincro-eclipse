package ejemplos.entero;

public class Entero {

	// Atributo (encapsulado)
	private int numero;		// Solo se puede modificar desde esta clase
	
	// Métodos
	
	// Sobrecarga (Overloading) de constructor para Entero sin parámetro y con parámetro
	
	/**
	 * Constructor
	 */
	Entero() {
		numero = 0;
	}
	
	/**
	 * Contstructor
	 * @param valor (nº entero)
	 */
	Entero(int valor) {
		numero = valor;
	}
	
	// Getters(Obtener/Leer) & Setters(Establecer/Escrbir)
	// Pueden interactuar con el atributo de manera pública "public"
	// Sin alterar el atributo en la clase con el atributo privado "private"
	// Es decir, interactuan con el atributo encapsulado sin desencapturarlo
	
	/**
	 * Devuelve el valor del nº entero almacenado
	 * @return nº entero
	 */
	public int getEntero() {
		return numero;
	}
	
	/**
	 * Establece un valor para el nº entero
	 * @param valor (nº entero)
	 */
	public void setEntero(int valor) {
		numero = valor;
	}
	
	/**
	 * Indica si el número entero es positivo
	 * @return TRUE si 'numero' es positivo, FALSE si es negativo
	 */
	public boolean esPositivo() {
		if (numero > 0)
			return true;
		return false;
	}
	
	/**
	 * Indica si el número introducido es el cero
	 * @return TRUE si 'numero' es cero, FALSE sino lo es
	 */
	public boolean esCero() {
		if (numero == 0)
			return true;
		return false;
	}
	
	/**
	 * Indica si 'numero' es mayor que el número pasado por parámetro
	 * @param valor (nº entero)
	 * @return TRUE si 'numero' es mayor que el parámetro, FALSE si no lo es
	 */
	public boolean esMayor(int valor) {
		if (numero > valor)
			return true;
		return false;
	}
	
	/**
	 * Devuelve el doble del nº entero
	 * @return un número entero
	 */
	public int doble() {
		return 2*numero;
	}
	
	/**
	 * Devuelve el triple del número entero
	 * @return número entero
	 */
	public int triple() {
		return 3*numero;
	}
	
	/**
	 * Devuelve la mitad del número entero
	 * @return número entero
	 */
	public double mitad() {
		return numero/2;
	}
	
	/**
	 * Devuelve la potencia del número entero elevado al exponente pasado por parámetro
	 * @param exponente número entero
	 * @return número entero
	 */
	public int potencia(int exponente) {
		int res = 1;
		for (int i = 1; i <= exponente; i++)
			res *= numero;
		return res;
	}
	
	/**
	 * Indica si el número entero es par, es decir, divisible entre 2
	 * @return TRUE si es par, FALSE si no lo es
	 */
	public boolean esPar() {
		if (numero % 2 == 0)
			return true;
		return false;
	}
	
	/**
	 * Indica si el número entero es o no un nº primo
	 * Un nº primo es un nº mayor que 1 que tiene como únicos divisores el 1 y el propio nº
	 * @return TRUE si es primo, FALSE si no lo es
	 */
	public boolean esPrimo() {
		if (numero <= 1)
			return false;
		else
			for (int i = 2; i <= numero/2; i++)
				if (numero % i == 0)
					return false;
		return true;
	}
	
	/**
	 * Convierte el número entero a double y lo devuelve
	 * @return casting de 'numero'
	 */
	public double toDouble() {
		return (double)numero;
	}
}
