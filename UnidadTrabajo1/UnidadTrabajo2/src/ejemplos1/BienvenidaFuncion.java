package ejemplos1;

//Declaración del procedimiento
public class BienvenidaFuncion {
	
	/**
	 * Muestra una serie de mensajes por pantalla para saludar
	 * @param args - nombre de la persona que queresmos saludar
	 */
	public static void saludar(String nombre) {
		System.out.println("Hola, "+nombre);
		System.out.println("bienvenido a clase, ");
		System.out.println("espero que aprendas mucho."+"\n");
		}	
	// Llamada
		
	public static void main(String[] args) {
		saludar("Fran");
		saludar("Pedro");
		saludar("Pablo");
		saludar("Antonio");
		saludar("Juan");
	}
}
