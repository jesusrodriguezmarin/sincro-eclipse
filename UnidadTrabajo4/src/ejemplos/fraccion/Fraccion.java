package ejemplos.fraccion;

public class Fraccion {

	// ATRIBUTOS
	private int numerador;
	private int denominador;
	
	// CONSTRUCTORES
	
	/**
	 * Constructor
	 */
	public Fraccion() {
		numerador = 0;
		denominador = 1;
	}


	/**
	 * Constructor
	 * @param numerador
	 */
	public Fraccion(int numerador) {
		this.numerador = numerador;
		this.denominador = 1;
	}


	/**
	 * Constructor
	 * @param numerador
	 * @param denominador
	 */
	public Fraccion(int numerador, int denominador) {
		this.numerador = numerador;
		if (denominador == 0)
			this.denominador = 1;
		else
			this.denominador = denominador;
	}


	// GETTERS Y SETTERS
	
	/**
	 * Devuelve el numerador de la fraccion
	 * @return el numerador
	 */
	public int getNumerador() {
		return numerador;
	}


	/**
	 * Establece un valor para el numerador
	 * @param numerador el numerador a establecer
	 */
	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}


	/**
	 * Devuelve el denominador de la fraccion
	 * @return el denominador
	 */
	public int getDenominador() {
		return denominador;
	}

	/**
	 * Establece un valor para el denominador de la fraccion
	 * @param denominador el denominador a establecer
	 */
	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}
	
	// MÉTODOS
	
	/**
	 * Sumar dos fracciones
	 * @param f - Fraccion
	 * @return fraccion resultado de la suma
	 */
	public Fraccion sumar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.numerador = this.numerador * f.denominador + this.denominador * f.numerador;
		aux.denominador = this.denominador * f.denominador;
		return aux;
	}
	
	/**
	 * Restar dos fracciones
	 * @param f - Fraccion
	 * @return fraccion resultado de la resta
	 */
	public Fraccion restar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.numerador = this.numerador * f.denominador - this.denominador * f.numerador;
		aux.denominador = this.denominador * f.denominador;
		return aux;
	}
	
	/**
	 * Multiplicar dos fracciones
	 * @param f - Fraccion
	 * @return fraccion resultado de la multipliacion
	 */
	public Fraccion multiplicar(Fraccion f) {
		return (new Fraccion(this.numerador*f.numerador, this.denominador*f.denominador));	
	}
	
	/**
	 * Dividir dos fracciones
	 * @param f - Fraccion
	 * @return fraccion resultado de la division
	 */
	public Fraccion dividir(Fraccion f) {
		return (new Fraccion(this.numerador*f.denominador, this.denominador*f.numerador));
	}
	
	/**
	 * Obtiene el máximo común divisor del numerador y del denominador
	 * Para ello utilizamos el algorítmo de Euclides
	 * @return máximo común divisor (nº entero)
	 */
	private int mcd() {
		int u = Math.abs(numerador);
		int v = Math.abs(denominador);
		if (v == 0)
			return u;
		
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}
	
	/**
	 * Simplifica la fraccion haciendo uso del máximo común divisor
	 */
	public void simplificar() {
		int n = mcd(); // Cálculamo el máximo comun divisor de la fraccion
		numerador = numerador / n;
		denominador = denominador / n;
	}
	
	/**
	 * Devuelve una cadena de caracteres que representa la fraccion
	 */
	public String toString() {
		if (denominador == 1)
			return numerador+"";
		return numerador+"/"+denominador;
	}
	
	/**
	 * Comprueba si dos fracciones son equivalentes
	 * @param n1 - numerador de la primera fraccion
	 * @param d1 - denominador de la primera fraccion
	 * @param n2 - numerador de la segunda fraccion
	 * @param d2 - denominador de la segunda fraccion
	 * @return TRUE si es equivalente, FALSE si no lo es
	 */
	public boolean equivalente(int n1, int d1, int n2, int d2) {
		return (long)n1 * d2 == (long)d1 * n2;
			
	}
}
