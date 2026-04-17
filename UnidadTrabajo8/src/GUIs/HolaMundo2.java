package GUIs;

// Importamos toda la libreria de javax.swing
import javax.swing.*;

public class HolaMundo2 extends JFrame {
	
	/**
	 * Constructor
	 */
	public HolaMundo2() {
		setTitle("Vega Media");
		JLabel label = new JLabel("CFGS en Desarrollo de Aplicaciones Web");
		add(label);
	}

	// Metemos toda la configuración del Frame en el main
	public static void main(String[] args) {

		HolaMundo2 app = new HolaMundo2();
		app.pack();
		app.setLocationRelativeTo(null);
		app.setVisible(true);
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
