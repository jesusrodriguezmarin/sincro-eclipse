package GUIs.ejemplos.Absoluto;

// Importamos toda la libreria de javax.swing
import javax.swing.*;

// Importamos el extends JFrame
public class Ej01 extends JFrame {
	
	/**
	 * Constructor
	 */
	public Ej01() {
	
		setTitle("Mi Nombre");
		JLabel etiqueta = new JLabel("Federico García");
		add(etiqueta);
	}

	// Metemos toda la configuración del Frame en el main
	public static void main(String[] args) {

		Ej01 app = new Ej01();
		app.pack();
		app.setSize(300, 100);
		app.setLocationRelativeTo(null);
		app.setVisible(true);
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
