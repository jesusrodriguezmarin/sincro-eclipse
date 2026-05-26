package ejemplos.mac.password;

import java.io.Serializable;

public class Password implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos de la credencial
	private String usuario;
	private String clave;

	// Constructor
	public Password(String usuario, String clave) {
		this.usuario = usuario;
		this.clave = clave;
	}

	// Getters y Setters
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	// Método toString para pintar los datos en el Case 2 y Case 5
	@Override
	public String toString() {
		return "Credencial [Usuario = " + usuario + ", Contraseña = " + clave + "]";
	}
}