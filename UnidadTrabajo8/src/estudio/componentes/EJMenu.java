package estudio.componentes;

import javax.swing.*;

public class EJMenu extends JFrame {

	public EJMenu() {
		setTitle("Ventana con Menú");
		setBounds(100, 100, 400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar); // Se asigna directamente al Frame

		JMenu menuArchivo = new JMenu("Archivo");
		menuBar.add(menuArchivo);

		JMenuItem itemSalir = new JMenuItem("Salir");
		itemSalir.addActionListener(e -> System.exit(0));
		menuArchivo.add(itemSalir);
		
		// Otro menú
		JMenu menuAyuda = new JMenu("Ayuda");
		menuBar.add(menuAyuda);
		menuAyuda.add(new JMenuItem("Acerca de..."));
	}

	public static void main(String[] args) { new EJMenu().setVisible(true); }
}