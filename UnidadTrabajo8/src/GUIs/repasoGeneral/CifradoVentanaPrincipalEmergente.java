package GUIs.repasoGeneral;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CifradoVentanaPrincipalEmergente extends JFrame implements ActionListener {

	/**
	 * Componentes
	 */
	private JPanel panel1, panel2;
	private JRadioButton radio1, radio2, radio3;
	private ButtonGroup grupoBotones;
	private JButton cifrar, borrar;
	private JTextField campo1, campo2;

	/**
	 * Constructor
	 */
	public CifradoVentanaPrincipalEmergente() {

		setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));

		// Creamos los radio botones
		radio1 = new JRadioButton("Cifrado CESAR3");
		radio2 = new JRadioButton("Cifrado ROT13");
		radio3 = new JRadioButton("Cifrado RIEL");

		// Creamos los botones
		cifrar = new JButton("Cifrar");
		borrar = new JButton("Borrar");

		// Añadimos el grupo
		grupoBotones = new ButtonGroup();
		grupoBotones.add(radio1);
		grupoBotones.add(radio2);
		grupoBotones.add(radio3);

		// Creamos el panel 1
		panel1 = new JPanel(new GridLayout(0, 1, 0, 10));
		panel1.add(new JLabel("Elige una opción: "));
		panel1.add(radio1);
		panel1.add(radio2);
		panel1.add(radio3);
		panel1.add(cifrar);

		// Creamos el panel 2
		panel2 = new JPanel(new GridLayout(0, 1, 0, 10));
		campo1 = new JTextField(15);
		campo2 = new JTextField(15);
		campo2.setEditable(false);

		panel2.add(new JLabel("Texto original:"));
		panel2.add(campo1);
		panel2.add(new JLabel("Texto cifrado:"));
		panel2.add(campo2);
		panel2.add(borrar);

		// Acitvamos los listeners para los botones
		cifrar.addActionListener(this);
		borrar.addActionListener(this);

		// Añadimos los paneles
		add(panel1);
		add(panel2);

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

			if (campo1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debes utilizar un texto claro", "AVISO",
						JOptionPane.WARNING_MESSAGE);
			} else if (!radio1.isSelected() && !radio2.isSelected() && !radio3.isSelected()) {
				JOptionPane.showMessageDialog(null, "Debes elegir una opción", "AVISO", JOptionPane.WARNING_MESSAGE);
			} else {
				// CAMBIAMOS campo1 por campo2 para ver el resultado en la segunda caja
				if (radio1.isSelected())
					campo2.setText(sustitucion(campo1.getText(), CESAR));
				if (radio2.isSelected())
					campo2.setText(sustitucion(campo1.getText(), ROT13));
				if (radio3.isSelected())
					campo2.setText(riel(campo1.getText()));
			}
		}

		// Botón borrar
		if (e.getSource() == borrar) {
			campo2.setText("");
			campo1.setText("");
			grupoBotones.clearSelection(); // Desmarca los radio buttons
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
