package repasoGUIs;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HolaMundoHerencia extends JFrame {

	/**
	 * Constructor
	 */
	public HolaMundoHerencia() {
		
		// Creamos componentes
		setTitle("Hola Mundo Herencia!!!");
		JLabel etiqueta = new JLabel("Soy el constructor!!!");
		
		// Añadimos al ContentPane
		add(etiqueta);
	}
	
	/**
	 * Programa principal que solo instancia y configura la ventana
	 * La creación de ventana y componentes se genera en el constructor de la clase
	 * @param args
	 */
	public static void main(String[] args) {
		// Instanciamos la ventana
		HolaMundoHerencia v = new HolaMundoHerencia();
		v.pack();
		v.setSize(500,200);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
