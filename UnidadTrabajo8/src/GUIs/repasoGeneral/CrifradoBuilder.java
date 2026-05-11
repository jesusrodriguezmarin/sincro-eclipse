package GUIs.repasoGeneral;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class CrifradoBuilder extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private ButtonGroup grupoBotones;

	// Inicio del constructor de la ventana
	public CrifradoBuilder() {
		// Configuramos el cierre de la aplicación
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Establecemos un tamaño más grande y cómodo para la vista
		setSize(600, 400);
		// Inicializamos el contenedor principal
		contentPane = new JPanel();
		// Aplicamos un margen interno de 20 píxeles para que nada toque los bordes
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		// Usamos BorderLayout para organizar las secciones principales
		contentPane.setLayout(new BorderLayout(20, 20));
		// Asignamos el panel a la ventana
		setContentPane(contentPane);

		// --- PANEL IZQUIERDO: OPCIONES DE CIFRADO ---
		// Creamos un panel con rejilla de 1 columna para alinear los botones verticalmente
		JPanel panelOpciones = new JPanel(new GridLayout(0, 1, 10, 10));
		// Le ponemos un borde con título para mejorar la estética
		panelOpciones.setBorder(BorderFactory.createTitledBorder(null, "MÉTODO DE CIFRADO", TitledBorder.CENTER, TitledBorder.TOP));

		// Inicializamos las opciones de radio
		rdbtnNewRadioButton = new JRadioButton("Algoritmo CESAR");
		rdbtnNewRadioButton_1 = new JRadioButton("Algoritmo ROT13");
		rdbtnNewRadioButton_2 = new JRadioButton("Algoritmo RIEL");

		// Agrupamos los botones para que solo se pueda marcar uno a la vez
		grupoBotones = new ButtonGroup();
		grupoBotones.add(rdbtnNewRadioButton);
		grupoBotones.add(rdbtnNewRadioButton_1);
		grupoBotones.add(rdbtnNewRadioButton_2);

		// Añadimos los radio buttons al panel de la izquierda
		panelOpciones.add(rdbtnNewRadioButton);
		panelOpciones.add(rdbtnNewRadioButton_1);
		panelOpciones.add(rdbtnNewRadioButton_2);
		
		// Colocamos el panel de opciones en la zona oeste (izquierda)
		contentPane.add(panelOpciones, BorderLayout.WEST);

		// --- PANEL DERECHO: ENTRADA Y SALIDA ---
		// Usamos otra rejilla para que los campos tengan el mismo tamaño
		JPanel panelTexto = new JPanel(new GridLayout(0, 1, 5, 5));
		panelTexto.setBorder(BorderFactory.createTitledBorder("MENSAJES"));

		// Etiqueta y campo para el texto original
		lblNewLabel_1 = new JLabel("Texto original a procesar:");
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 14));

		// Etiqueta y campo para el resultado (bloqueado para edición)
		lblNewLabel_2 = new JLabel("Resultado del cifrado:");
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBackground(new Color(245, 245, 245));
		textField_1.setFont(new Font("SansSerif", Font.BOLD, 14));

		// Añadimos los componentes al panel de texto
		panelTexto.add(lblNewLabel_1);
		panelTexto.add(textField);
		panelTexto.add(lblNewLabel_2);
		panelTexto.add(textField_1);

		// Colocamos el panel de texto en el centro para que use el espacio restante
		contentPane.add(panelTexto, BorderLayout.CENTER);

		// --- PANEL INFERIOR: BOTONES DE ACCIÓN ---
		// Usamos un panel con FlowLayout para centrar los botones de control
		JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
		
		// Botón de Cifrar con un color de fuente azul
		btnNewButton = new JButton("EJECUTAR CIFRADO");
		btnNewButton.setForeground(new Color(0, 51, 153));
		
		// Botón de Borrar con un color de fuente rojo
		btnNewButton_1 = new JButton("LIMPIAR CAMPOS");
		btnNewButton_1.setForeground(new Color(153, 0, 0));

		// Añadimos los botones al panel inferior
		panelAcciones.add(btnNewButton);
		panelAcciones.add(btnNewButton_1);
		
		// Colocamos el panel de botones en la zona sur (abajo)
		contentPane.add(panelAcciones, BorderLayout.SOUTH);

		// Vinculamos los botones al escuchador de eventos
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		
		// Centramos la ventana en la pantalla al iniciar
		setLocationRelativeTo(null);
	}

	// Método que gestiona la lógica de los clics
	public void actionPerformed(ActionEvent e) {
		// Acción al pulsar el botón CIFRAR
		if (e.getSource() == btnNewButton) {
			// Comprobamos si el campo de texto está vacío
			if (textField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Escribe el texto que deseas cifrar.", "Falta información", JOptionPane.WARNING_MESSAGE);
			} 
			// Comprobamos si no se ha seleccionado ningún algoritmo
			else if (!rdbtnNewRadioButton.isSelected() && !rdbtnNewRadioButton_1.isSelected() && !rdbtnNewRadioButton_2.isSelected()) {
				JOptionPane.showMessageDialog(this, "Selecciona un método de cifrado de la izquierda.", "Falta opción", JOptionPane.WARNING_MESSAGE);
			} else {
				// Ejecutamos el algoritmo correspondiente según el RadioButton marcado
				if (rdbtnNewRadioButton.isSelected())
					textField_1.setText(sustitucion(textField.getText(), CESAR));
				if (rdbtnNewRadioButton_1.isSelected())
					textField_1.setText(sustitucion(textField.getText(), ROT13));
				if (rdbtnNewRadioButton_2.isSelected())
					textField_1.setText(riel(textField.getText()));
			}
		}
		
		// Acción al pulsar el botón BORRAR
		if (e.getSource() == btnNewButton_1) {
			textField.setText("");
			textField_1.setText("");
			grupoBotones.clearSelection(); // Desmarcamos los radio buttons también
		}
	}

	// Constantes para los desplazamientos de letras
	private static final int CESAR = 3;
	private static final int ROT13 = 13;

	/**
	 * Método de cifrado por sustitución (César / Rot13)
	 */
	private static String sustitucion(String mensaje, int clave) {
		String encriptada = "";
		int caracter;

		for (int i = 0; i < mensaje.length(); i++) {
			char actual = mensaje.charAt(i);
			// Procesamos minúsculas
			if (actual >= 'a' && actual <= 'z') {
				caracter = actual + clave;
				if (caracter > 'z') caracter -= 26;
				encriptada += (char) caracter;
			} 
			// Procesamos mayúsculas
			else if (actual >= 'A' && actual <= 'Z') {
				caracter = actual + clave;
				if (caracter > 'Z') caracter -= 26;
				encriptada += (char) caracter;
			} 
			// Otros caracteres se quedan igual
			else {
				encriptada += actual;
			}
		}
		return encriptada;
	}

	/**
	 * Método de cifrado por transposición (Riel)
	 */
	private static String riel(String mensaje) {
		String cad1 = "", cad2 = "";
		for (int i = 0; i < mensaje.length(); i++) {
			if (i % 2 == 0) cad1 += mensaje.charAt(i);
			else cad2 += mensaje.charAt(i);
		}
		return cad1 + cad2;
	}

	/**
	 * Lanzamiento principal de la aplicación
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrifradoBuilder frame = new CrifradoBuilder();
					frame.setTitle("Cifrador de Mensajes v2.0");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}