package GUIs.ejemplos.Absoluto;

// Importamos toda la libreria de javax.swing
import javax.swing.*;

// Importamos el extends JFrame
public class VentanaBasica extends JFrame {
	
	/**
	 * Constructor
	 */
	public VentanaBasica() {
	
		// Define el texto que aparecerá en la barra supeior
		setTitle("Mi Nombre");
		// Creación de domponente etiqueta
		JLabel etiqueta = new JLabel("Federico García");
		// Añade la etiqueta
		add(etiqueta);
	}

	// Metemos toda la configuración del Frame en el main
	public static void main(String[] args) {

		// Creamo la instancia de la ventana
		VentanaBasica app = new VentanaBasica();
		
		// Establece un tamaño fijo
		app.setSize(300, 100);
		// Centra la ventana
		app.setLocationRelativeTo(null);
		// Hace que aparezca la ventana
		app.setVisible(true);
		// Cierra los procesos junto al cierre de la ventana
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
