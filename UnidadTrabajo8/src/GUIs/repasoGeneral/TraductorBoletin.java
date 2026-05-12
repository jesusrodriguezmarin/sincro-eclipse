package GUIs.repasoGeneral;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.*;
import java.util.Scanner;

public class TraductorBoletin extends JFrame implements ActionListener {

	// Componentes
	private JTextField campoPalabra, campoTraduccion;
	private JButton botonBuscar, botonLimpiar;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;

	// Ruta de los archivos
	private final String RUTA_ARCHIVO = "C:/proyectos/ingles.txt";

	/// Ruta para el archivo en Frances
	//private final String RUTA_ARCHIVO1 = "C:/proyectos/frances.txt";

	/**
	 * Comstructor
	 */
	public TraductorBoletin() {

		// Menús
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

		
		setLayout(new BorderLayout(15, 15));
		((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

		// --- BLOQUE SUPERIOR: ENTRADA Y SALIDA ---
		// Panel organizado en dos columnas para las etiquetas y los campos
		JPanel panelCampos = new JPanel(new GridLayout(2, 2, 5, 5));

		// Inicializamos el campo de búsqueda (editable para teclado físico)
		campoPalabra = new JTextField();
		campoPalabra.setFont(new Font("Arial", Font.BOLD, 18));

		// Inicializamos el campo donde se mostrará la traducción (solo lectura)
		campoTraduccion = new JTextField();
		campoTraduccion.setEditable(false);
		campoTraduccion.setFont(new Font("Arial", Font.BOLD, 18));
		campoTraduccion.setBackground(new Color(240, 240, 240));

		// Añadimos las instrucciones y los campos al panel
		panelCampos.add(new JLabel("Palabra (en español):", SwingConstants.LEFT));
		panelCampos.add(new JLabel("Traducción:", SwingConstants.RIGHT));
		panelCampos.add(campoPalabra);
		panelCampos.add(campoTraduccion);

		add(panelCampos, BorderLayout.CENTER);

		// --- BLOQUE INFERIOR: CONTROL ---
		// Panel para los botones de acción principal
		JPanel panelBotones = new JPanel(new FlowLayout());
		botonBuscar = new JButton("Traducir");
		botonLimpiar = new JButton("Borrar");

		panelBotones.add(botonBuscar);
		panelBotones.add(botonLimpiar);
		add(panelBotones, BorderLayout.SOUTH);

		// Vinculamos los botones al escuchador de eventos
		botonBuscar.addActionListener(this);
		botonLimpiar.addActionListener(this);
		// Permitimos que al pulsar "Enter" en el teclado se ejecute la búsqueda
		campoPalabra.addActionListener(this);

		// Configuración de las propiedades de la ventana
		setTitle("Traductor Español > Inglés");
		setSize(450, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	// Gestión de las acciones del usuario
	@Override
	public void actionPerformed(ActionEvent e) {

		// Si el usuario pulsa el botón de limpiar
		if (e.getSource() == botonLimpiar) {
			campoPalabra.setText("");
			campoTraduccion.setText("");

		}
		

		// Acción para inglés
		if (e.getSource() == botonBuscar || e.getSource() == campoPalabra) {

			// Obtenemos el texto introducido quitando espacios vacíos
			String palabraBuscada = campoPalabra.getText().trim();

			// Validamos que el campo no esté vacío
			if (palabraBuscada.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Introduce una palabra a traducir, por favor", "Aviso",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			// Creamos el objeto para acceder al fichero en inglés
			File f = new File(RUTA_ARCHIVO);
			boolean encontrado = false;

			// Bloque try-with-resources para cerrar el Scanner automáticamente
			try (Scanner s = new Scanner(f)) {
				// Recorremos el fichero línea a línea mientras no lo encontremos
				while (s.hasNextLine() && !encontrado) {
					String linea = s.nextLine();

					// Verificamos el formato de la línea con el separador '='
					if (linea.contains("=")) {

						// Extraemos la palabra original (parte derecha)
						String p1 = linea.substring(linea.indexOf('=') + 1).trim();

						// Comparamos la palabra del fichero con la del usuario
						if (p1.equalsIgnoreCase(palabraBuscada)) {

							// Extraemos la traducción (parte izquierda)
							String traduccion = linea.substring(0, linea.indexOf('=')).trim();
							campoTraduccion.setText(traduccion);

							encontrado = true;
						}
					}
				}

				// Mostramos ventana emergente de error
				if (!encontrado) {
					campoTraduccion.setText("");

					JOptionPane.showMessageDialog(this,
							"Lo siento, no se ha encontrado la palabra en nuestro diccionario", palabraBuscada,
							JOptionPane.INFORMATION_MESSAGE);
				}

			} catch (FileNotFoundException ex) {
				// Aviso en caso de que la ruta del archivo sea incorrecta
				JOptionPane.showMessageDialog(this, "Error: No se encuentra el archivo en la ruta especificada.",
						"Fallo de Sistema", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	// Método principal para arrancar la ventana
	public static void main(String[] args) {
		new TraductorBoletin();
	}
}