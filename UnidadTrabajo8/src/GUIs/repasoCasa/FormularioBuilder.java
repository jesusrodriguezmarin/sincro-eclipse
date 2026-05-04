package GUIs.repasoCasa;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class FormularioBuilder extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField, textField_1, textField_2;
	private JTextArea textArea, textArea_1, textArea_2;
	private JComboBox<String> comboBox, comboBox_1, comboBox_2;
	private JButton btnNewButton, btnNewButton_1;
	private JRadioButton rdbtnNewRadioButton, rdbtnNewRadioButton_1, rdbtnNewRadioButton_2;
	private ButtonGroup grupoBotones;

	/**
	 * Constructor
	 */
	public FormularioBuilder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 481);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Sección Datos Personales
		contentPane.add(new JLabel("Nombre:")).setBounds(20, 15, 61, 16);
		textField = new JTextField();
		textField.setBounds(20, 30, 130, 26);
		contentPane.add(textField);

		contentPane.add(new JLabel("Apellidos:")).setBounds(20, 70, 149, 16);
		textField_1 = new JTextField();
		textField_1.setBounds(20, 85, 178, 26);
		contentPane.add(textField_1);

		// Sección Fecha de Nacimiento
		contentPane.add(new JLabel("Fecha de nacimiento:")).setBounds(20, 135, 176, 16);
		
		contentPane.add(new JLabel("Día")).setBounds(20, 183, 46, 16);
		comboBox = new JComboBox<>();
		comboBox.setBounds(20, 211, 76, 27);
		for(int i=1; i<=31; i++) comboBox.addItem(String.valueOf(i));
		contentPane.add(comboBox);

		contentPane.add(new JLabel("Mes")).setBounds(154, 183, 46, 16);
		comboBox_1 = new JComboBox<>();
		comboBox_1.setBounds(146, 211, 76, 27);
		for(int i=1; i<=12; i++) comboBox_1.addItem(String.valueOf(i));
		contentPane.add(comboBox_1);

		contentPane.add(new JLabel("Año")).setBounds(277, 183, 61, 16);
		comboBox_2 = new JComboBox<>();
		comboBox_2.setBounds(265, 211, 98, 27);
		for(int i=1990; i<=2024; i++) comboBox_2.addItem(String.valueOf(i));
		contentPane.add(comboBox_2);

		// Sección Edad
		btnNewButton = new JButton("Generar edad");
		btnNewButton.setBounds(265, 278, 117, 29);
		btnNewButton.addActionListener(this); // Registro 1
		contentPane.add(btnNewButton);

		contentPane.add(new JLabel("Edad:")).setBounds(277, 343, 149, 16);
		textField_2 = new JTextField();
		textField_2.setBounds(277, 371, 50, 26);
		textField_2.setEditable(false);
		contentPane.add(textField_2);

		// Comentarios
		contentPane.add(new JLabel("Comentarios:")).setBounds(20, 283, 149, 16);
		textArea = new JTextArea();
		textArea.setBounds(20, 311, 220, 86);
		contentPane.add(textArea);

		// Sección Cifrado
		contentPane.add(new JLabel("Introduce el texto a cifrar:")).setBounds(452, 15, 189, 16);
		textArea_1 = new JTextArea();
		textArea_1.setBounds(452, 43, 189, 62);
		contentPane.add(textArea_1);

		contentPane.add(new JLabel("Elige el tipo de cifrado:")).setBounds(452, 117, 189, 16);
		rdbtnNewRadioButton = new JRadioButton("CESAR3");
		rdbtnNewRadioButton.setBounds(452, 145, 141, 23);
		rdbtnNewRadioButton_1 = new JRadioButton("ROT13");
		rdbtnNewRadioButton_1.setBounds(452, 179, 141, 23);
		rdbtnNewRadioButton_2 = new JRadioButton("RIEL");
		rdbtnNewRadioButton_2.setBounds(452, 214, 141, 23);

		grupoBotones = new ButtonGroup();
		grupoBotones.add(rdbtnNewRadioButton);
		grupoBotones.add(rdbtnNewRadioButton_1);
		grupoBotones.add(rdbtnNewRadioButton_2);
		contentPane.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton_1);
		contentPane.add(rdbtnNewRadioButton_2);

		btnNewButton_1 = new JButton("CIFRAR");
		btnNewButton_1.setBounds(476, 259, 117, 29);
		btnNewButton_1.addActionListener(this); // Registro 2
		contentPane.add(btnNewButton_1);

		contentPane.add(new JLabel("Resultado:")).setBounds(452, 311, 159, 16);
		textArea_2 = new JTextArea();
		textArea_2.setBounds(452, 335, 189, 62);
		textArea_2.setEditable(false);
		contentPane.add(textArea_2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ACCIÓN GENERAR EDAD
		if (e.getSource() == btnNewButton) {
			try {
				int d = Integer.parseInt(comboBox.getSelectedItem().toString());
				int m = Integer.parseInt(comboBox_1.getSelectedItem().toString());
				int a = Integer.parseInt(comboBox_2.getSelectedItem().toString());

				int resultadoEdad = edad(a, m, d); // Llamada corregida (año, mes, día)
				textField_2.setText(String.valueOf(resultadoEdad));
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Error al procesar la fecha");
			}
		} 
		// ACCIÓN CIFRAR
		else if (e.getSource() == btnNewButton_1) {
			if (textArea_1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Debes utilizar un texto claro", "AVISO", JOptionPane.WARNING_MESSAGE);
			} else if (!rdbtnNewRadioButton.isSelected() && !rdbtnNewRadioButton_1.isSelected() && !rdbtnNewRadioButton_2.isSelected()) {
				JOptionPane.showMessageDialog(this, "Debes elegir una opción de cifrado", "AVISO", JOptionPane.WARNING_MESSAGE);
			} else {
				if (rdbtnNewRadioButton.isSelected())
					textArea_2.setText(sustitucion(textArea_1.getText(), CESAR));
				else if (rdbtnNewRadioButton_1.isSelected())
					textArea_2.setText(sustitucion(textArea_1.getText(), ROT13));
				else if (rdbtnNewRadioButton_2.isSelected())
					textArea_2.setText(riel(textArea_1.getText()));
			}
		}
	}

	private static int edad(int a, int m, int d) {
		Date hoy = new Date();
		int aHoy = Integer.parseInt(new SimpleDateFormat("yyyy").format(hoy));
		int mHoy = Integer.parseInt(new SimpleDateFormat("MM").format(hoy));
		int dHoy = Integer.parseInt(new SimpleDateFormat("dd").format(hoy));

		int e = aHoy - a;
		if (mHoy < m || (mHoy == m && dHoy < d)) {
			e--;
		}
		return e;
	}

	private static final int CESAR = 3;
	private static final int ROT13 = 13;

	private static String sustitucion(String mensaje, int clave) {
		String encriptada = "";
		for (int i = 0; i < mensaje.length(); i++) {
			char c = mensaje.charAt(i);
			if (c >= 'a' && c <= 'z') {
				int car = c + clave;
				if (car > 'z') car -= 26;
				encriptada += (char) car;
			} else if (c >= 'A' && c <= 'Z') {
				int car = c + clave;
				if (car > 'Z') car -= 26;
				encriptada += (char) car;
			} else {
				encriptada += c;
			}
		}
		return encriptada;
	}

	private static String riel(String mensaje) {
		String cad1 = "", cad2 = "";
		for (int i = 0; i < mensaje.length(); i++) {
			if (i % 2 == 0) cad1 += mensaje.charAt(i);
			else cad2 += mensaje.charAt(i);
		}
		return cad1 + cad2;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FormularioBuilder frame = new FormularioBuilder();
				frame.setTitle("Formulario Completo");
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}