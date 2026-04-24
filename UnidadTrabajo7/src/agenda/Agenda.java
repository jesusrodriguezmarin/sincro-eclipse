package agenda;

public class Agenda {

	//Atributos
	private Contacto[] contactos;
	//Constructores
	public Agenda() {
	// Por defecto, creamos una agenda con 10 contactos
	this.contactos = new Contacto[10];
	}
	public Agenda(int num) {
	// Creamos una agenda con el no de contactos que queramos (pasado como parámetro)
	this.contactos = new Contacto[num];
	}
}
