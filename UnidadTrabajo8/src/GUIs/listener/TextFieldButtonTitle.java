package GUIs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TextFieldButtonTitle extends JFrame implements ActionListener {

	// Variables
	private JTextField nombre;
	private JButton boton;
	private JLabel etiqueta;

	/**
	 * Constructor
	 */
	public TextFieldButtonTitle() {
		setLayout(null);

		// Configuramos etiqueta
		etiqueta = new JLabel("Nombre: ");
		etiqueta.setBounds(50, 30, 100, 25);
		add(etiqueta);
		
		// Campo de texto para recibir el primer sumando
		nombre = new JTextField();
		nombre.setBounds(120, 30, 250, 25);
		add(nombre);

		// Botón
		boton = new JButton("Aceptar");
		boton.setBounds(120, 70, 100, 25);
		add(boton);
		boton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==boton) {
			String n = nombre.getText();
			setTitle(n);
		}
		
	}

	public static void main(String[] args) {
		// Creamos y configuramos ventana
		TextFieldButtonTitle s = new TextFieldButtonTitle();
		s.setSize(450, 170);
		s.setResizable(false);
		s.setLocationRelativeTo(null);
		s.setVisible(true);
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


}
