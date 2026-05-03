package GUIs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class SumarTextField extends JFrame implements ActionListener {

	// Variables
	JTextField sumando1, sumando2;
	JButton boton;

	/**
	 * Constructor
	 */
	public SumarTextField() {
		
		// Posicionamiento
		setLayout(null);

		// Campo de texto para recibir el primer sumando
		sumando1 = new JTextField();
		sumando1.setBounds(70, 30, 100, 25);
		add(sumando1);

		// Campo de texto para recibir el segundo sumando
		sumando2 = new JTextField();
		sumando2.setBounds(70, 110, 100, 25);
		add(sumando2);

		// Botón
		boton = new JButton("Sumar");
		boton.setBounds(70, 70, 100, 25);
		add(boton);
		boton.addActionListener(this);
	}

	/**
	 * Método que implementa la acción del botón
	 */
	public void actionPerformed(ActionEvent e) {
		
		// Control de errores
		try {
			if (e.getSource() == boton) {
				
				// Capaturamos el texto de ambos campos
				String cad1 = sumando1.getText();
				String cad2 = sumando2.getText();
				
				// Parseamos el texto String a int para operar
				int x1 = Integer.parseInt(cad1);
				int x2 = Integer.parseInt(cad2);
				
				// Operamos y guardamos en una variable de texto
				String total = String.valueOf(x1 + x2);
				
				// Mostramos el resultado en la barra superior
				setTitle(total);
			}
		} catch (Exception e2) {
			setTitle("ERROR");
		}
	}

	// Programa principal
	public static void main(String[] args) {
		
		// Creamos objeto
		SumarTextField s = new SumarTextField();
		s.setSize(250, 200);
		s.setResizable(false);
		s.setLocationRelativeTo(null);
		s.setVisible(true);
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
