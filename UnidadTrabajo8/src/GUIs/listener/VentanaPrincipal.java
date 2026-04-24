package GUIs.listener;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame implements ActionListener {
	
	/**
	 * Variables
	 */
	private JButton boton;
	private JLabel label;
	
	/**
	 * Constructor
	 */
	public VentanaPrincipal() {
		setLayout(null);
		
		// Etiqueta
		label = new JLabel("Esta es la ventana principal");
		label.setBounds(35, 30, 200, 30);
		add(label);
		
		// Boton
		boton = new JButton("Haz click aquí");
		boton.setBounds(40, 80, WIDTH, HEIGHT);
	}

	public static void main(String[] args) {



	}

}
