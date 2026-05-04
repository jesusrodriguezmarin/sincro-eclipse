package GUIs.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambioColorFondoBotones extends JFrame implements ActionListener {
	
	/*
	 * Componentes
	 * Diferentes botones
	 */
	JButton rojo, azul, verde, amarillo;
	
	/*
	 * Constructor
	 * Inicializa cada botón a un color
	 */
	public CambioColorFondoBotones() {
		
		// Posicionamiento absoluto
		setLayout(null);
		
		// Añadimos botón rojo
		rojo =  new JButton("rojo");
		rojo.setBounds(25, 40, 100, 25);
		add(rojo);
		rojo.addActionListener(this);
		
		// Añadimos botón azul
		azul =  new JButton("azul");
		azul.setBounds(145, 40, 100, 25);
		add(azul);
		azul.addActionListener(this);
		
		// Añadimos botón verde
		verde =  new JButton("verde");
		verde.setBounds(25, 80, 100, 25);
		add(verde);
		verde.addActionListener(this);
		
		// Añadimos botón amarillo
		amarillo =  new JButton("amarillo");
		amarillo.setBounds(145, 80, 100, 25);
		add(amarillo);
		amarillo.addActionListener(this);
	}
	
		/**
		 * Función que relaciona la acción con los botones
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==rojo) {
				getContentPane().setBackground(Color.red);
			}
			if (e.getSource()==azul) {
				getContentPane().setBackground(Color.blue);
			}
			if (e.getSource()==verde) {
				getContentPane().setBackground(Color.green);
			}
			if (e.getSource()==amarillo) {
				getContentPane().setBackground(Color.yellow);
			}

	}

	// Programa principal
	public static void main(String[] args) {
		
		// Creamos una instancia de la clase
		CambioColorFondoBotones v = new CambioColorFondoBotones();
		v.setTitle("Colores");
		v.setSize(280, 200);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}


}
