package ejercicios2;

public class Persona {

	// Atributos
	private String nombre;
	private int edad;
	private String sexo;
	private double peso;
	private double altura;
	
	/**
	 * Constructor por defecto sin parámetros
	 */
	public Persona() {
		this.nombre = "";
		this.edad = 0;
		this.sexo = "H";
		this.peso = 0.0;
		this.altura = 0.0;
	}
	
	/**
	 * Constructor con tres parámetros
	 * @param nombre - String
	 * @param edad - int
	 * @param sexo - String
	 */
	public Persona(String nombre, int edad, String sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
	}

	/**
	 * Constructor con parámetros
	 * @param nombre - String
	 * @param edad - int
	 * @param sexo - String
	 * @param peso - double
	 * @param altura - double
	 */
	public Persona(String nombre, int edad, String sexo, double peso, double altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}

	/**
	 * Muestra el nombre
	 * @return String el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre
	 * @param nombre String a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Muestra la edad
	 * @return int - la edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Establece la edad
	 * @param edad int - a establecer
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Muestra el sexo
	 * @return String - sexo de la persona
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * Establece el sexo
	 * @param sexo String de la persaona
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * Muestra el peso de la persona
	 * @return int el peso de la persona
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * Establece el peso de la persona
	 * @param peso double - a establecer
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * Muestra la altura de la persona
	 * @return double - altura de la persona
	 */
	public double getAltura() {
		return altura;
	}

	/**
	 * Establece la altura
	 * @param altura double - a establecer
	 */
	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	/**
	 * Muestra toda la información de la persona
	 */
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", peso=" + peso + ", altura="
				+ altura + "]";
	}
	
	/**
	 * Determina si la persona es mayor de edad, si tiene al menos 18 años
	 * @param edad int a comprobar
	 * @return true si es mayor de edad, false si no lo es
	 */
	public boolean esMayor() {
		return edad >= 18;
	}
	
	/**
	 * Calcula el IMC, fórmula que con el peso y la altura de la persona,
	 * determina en que estado estás
	 * @return int (-1) si estas en el peso ideal, (0) por debajo, (1) por encima
	 */
	public int calcularIMC() {
		double valor = peso / (altura*altura);
		if (valor < 20) {
			return -1;
		} else if (valor >= 20 && valor <=25) {
			return 0;
		} else {
			return 1;
		}
	}
	
}
