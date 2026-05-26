package ejemplos.mac.vehiculo;

import java.io.Serializable;

public class Vehiculo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos del vehículo
	private String matricula;
	private String marca;

	// Constructor
	public Vehiculo(String matricula, String marca) {
		this.matricula = matricula;
		this.marca = marca;
	}

	// Getters y Setters
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	// Método toString para pintar los datos en el Case 2 y Case 5
	@Override
	public String toString() {
		return "Vehículo [Matrícula = " + matricula + ", Marca = " + marca + "]";
	}
}