package GUIs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana_Principal extends JFrame implements ActionListener {
	
	/**
	 * Variables
	 */
	private JButton boton;
	private JLabel label;
	
	/**
	 * Constructor
	 */
	public Ventana_Principal() {
		setLayout(null);
		
		// Etiqueta
		label = new JLabel("Esta es la ventana principal");
		label.setBounds(35, 30, 200, 30);
		add(label);
		
		// Boton
		boton = new JButton("Haz click aquí");
		boton.setBounds(40, 80, 150, 30);
		add(boton);
		boton.addActionListener(this);
	}
	
	/**
	 * Implementa la acción del botón
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// Crea una ventana secundarian e impide acceso a las demas con true
		if (e.getSource() == boton) {
			Ventana_Secundaria sec = new Ventana_Secundaria(this, true);
			sec.setVisible(true);
		}
	}

	public static void main(String[] args) {
		
		// Instanciamos
		Ventana_Principal v = new Ventana_Principal();
		v.setBounds(100, 100, 250, 250);
		v.setVisible(true);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);


	}

}
