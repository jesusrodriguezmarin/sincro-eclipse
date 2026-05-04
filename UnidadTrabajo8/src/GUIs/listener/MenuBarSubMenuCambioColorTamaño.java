package GUIs.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarSubMenuCambioColorTamaño extends JFrame implements ActionListener {

	/*
	 * Componentes
	 */
	private JMenuBar menubar;
	private JMenu menu, menuCol, menuTam;
	private JMenuItem mitemCol1, mitemCol2, mitemTam1, mitemTam2;

	/*
	 * Constructor Inicializa cada botón a un color
	 */
	public MenuBarSubMenuCambioColorTamaño() {

		// Posicionamiento absoluto
		setLayout(null);

		// Creamos el JMenuBar y lo asociamos al JFrame
		menubar = new JMenuBar();
		setJMenuBar(menubar);

		// Creanos el JMenu y lo asociamos al JMenuBar
		menu = new JMenu("Opciones");
		menubar.add(menu);

		// Creamos JMenu de colores y JMenu de tamaños y asociamos al JMenu
		menuCol = new JMenu("Colores");
		menu.add(menuCol);
		menuTam = new JMenu("Tamaño");
		menu.add(menuTam);

		// Creamos los items y asociamos al JMenu y a la acción
		mitemCol1 = new JMenuItem("Rojo");
		menuCol.add(mitemCol1);
		mitemCol1.addActionListener(this);

		// Creamos los items y asociamos al JMenu y a la acción
		mitemCol2 = new JMenuItem("Verde");
		menuCol.add(mitemCol2);
		mitemCol2.addActionListener(this);

		// Creamos los items y asociamos al JMenu y a la acción
		mitemTam1 = new JMenuItem("640x480");
		menuTam.add(mitemTam1);
		mitemTam1.addActionListener(this);

		// Creamos los items y asociamos al JMenu y a la acción
		mitemTam2 = new JMenuItem("1024x768");
		menuTam.add(mitemTam2);
		mitemTam2.addActionListener(this);
	}

	/**
	 * Función que relaciona la acción con los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mitemCol1) {
			getContentPane().setBackground(Color.red);
		}
		if (e.getSource() == mitemCol2) {
			getContentPane().setBackground(Color.green);
		}
		if (e.getSource() == mitemTam1) {
			setSize(640,480);
			setLocationRelativeTo(null);
		}
		if (e.getSource() == mitemTam2) {
			setSize(1024,768);
			setLocationRelativeTo(null);
		}

	}

	// Programa principal
	public static void main(String[] args) {

		// Creamos una instancia de la clase
		MenuBarSubMenuCambioColorTamaño v = new MenuBarSubMenuCambioColorTamaño();
		v.setTitle("Colores");
		v.setSize(280, 200);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
