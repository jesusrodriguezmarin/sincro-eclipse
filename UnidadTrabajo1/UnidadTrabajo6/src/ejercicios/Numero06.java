package ejercicios;

public class Numero06 {

	// Atributo
	private int dato;

	/**
	 * Constructor por defecto que inicializa a 0
	 */
	Numero06() {
		this.dato = 0;
	}

	/**
	 * Constructor por parámetro que inicializa al número interno
	 * 
	 * @param num - valor inicial de dato
	 */
	Numero06(int num) {
		this.dato = num;
	}

	/**
	 * Suma el número al dato
	 * 
	 * @param num - número que sumamos al dato
	 */
	public void suma(int num) {
		dato = dato + num;
	}

	/**
	 * Resta el número al dato que pasamos por parámetro
	 * 
	 * @param num - número que restamos al dato
	 */
	public void resta(int num) {
		dato -= num;
	}

	/**
	 * Devuelve el dato
	 * 
	 * @return número entero
	 */
	public int getValor() {
		return dato;
	}

	/**
	 * Devuelve el doble del dato
	 * 
	 * @return número entero
	 */
	public int getDoble() {
		return 2 * dato;
	}

	/**
	 * Devuelve el triple del dato
	 * 
	 * @return número entero
	 */
	public int getTriple() {
		return 3 * dato;
	}

	/**
	 * Establece un valor para el dato
	 * 
	 * @param n - número entero
	 */
	public void setNum(int n) {
		dato = n;
	}

	/**
	 * Asigna el doble al dato
	 * 
	 * @param n - número entero
	 */
	public void setDoble(int n) {
		this.dato = 2*n;
	}
	
	/**
	 * Asigna al dato el triple de n
	 * @param n - número entero
	 */
	public void setTriple(int n) {
		this.dato = 3*n;
	}
}
