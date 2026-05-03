package GUIs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Ventana_Secundaria extends JDialog implements ActionListener {

	private JButton boton;
	private JLabel label;
	
	/**
	 * Constructor corregido
	 */
	public Ventana_Secundaria(Ventana_Principal parent, boolean modal) {
		// Enviamos a la clase superior el padre y si es modal o no
		super(parent, modal);
		
		// Configuración básica de la ventana secundaria
		setLayout(null);
		setBounds(300, 250, 250, 200);
		
		// Inicializamos componentes
		label = new JLabel("Esta es una ventana secundaria");
		label.setBounds(35, 30, 200, 30);
		add(label);
		
		// Conectamos el botón
		boton = new JButton("Volver");
		boton.setBounds(40, 80, 150, 30);
		add(boton);	
		boton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Si pulsamos el botón, cerramos esta ventana
		if (e.getSource() == boton) {
			setVisible(false);
		}
	}
}

