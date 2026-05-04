package GUIs.repasoCasa;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class CrifradoBuilder extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private ButtonGroup grupoBotones;

	/**
	 * Create the frame.
	 */
	public CrifradoBuilder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(48, 52, 167, 183);
		contentPane.add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("Elige una opción:");
		lblNewLabel.setBounds(16, 6, 173, 16);
		panel.add(lblNewLabel);

		rdbtnNewRadioButton = new JRadioButton("CESAR");
		rdbtnNewRadioButton.setBounds(16, 34, 141, 23);
		panel.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("ROT13");
		rdbtnNewRadioButton_1.setBounds(16, 69, 141, 23);
		panel.add(rdbtnNewRadioButton_1);

		rdbtnNewRadioButton_2 = new JRadioButton("RIEL");
		rdbtnNewRadioButton_2.setBounds(16, 104, 141, 23);
		panel.add(rdbtnNewRadioButton_2);

		btnNewButton = new JButton("CIFRAR");
		btnNewButton.setBounds(6, 139, 117, 29);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(246, 52, 167, 183);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textField = new JTextField();
		textField.setBounds(17, 39, 130, 26);
		panel_1.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(17, 112, 130, 26);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		lblNewLabel_1 = new JLabel("Texto original:");
		lblNewLabel_1.setBounds(17, 11, 130, 16);
		panel_1.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Texto cifrado");
		lblNewLabel_2.setBounds(17, 77, 130, 16);
		panel_1.add(lblNewLabel_2);

		btnNewButton_1 = new JButton("BORRAR");
		btnNewButton_1.setBounds(17, 148, 117, 29);
		panel_1.add(btnNewButton_1);
		
		grupoBotones = new ButtonGroup();
		grupoBotones.add(rdbtnNewRadioButton);
		grupoBotones.add(rdbtnNewRadioButton_1);
		grupoBotones.add(rdbtnNewRadioButton_2);

		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {

			if (textField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debes utilizar un texto claro", "AVISO",
						JOptionPane.WARNING_MESSAGE);
			} else if (!rdbtnNewRadioButton.isSelected() && !rdbtnNewRadioButton_1.isSelected()
					&& !rdbtnNewRadioButton_2.isSelected()) {
				JOptionPane.showMessageDialog(null, "Debes elegir una opción", "AVISO", JOptionPane.WARNING_MESSAGE);
			} else {
				// CAMBIAMOS campo1 por campo2 para ver el resultado en la segunda caja
				if (rdbtnNewRadioButton.isSelected())
					textField_1.setText(sustitucion(textField.getText(), CESAR));
				if (rdbtnNewRadioButton_1.isSelected())
					textField_1.setText(sustitucion(textField.getText(), ROT13));
				if (rdbtnNewRadioButton_2.isSelected())
					textField_1.setText(riel(textField.getText()));
			}

		}
		// Botón borrar
		if (e.getSource() == btnNewButton_1) {
			textField_1.setText("");
			textField.setText("");
		}
	}

	// Constantes para las claves de sustitución (Cesar3 y Rot13)
	private static final int CESAR = 3;
	private static final int ROT13 = 13;

	/**
	 * Encripta una palabra pasada por parámetro por método de sustutución
	 * 
	 * @param palabra - String pasado por parámetro
	 * @param clave   - posiciones pasadas como clave a sustituir
	 * @return una palabra encriptada por sustitución tantas posiciones como la
	 *         clave indica
	 */
	private static String sustitucion(String mensaje, int clave) {
		// Palabra a crear
		String encriptada = "";
		int caracter;

		// Recorremos la palabra introducida
		for (int i = 0; i < mensaje.length(); i++) {

			// Si el caracter itinerante esta dentro del abecedario minúsculo
			if (mensaje.charAt(i) >= 'a' && mensaje.charAt(i) <= 'z') {

				// Encriptamos el caracter en caracter+clave
				caracter = mensaje.charAt(i) + clave;

				// Controlamos si tras la encriptacion se pasa de 'z'
				if (caracter > 'z') {

					// Restamos 26 para hacer la sustitución circular
					caracter = caracter - 26;
				}
				// Concatenamos el caracter en clave a la palabra nueva que estamos generando
				encriptada += (char) caracter;

				// En caso de mayúsculas igual con este condicional
			} else if (mensaje.charAt(i) >= 'A' && mensaje.charAt(i) <= 'Z') {
				caracter = mensaje.charAt(i) + clave;
				if (caracter > 'Z') {
					caracter -= 26;
				}
				encriptada += (char) caracter;

				// En otro caso es un caracter especial o número y lo dejamos tal cual
			} else {
				encriptada += mensaje.charAt(i);
			}
		}
		return encriptada;
	}

	/**
	 * Encripta por el método de transposición un mensaje pasado por parámetro junta
	 * letras impares primero, pares después concatena las dos cadenas
	 * 
	 * @param mensaje - String a encriptar
	 * @return un String referente al mensaje encriptado
	 */
	private static String riel(String mensaje) {
		String cad1 = "";
		String cad2 = "";
		for (int i = 0; i < mensaje.length(); i++) {
			if (i % 2 == 0) {
				cad1 += mensaje.charAt(i);
			} else {
				cad2 += mensaje.charAt(i);
			}
		}
		return cad1 + cad2;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrifradoBuilder frame = new CrifradoBuilder();
					frame.setTitle("Cifrado");
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
