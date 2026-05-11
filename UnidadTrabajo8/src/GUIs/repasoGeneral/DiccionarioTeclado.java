package GUIs.repasoGeneral;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.*;
import java.util.Scanner;

public class DiccionarioTeclado extends JFrame implements ActionListener {

	// Componentes de la interfaz para la entrada y salida de datos
	private JTextField campoPalabra, campoTraduccion;
	private JLabel etiquetaEstado;
	private JPanel panelSuperior, panelCentral, panelTeclado, panelControles, contenedorContenido;
	
	// Distribución de teclas alfabéticas tipo QWERTY
	private String[] letras = {
		"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",
		"A", "S", "D", "F", "G", "H", "J", "K", "L", "Ñ",
		"Z", "X", "C", "V", "B", "N", "M"
	};
	// Botones para el teclado virtual
	private JButton[] botonesLetras = new JButton[letras.length];
	
	// Botones de ejecución y control
	private JButton botonBuscar, botonLimpiar, botonBorrar;

	// Ruta del archivo de datos extraída de la configuración original
	private final String RUTA_ARCHIVO = "/Users/jesusrodriguezmarin/Documents/ficherosEclipse/dictionary.txt";

	// Constructor de la ventana para organizar la interfaz
	public DiccionarioTeclado() {
		// Configuramos el diseño principal con separación entre zonas
		setLayout(new BorderLayout(10, 10));
		// Añadimos un margen interno general de 20 píxeles para equilibrar la vista
		((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// --- CONTENEDOR DE CONTENIDO (ZONA SUPERIOR + CENTRAL) ---
		// Creamos un panel que agrupe todo lo que no es el teclado para equilibrar distancias
		contenedorContenido = new JPanel(new GridLayout(2, 1, 0, 20));

		// --- BLOQUE DE PANTALLA (SUPERIOR) ---
		panelSuperior = new JPanel(new GridLayout(0, 1, 0, 5));
		
		// Campo para la palabra escrita (reducido a 15 de ancho)
		campoPalabra = new JTextField(15);
		campoPalabra.setEditable(false);
		campoPalabra.setHorizontalAlignment(JTextField.CENTER);
		campoPalabra.setFont(new Font("Arial", Font.BOLD, 18));
		campoPalabra.setBackground(Color.WHITE);
		
		// Campo para el resultado de la traducción (reducido a 15 de ancho)
		campoTraduccion = new JTextField(15);
		campoTraduccion.setEditable(false);
		campoTraduccion.setHorizontalAlignment(JTextField.CENTER);
		campoTraduccion.setFont(new Font("Arial", Font.BOLD, 18));
		campoTraduccion.setBackground(new Color(255, 255, 220));

		// Paneles para centrar los campos de texto y que no se estiren
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		panelSuperior.add(new JLabel("Palabra introducida:", SwingConstants.CENTER));
		p1.add(campoPalabra);
		panelSuperior.add(p1);
		panelSuperior.add(new JLabel("Traducción encontrada:", SwingConstants.CENTER));
		p2.add(campoTraduccion);
		panelSuperior.add(p2);

		// --- BLOQUE DE ACCIONES (CENTRAL) ---
		panelCentral = new JPanel(new BorderLayout(10, 10));
		
		// Etiqueta de estado del sistema
		etiquetaEstado = new JLabel("Escribe una palabra y pulsa Traducir", SwingConstants.CENTER);
		etiquetaEstado.setFont(new Font("Arial", Font.BOLD, 13));
		
		// Botones de control
		panelControles = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		botonBuscar = new JButton("Traducir");
		botonBorrar = new JButton("Borrar letra");
		botonLimpiar = new JButton("Nueva búsqueda");
		
		panelControles.add(botonBuscar);
		panelControles.add(botonBorrar);
		panelControles.add(botonLimpiar);
		
		panelCentral.add(etiquetaEstado, BorderLayout.NORTH);
		panelCentral.add(panelControles, BorderLayout.CENTER);

		// Añadimos ambos bloques al contenedor para que se repartan el espacio
		contenedorContenido.add(panelSuperior);
		contenedorContenido.add(panelCentral);
		
		// Colocamos el contenedor equilibrado en el centro de la ventana
		add(contenedorContenido, BorderLayout.CENTER);

		// --- BLOQUE DE TECLADO (SUR) ---
		panelTeclado = new JPanel(new GridLayout(3, 10, 4, 4));
		for (int i = 0; i < letras.length; i++) {
			botonesLetras[i] = new JButton(letras[i]);
			botonesLetras[i].setFocusable(false);
			botonesLetras[i].addActionListener(this);
			panelTeclado.add(botonesLetras[i]);
		}
		// El teclado permanece fijo en la parte inferior
		add(panelTeclado, BorderLayout.SOUTH);

		// Asignación de eventos a los botones de acción
		botonBuscar.addActionListener(this);
		botonBorrar.addActionListener(this);
		botonLimpiar.addActionListener(this);

		// Parámetros de configuración de la ventana
		setTitle("Diccionario Teclado Equilibrado");
		setSize(600, 650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	// Gestión de las pulsaciones del usuario
	@Override
	public void actionPerformed(ActionEvent e) {
		// Captura de letras del teclado virtual
		for (int i = 0; i < letras.length; i++) {
			if (e.getSource() == botonesLetras[i]) {
				campoPalabra.setText(campoPalabra.getText() + letras[i]);
			}
		}

		// Acción de borrar el último carácter
		if (e.getSource() == botonBorrar) {
			String texto = campoPalabra.getText();
			if (texto.length() > 0) {
				campoPalabra.setText(texto.substring(0, texto.length() - 1));
			}
		}

		// Acción de resetear la búsqueda
		if (e.getSource() == botonLimpiar) {
			campoPalabra.setText("");
			campoTraduccion.setText("");
			etiquetaEstado.setText("Escribe una palabra y pulsa Traducir");
			etiquetaEstado.setForeground(Color.BLACK);
		}

		// Acción de búsqueda en el archivo dictionary.txt
		if (e.getSource() == botonBuscar) {
			String palabraBuscada = campoPalabra.getText().trim();
			
			if (palabraBuscada.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Introduce una palabra para traducir.");
				return;
			}

			File f = new File(RUTA_ARCHIVO);
			boolean encontrado = false;

			try (Scanner s = new Scanner(f)) {
				while (s.hasNextLine() && !encontrado) {
					String linea = s.nextLine();
					if (linea.contains("=")) {
						String p1 = linea.substring(0, linea.indexOf('=')).trim();
						if (p1.equalsIgnoreCase(palabraBuscada)) {
							String traduccion = linea.substring(linea.indexOf('=') + 1).trim();
							campoTraduccion.setText(traduccion);
							etiquetaEstado.setText("¡Palabra encontrada!");
							etiquetaEstado.setForeground(new Color(0, 120, 0));
							encontrado = true;
						}
					}
				}

				// Ventana emergente si no existe la palabra
				if (!encontrado) {
					campoTraduccion.setText("");
					etiquetaEstado.setText("No encontrada.");
					etiquetaEstado.setForeground(Color.RED);
					JOptionPane.showMessageDialog(this, 
						"La palabra '" + palabraBuscada + "' no existe en el archivo.", 
						"Aviso", JOptionPane.WARNING_MESSAGE);
				}

			} catch (FileNotFoundException ex) {
				JOptionPane.showMessageDialog(this, "Error: Archivo no encontrado en " + RUTA_ARCHIVO);
			}
		}
	}

	// Ejecución del programa
	public static void main(String[] args) {
		new DiccionarioTeclado();
	}
}