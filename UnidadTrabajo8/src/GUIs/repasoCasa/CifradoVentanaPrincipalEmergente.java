package GUIs.repasoCasa;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class CifradoVentanaPrincipalEmergente extends JFrame implements ActionListener {

	/**
	 * Componentes
	 */
	private JPanel panel1, panel2, panel3, panel4;
	private JRadioButton radio1, radio2, radio3;
	private ButtonGroup grupoBotones;
	private JButton cifrar, borrar;
	private JLabel label1, label2, label3, label4;
	private JTextField campo1, campo2;

	/**
	 * Constructor
	 */
	public CifradoVentanaPrincipalEmergente() {

		setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));

		// Creamos grupo de botones
		grupoBotones = new ButtonGroup();
		grupoBotones.add(radio1);
		grupoBotones.add(radio2);
		grupoBotones.add(radio3);

		// Configuramos los paneles
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(0, 1, 0, 30));
		add(panel1);

		// Creamos una etiqueta
		label1 = new JLabel("Elige una opción de cifrado: ");
		panel1.add(label1);

		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(0, 1, 0, 30));
		add(panel2);

		label2 = new JLabel("Texto original: ");
		panel2.add(label2);

		campo1 = new JTextField();
		panel2.add(campo1);

		label3 = new JLabel("Texto cifrado: ");
		panel2.add(label3);

		campo2 = new JTextField();
		panel2.add(campo2);

		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1, 0, 0, 30));
		add(panel3);

		panel4 = new JPanel();
		panel4.setLayout(new BorderLayout());
		add(panel4);

		// Creamos los radio
		radio1 = new JRadioButton("Crifrado del cesar");
		panel1.add(radio1);
		radio1.addActionListener(this);

		radio2 = new JRadioButton("Crifrado del cesar");
		panel1.add(radio2);
		radio2.addActionListener(this);

		radio3 = new JRadioButton("Crifrado del cesar");
		panel1.add(radio3);
		radio3.addActionListener(this);

		// Creamos los botones
		cifrar = new JButton("Cifrar");
		panel1.add(cifrar);

		borrar = new JButton("Borrar");
		panel2.add(borrar);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cifrar) {
			if (campo1.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "Debes utilizar un txto claro", "AVISO",
						JOptionPane.WARNING_MESSAGE);
			else if (!radio1.isSelected() && !radio2.isSelected() && !radio3.isSelected())
				JOptionPane.showMessageDialog(null, "Debes elegir una opción", "AVISO",
						JOptionPane.WARNING_MESSAGE);
			else { 
				if (radio1.isSelected())
					campo1.setText(sustitucion(campo1.getText(), CESAR));
				if (radio2.isSelected())
					campo1.setText(sustitucion(campo1.getText(), ROT13));
				if (radio3.isSelected())
					campo1.setText(riel(campo1.getText()));
			}
			
			// Botón borrar
			if (e.getSource() == borrar) {
				campo2.setText("");
				campo1.setText("");
			}
		}
	}

	// Programa principal
	public static void main(String[] args) {

		// Instanciamos y configuramos la ventana principal
		CifradoVentanaPrincipalEmergente v = new CifradoVentanaPrincipalEmergente();

		v.setTitle("Cifrado");
		v.pack();
		v.setResizable(false);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
