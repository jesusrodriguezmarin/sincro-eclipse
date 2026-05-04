package GUIs.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarCambioColorFondo extends JFrame implements ActionListener {

	/*
	 * Componentes
	 */
	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem mitem1, mitem2, mitem3;

	/*
	 * Constructor Inicializa cada botón a un color
	 */
	public MenuBarCambioColorFondo() {

		// Posicionamiento absoluto
		setLayout(null);

		// Creamos el JMenuBar y lo asociamos al JFrame
		menubar = new JMenuBar();
		setJMenuBar(menubar);

		// Creanos el JMenu y lo asociamos al JMenuBar
		menu = new JMenu("Colores");
		menubar.add(menu);

		// Creamos los items y asociamos al JMenu y a la acción
		mitem1 = new JMenuItem("Rojo");
		menu.add(mitem1);
		mitem1.addActionListener(this);

		// Creamos los items y asociamos al JMenu y a la acción
		mitem2 = new JMenuItem("Verde");
		menu.add(mitem2);
		mitem2.addActionListener(this);

		// Creamos los items y asociamos al JMenu y a la acción
		mitem3 = new JMenuItem("Azul");
		menu.add(mitem3);
		mitem3.addActionListener(this);
	}

	/**
	 * Función que relaciona la acción con los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mitem1) {
			getContentPane().setBackground(Color.red);
		}
		if (e.getSource() == mitem2) {
			getContentPane().setBackground(Color.blue);
		}
		if (e.getSource() == mitem3) {
			getContentPane().setBackground(Color.green);
		}

	}

	// Programa principal
	public static void main(String[] args) {

		// Creamos una instancia de la clase
		MenuBarCambioColorFondo v = new MenuBarCambioColorFondo();
		v.setTitle("Colores");
		v.setSize(280, 200);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
