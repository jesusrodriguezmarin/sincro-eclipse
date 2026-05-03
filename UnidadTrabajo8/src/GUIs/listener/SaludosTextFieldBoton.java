package GUIs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class SaludosTextFieldBoton extends JFrame implements ActionListener {

	// Componentes de la ventana
	private JButton boton1, boton2;
	private JTextField saludo;

	/**
	 * Constructor
	 */
	public SaludosTextFieldBoton() {
		
		// Posicionamiento
		setLayout(null);
		
		// Campo de texto
		saludo = new JTextField();
		saludo.setBounds(20, 20, 180, 25);
		add(saludo);

		// Boton 1
		boton1 = new JButton("Di hola");
		boton1.setBounds(20, 60, 80, 25);
		add(boton1);
		boton1.addActionListener(this);

		// Botón 2
		boton2 = new JButton("Di adiós");
		boton2.setBounds(120, 60, 80, 25);
		add(boton2);
		boton2.addActionListener(this);
	}

	/**
	 * Acción ligada a los botones
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton1) {
			saludo.setText("¡Hola!");
		}
		if (e.getSource() == boton2) {
			saludo.setText("¡Adiós!");
		}
	}

	//Programa principal
	public static void main(String[] args) {
		
		// Creamos ventana y configuración
		SaludosTextFieldBoton v = new SaludosTextFieldBoton();
		v.setTitle("Saludar");
		v.setSize(240, 150);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
