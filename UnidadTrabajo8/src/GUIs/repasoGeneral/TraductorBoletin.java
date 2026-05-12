package GUIs.repasoGeneral;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Scanner;

public class TraductorBoletin extends JFrame implements ActionListener {

	private JTextField campoPalabra, campoTraduccion;
	private JButton botonBuscar, botonLimpiar;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private String rutaActual;
	
	private final String RUTA_ARCHIVO = "C:/proyectos/ingles.txt";
	private final String RUTA_ARCHIVO1 = "C:/proyectos/frances.txt";

	public TraductorBoletin() {

		rutaActual = RUTA_ARCHIVO;
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Idioma");
		menuBar.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("Inglés");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(this);

		mntmNewMenuItem_1 = new JMenuItem("Francés");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(this);

		// 1. ESTABLECEMOS EL GRIDLAYOUT DE 3 FILAS Y 2 COLUMNAS CON SEPARACIÓN DE 10 PÍXELES
		setLayout(new GridLayout(3, 2, 10, 10));
		
		// 2. AÑADIMOS UN BORDE PARA QUE LOS COMPONENTES NO TOQUEN LOS BORDES DE LA VENTANA
		((JPanel) getContentPane()).setBorder(new EmptyBorder(20, 20, 20, 20));

		// 3. INICIALIZAMOS LOS COMPONENTES DIRECTAMENTE (SIN PANELES INTERMEDIOS)
		campoPalabra = new JTextField();
		campoPalabra.setFont(new Font("Arial", Font.BOLD, 18));

		campoTraduccion = new JTextField();
		campoTraduccion.setEditable(false);
		campoTraduccion.setFont(new Font("Arial", Font.BOLD, 18));
		campoTraduccion.setBackground(new Color(240, 240, 240));

		botonBuscar = new JButton("Traducir");
		botonLimpiar = new JButton("Borrar");

		// 4. AÑADIMOS LOS COMPONENTES AL JFRAME SIGUIENDO EL ORDEN DEL GRID (IZQUIERDA A DERECHA)
		
		// FILA 1
		add(new JLabel("Palabra (Español):"));
		add(campoPalabra);

		// FILA 2
		add(new JLabel("Traducción:"));
		add(campoTraduccion);

		// FILA 3
		add(botonBuscar);
		add(botonLimpiar);

		// Vinculamos eventos
		botonBuscar.addActionListener(this);
		botonLimpiar.addActionListener(this);
		campoPalabra.addActionListener(this);

		setTitle("Traductor Español > Inglés");
		setSize(450, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == mntmNewMenuItem) {
			rutaActual = RUTA_ARCHIVO;
			setTitle("Traductor Español > Inglés");
			campoPalabra.setText("");
			campoTraduccion.setText("");
			JOptionPane.showMessageDialog(this, "Idioma cambiado a Inglés");
		}
		
		if (e.getSource() == mntmNewMenuItem_1) {
			rutaActual = RUTA_ARCHIVO1;
			setTitle("Traductor Español > Francés");
			campoPalabra.setText("");
			campoTraduccion.setText("");
			JOptionPane.showMessageDialog(this, "Idioma cambiado a Francés");
		}
		
		if (e.getSource() == botonLimpiar) {
			campoPalabra.setText("");
			campoTraduccion.setText("");
		}
		
		if (e.getSource() == botonBuscar || e.getSource() == campoPalabra) {

			String palabraBuscada = campoPalabra.getText().trim();

			if (palabraBuscada.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Introduce una palabra", "Aviso", JOptionPane.WARNING_MESSAGE);
				return;
			}

			File f = new File(rutaActual);
			boolean encontrado = false;

			try (Scanner s = new Scanner(f)) {
				while (s.hasNextLine() && !encontrado) {
					String linea = s.nextLine();

					if (linea.contains("=")) {
						String p1 = linea.substring(linea.indexOf('=') + 1).trim();

						if (p1.equalsIgnoreCase(palabraBuscada)) {
							String traduccion = linea.substring(0, linea.indexOf('=')).trim();
							campoTraduccion.setText(traduccion);
							encontrado = true;
						}
					}
				}

				if (!encontrado) {
					campoTraduccion.setText("");
					JOptionPane.showMessageDialog(this, "No encontrada", palabraBuscada, JOptionPane.INFORMATION_MESSAGE);
				}

			} catch (FileNotFoundException ex) {
				JOptionPane.showMessageDialog(this, "Error de archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void main(String[] args) {
		new TraductorBoletin();
	}
}