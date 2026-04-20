package GUIs.componentes;

import javax.swing.*;

public class Ej_CampoTexto extends JFrame {

	/**
	 * Componentes
	 */
	JLabel mensaje;
	JTextField campotexto;
	
	/**
	 * Constructor de la ventana con:
	 * Una etiqueta
	 * Un campo de texto
	 */
	public Ej_CampoTexto() {
		
		setLayout(null);
		
		// Creamos una etiqueta
		mensaje = new JLabel("Usuario: ");
		// Damos tamaño
		mensaje.setBounds(20, 40, 100, 25);
		// Añadimos
		add(mensaje);
		
		// Creamos campo de texto
		campotexto = new JTextField();
		// Damos tamaño
		campotexto.setBounds(80, 40, 175, 25);
		// Añadimos
		add(campotexto);
	}
	
	/*
	 * Ejecución de la aplicación
	 */
	public static void main(String[] args) {

		Ej_CampoTexto v = new Ej_CampoTexto();
		
		// Configuramos la ventana: damos titulo, ubicación, tamaño...
		v.setTitle("Ejemplo CampoTexto");
		v.setSize(300, 150);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
