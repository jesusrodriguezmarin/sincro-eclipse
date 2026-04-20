package GUIs.componentes;

import javax.swing.*;

public class Ej_Boton extends JFrame {
	
	// Control visual del  botón
	JButton boton;	
	
	/**
	 * Constructor
	 */
	public Ej_Boton() {
		
		// desactivamos con null para utilizar el posicionamiento absoluto
		setLayout(null);
		
		// Creamos el botón
		boton = new JButton("BOTON");
		
		// Le damos una ubicación y un tamaño dentro de la ventana
		boton.setBounds(100, 40, 80, 25);
		
		// Añadimos el boton a la ventana
		add(boton);
	}

	// Programa principal donde llamamos al boton para crearlo como objeto
	public static void main(String[] args) {
		
		// Creamos el objeto boton
		Ej_Boton v = new Ej_Boton();

		v.setTitle("Ejemplo botón");
		v.setSize(300, 150);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
