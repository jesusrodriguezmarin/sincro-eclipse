package GUIs.ejemplos.Absoluto;

import javax.swing.*;

public class RegistroUsuario extends JFrame {

	/**
	 * Componentes
	 */
	JLabel mensaje;
	JLabel mensaje2;
	JTextField campotexto;
	JTextField campotexto1;
	JCheckBox check1;
	// Control visual del botón
	JButton boton;

	/**
	 * Constructor de la ventana con: Una etiqueta Un campo de texto
	 */
	public RegistroUsuario() {

		setLayout(null);

		// Creamos una etiqueta
		mensaje = new JLabel("Usuario: ");
		// Damos tamaño
		mensaje.setBounds(20, 40, 100, 25);
		// Añadimos
		add(mensaje);

		mensaje2 = new JLabel("Contraseña: ");
		// Damos tamaño
		mensaje2.setBounds(20, 80, 100, 25);
		// Añadimos
		add(mensaje2);

		// Creamos campo de texto
		campotexto = new JTextField();
		// Damos tamaño
		campotexto.setBounds(100, 40, 175, 25);
		// Añadimos
		add(campotexto);

		// Creamos campo de texto
		campotexto1 = new JTextField();
		// Damos tamaño
		campotexto1.setBounds(100, 80, 175, 25);
		// Añadimos
		add(campotexto1);

		// CheckBox
		check1 = new JCheckBox("Recordar usuario");
		check1.setBounds(100, 120, 150, 25);
		add(check1);

		// Creamos el botón
		boton = new JButton("Entrar");

		// Le damos una ubicación y un tamaño dentro de la ventana
		boton.setBounds(130, 160, 80, 25);

		// Añadimos el boton a la ventana
		add(boton);
	}

	/*
	 * Ejecución de la aplicación
	 */
	public static void main(String[] args) {

		RegistroUsuario v = new RegistroUsuario();

		// Configuramos la ventana: damos titulo, ubicación, tamaño...
		v.setTitle("Acceso");
		v.setSize(350, 250);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
