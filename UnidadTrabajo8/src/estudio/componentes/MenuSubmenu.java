package estudio.componentes;

import javax.swing.*;
import java.awt.event.*;

public class MenuSubmenu extends JFrame implements ActionListener {

	private JMenuItem itemNuevo, itemSalir, itemFacil, itemDificil, itemAcerca;

	public MenuSubmenu() {
		// 1. Configuración de la ventana
		setTitle("Ventana con Menú y Submenús");
		setBounds(100, 100, 500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		// 2. Crear la Barra de Menú
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar); // Se asigna al JFrame

		// --- MENÚ ARCHIVO ---
		JMenu menuArchivo = new JMenu("Archivo");
		menuBar.add(menuArchivo);

		itemNuevo = new JMenuItem("Nuevo Juego");
		itemNuevo.addActionListener(this);
		menuArchivo.add(itemNuevo);

		menuArchivo.addSeparator(); // Línea divisoria

		itemSalir = new JMenuItem("Salir");
		itemSalir.addActionListener(this);
		menuArchivo.add(itemSalir);

		// --- MENÚ OPCIONES (Con Submenú) ---
		JMenu menuOpciones = new JMenu("Opciones");
		menuBar.add(menuOpciones);

		// CREAR EL SUBMENÚ (Es un JMenu que irá dentro de Opciones)
		JMenu subMenuDificultad = new JMenu("Cambiar Dificultad");
		
		itemFacil = new JMenuItem("Modo Fácil");
		itemFacil.addActionListener(this);
		subMenuDificultad.add(itemFacil);

		itemDificil = new JMenuItem("Modo Difícil");
		itemDificil.addActionListener(this);
		subMenuDificultad.add(itemDificil);

		// Añadimos el submenú al menú principal "Opciones"
		menuOpciones.add(subMenuDificultad);

		// --- MENÚ AYUDA ---
		JMenu menuAyuda = new JMenu("Ayuda");
		menuBar.add(menuAyuda);

		itemAcerca = new JMenuItem("Acerca de...");
		itemAcerca.addActionListener(this);
		menuAyuda.add(itemAcerca);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Lógica para saber qué opción se ha pulsado
		if (e.getSource() == itemSalir) {
			System.exit(0);
		} else if (e.getSource() == itemFacil) {
			JOptionPane.showMessageDialog(this, "Dificultad cambiada a FÁCIL");
		} else if (e.getSource() == itemDificil) {
			JOptionPane.showMessageDialog(this, "Dificultad cambiada a DIFÍCIL");
		} else if (e.getSource() == itemAcerca) {
			JOptionPane.showMessageDialog(this, "Examen Swing - v1.0");
		}
	}

	public static void main(String[] args) {
		new MenuSubmenu().setVisible(true);
	}
}