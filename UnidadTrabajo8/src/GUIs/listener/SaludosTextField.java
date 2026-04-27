package GUIs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class SaludosTextField extends JFrame implements ActionListener {

	// Componentes de la ventana
	private JButton boton1, boton2;
	private JTextField saludo;

	public SaludosTextField() {
		setLayout(null);
		saludo = new JTextField();
		saludo.setBounds(20, 20, 180, 25);
		add(saludo);

		boton1 = new JButton("Di hola");
		boton1.setBounds(20, 60, 80, 25);
		add(boton1);
		boton1.addActionListener(this);

		boton2 = new JButton("Di adiós");
		boton2.setBounds(120, 60, 80, 25);
		add(boton2);
		boton2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton1) {
			saludo.setText("¡Hola!");
		}
		if (e.getSource() == boton2) {
			saludo.setText("¡Adiós!");
		}
	}

	public static void main(String[] args) {
		// Creamos ventana y configuración
		SaludosTextField v = new SaludosTextField();
		v.setTitle("Saludar");
		v.setSize(240, 150);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
