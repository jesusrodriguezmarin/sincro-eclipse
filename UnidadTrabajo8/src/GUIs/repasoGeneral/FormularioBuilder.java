package GUIs.repasoGeneral;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class FormularioBuilder extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField, textField_1, textField_2;
	private JTextArea textArea, textArea_1, textArea_2;
	private JComboBox<String> comboBox, comboBox_1, comboBox_2;
	private JButton btnNewButton, btnNewButton_1;
	private JRadioButton rdbtnNewRadioButton, rdbtnNewRadioButton_1, rdbtnNewRadioButton_2;
	private ButtonGroup grupoBotones;

	// Inicio del constructor para montar el formulario
	public FormularioBuilder() {
		// Configuramos la salida al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Definimos un tamaño de ventana amplio y equilibrado
		setSize(900, 600);

		// Creamos la barra de menú superior
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// Inicializamos el panel principal con un margen de separación
		contentPane = new JPanel(new BorderLayout(20, 20));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		setContentPane(contentPane);

		// --- CONTENEDOR DIVIDIDO EN DOS COLUMNAS ---
		JPanel panelCentral = new JPanel(new GridLayout(1, 2, 20, 0));
		contentPane.add(panelCentral, BorderLayout.CENTER);

		// --- COLUMNA IZQUIERDA: DATOS PERSONALES ---
		JPanel panelIzquierdo = new JPanel(new BorderLayout(10, 10));
		panelIzquierdo.setBorder(BorderFactory.createTitledBorder(null, " DATOS PERSONALES ", TitledBorder.LEFT, TitledBorder.TOP));
		
		// Panel para nombre y apellidos
		JPanel panelFicha = new JPanel(new GridLayout(0, 1, 5, 5));
		panelFicha.add(new JLabel("Nombre:"));
		textField = new JTextField();
		panelFicha.add(textField);
		panelFicha.add(new JLabel("Apellidos:"));
		textField_1 = new JTextField();
		panelFicha.add(textField_1);
		
		// Panel para la fecha de nacimiento
		JPanel panelFecha = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		panelFecha.setBorder(BorderFactory.createTitledBorder("Fecha de nacimiento"));
		
		// Inicializamos combos de día, mes y año
		comboBox = new JComboBox<>();
		for(int i=1; i<=31; i++) comboBox.addItem(String.valueOf(i));
		comboBox_1 = new JComboBox<>();
		for(int i=1; i<=12; i++) comboBox_1.addItem(String.valueOf(i));
		comboBox_2 = new JComboBox<>();
		for(int i=1990; i<=2026; i++) comboBox_2.addItem(String.valueOf(i));
		
		panelFecha.add(new JLabel("Día:")); panelFecha.add(comboBox);
		panelFecha.add(new JLabel("Mes:")); panelFecha.add(comboBox_1);
		panelFecha.add(new JLabel("Año:")); panelFecha.add(comboBox_2);

		// Panel para comentarios y edad
		JPanel panelExtra = new JPanel(new BorderLayout(5, 5));
		panelExtra.add(new JLabel("Comentarios:"), BorderLayout.NORTH);
		textArea = new JTextArea(5, 20);
		panelExtra.add(new JScrollPane(textArea), BorderLayout.CENTER);
		
		JPanel panelEdad = new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnNewButton = new JButton("Calcular edad");
		textField_2 = new JTextField(4);
		textField_2.setEditable(false);
		panelEdad.add(btnNewButton);
		panelEdad.add(new JLabel("Edad:"));
		panelEdad.add(textField_2);
		
		// Ensamblamos la columna izquierda
		JPanel subPanelIzquierdo = new JPanel(new BorderLayout(10, 10));
		subPanelIzquierdo.add(panelFicha, BorderLayout.NORTH);
		subPanelIzquierdo.add(panelFecha, BorderLayout.CENTER);
		subPanelIzquierdo.add(panelExtra, BorderLayout.SOUTH);
		panelIzquierdo.add(subPanelIzquierdo, BorderLayout.NORTH);
		panelIzquierdo.add(panelEdad, BorderLayout.SOUTH);
		
		panelCentral.add(panelIzquierdo);

		// --- COLUMNA DERECHA: HERRAMIENTA DE CIFRADO ---
		JPanel panelDerecho = new JPanel(new BorderLayout(10, 10));
		panelDerecho.setBorder(BorderFactory.createTitledBorder(null, " CIFRADOR DE TEXTO ", TitledBorder.LEFT, TitledBorder.TOP));

		// Panel de entrada de texto claro
		JPanel panelInputCifrado = new JPanel(new BorderLayout(5, 5));
		panelInputCifrado.add(new JLabel("Texto original:"), BorderLayout.NORTH);
		textArea_1 = new JTextArea(4, 20);
		panelInputCifrado.add(new JScrollPane(textArea_1), BorderLayout.CENTER);

		// Panel de opciones de cifrado
		JPanel panelRadios = new JPanel(new GridLayout(1, 0));
		panelRadios.setBorder(BorderFactory.createTitledBorder("Tipo de algoritmo"));
		rdbtnNewRadioButton = new JRadioButton("CESAR");
		rdbtnNewRadioButton_1 = new JRadioButton("ROT13");
		rdbtnNewRadioButton_2 = new JRadioButton("RIEL");
		grupoBotones = new ButtonGroup();
		grupoBotones.add(rdbtnNewRadioButton); grupoBotones.add(rdbtnNewRadioButton_1); grupoBotones.add(rdbtnNewRadioButton_2);
		panelRadios.add(rdbtnNewRadioButton); panelRadios.add(rdbtnNewRadioButton_1); panelRadios.add(rdbtnNewRadioButton_2);

		// Panel de resultado cifrado
		JPanel panelOutputCifrado = new JPanel(new BorderLayout(5, 5));
		btnNewButton_1 = new JButton("EJECUTAR CIFRADO");
		panelOutputCifrado.add(btnNewButton_1, BorderLayout.NORTH);
		textArea_2 = new JTextArea(4, 20);
		textArea_2.setEditable(false);
		textArea_2.setBackground(new Color(240, 240, 240));
		panelOutputCifrado.add(new JScrollPane(textArea_2), BorderLayout.CENTER);

		panelDerecho.add(panelInputCifrado, BorderLayout.NORTH);
		panelDerecho.add(panelRadios, BorderLayout.CENTER);
		panelDerecho.add(panelOutputCifrado, BorderLayout.SOUTH);

		panelCentral.add(panelDerecho);

		// Registro de escuchadores de eventos
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
	}

	// Gestión de las acciones del formulario
	@Override
	public void actionPerformed(ActionEvent e) {
		// Lógica para el cálculo de la edad
		if (e.getSource() == btnNewButton) {
			try {
				// Capturamos los valores seleccionados en los combos
				int d = Integer.parseInt(comboBox.getSelectedItem().toString());
				int m = Integer.parseInt(comboBox_1.getSelectedItem().toString());
				int a = Integer.parseInt(comboBox_2.getSelectedItem().toString());

				// Invocamos la función de cálculo y mostramos el resultado
				int resultadoEdad = edad(a, m, d);
				textField_2.setText(String.valueOf(resultadoEdad));
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Error al procesar la fecha");
			}
		} 
		// Lógica para el cifrado de mensajes
		else if (e.getSource() == btnNewButton_1) {
			// Validamos que exista texto en el área de entrada
			if (textArea_1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Introduce el texto a cifrar", "AVISO", JOptionPane.WARNING_MESSAGE);
			} 
			// Validamos que se haya marcado un RadioButton
			else if (!rdbtnNewRadioButton.isSelected() && !rdbtnNewRadioButton_1.isSelected() && !rdbtnNewRadioButton_2.isSelected()) {
				JOptionPane.showMessageDialog(this, "Selecciona un método de cifrado", "AVISO", JOptionPane.WARNING_MESSAGE);
			} else {
				// Aplicamos el algoritmo correspondiente
				if (rdbtnNewRadioButton.isSelected())
					textArea_2.setText(sustitucion(textArea_1.getText(), CESAR));
				else if (rdbtnNewRadioButton_1.isSelected())
					textArea_2.setText(sustitucion(textArea_1.getText(), ROT13));
				else if (rdbtnNewRadioButton_2.isSelected())
					textArea_2.setText(riel(textArea_1.getText()));
			}
		}
	}

	// Método estático para calcular la edad actual
	private static int edad(int a, int m, int d) {
		// Obtenemos la fecha actual del sistema
		Date hoy = new Date();
		int aHoy = Integer.parseInt(new SimpleDateFormat("yyyy").format(hoy));
		int mHoy = Integer.parseInt(new SimpleDateFormat("MM").format(hoy));
		int dHoy = Integer.parseInt(new SimpleDateFormat("dd").format(hoy));

		// Cálculo base por diferencia de años
		int e = aHoy - a;
		// Ajustamos si aún no ha llegado el día del cumpleaños en el año actual
		if (mHoy < m || (mHoy == m && dHoy < d)) {
			e--;
		}
		return e;
	}

	// Constantes para los desplazamientos de sustitución
	private static final int CESAR = 3;
	private static final int ROT13 = 13;

	// Método para cifrar por desplazamiento de caracteres
	private static String sustitucion(String mensaje, int clave) {
		String encriptada = "";
		for (int i = 0; i < mensaje.length(); i++) {
			char c = mensaje.charAt(i);
			// Cifrado para minúsculas
			if (c >= 'a' && c <= 'z') {
				int car = c + clave;
				if (car > 'z') car -= 26;
				encriptada += (char) car;
			} 
			// Cifrado para mayúsculas
			else if (c >= 'A' && c <= 'Z') {
				int car = c + clave;
				if (car > 'Z') car -= 26;
				encriptada += (char) car;
			} 
			// Otros caracteres se mantienen íntegros
			else {
				encriptada += c;
			}
		}
		return encriptada;
	}

	// Método para cifrar por transposición (método del riel)
	private static String riel(String mensaje) {
		String cad1 = "", cad2 = "";
		for (int i = 0; i < mensaje.length(); i++) {
			// Separamos posiciones pares de impares
			if (i % 2 == 0) cad1 += mensaje.charAt(i);
			else cad2 += mensaje.charAt(i);
		}
		// Concatenamos ambos bloques de caracteres
		return cad1 + cad2;
	}

	// Método principal para ejecutar la aplicación
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				// Instanciamos el formulario y configuramos su visibilidad
				FormularioBuilder frame = new FormularioBuilder();
				frame.setTitle("Formulario Integrado y Cifrador");
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}