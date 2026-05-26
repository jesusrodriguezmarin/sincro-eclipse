package ejemplos.mac.cuentaBanco;

import java.io.Serializable;

public class CuentaBanco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos de la cuenta bancaria
	private String nombre;
	private double saldo;

	// Constructor
	public CuentaBanco(String nombre, double saldo) {
		this.nombre = nombre;
		this.saldo = saldo;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	// Método toString para pintar los datos en el Case 2 y Case 5
	@Override
	public String toString() {
		return "Cuenta Bancaria [Nombre = " + nombre + ", Saldo = " + saldo + "€]";
	}
}