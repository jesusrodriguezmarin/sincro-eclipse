package GUIs.repasoCasa;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GenerarTablaMultiplicar extends JFrame implements ActionListener {

	/**
	 * Componentes
	 */
	private JTextArea area;
	private JTextField campo;
	private JButton boton;

	/**
	 * Constructor
	 */
	public GenerarTablaMultiplicar() {
		// Creamos los componentes
		campo = new JTextField(6);

		// Botón
		boton = new JButton("Genera Tabla");
		boton.addActionListener(this);

		// Area
		area = new JTextArea(11, 25);
		area.setLineWrap(true);

		// Añadimos los componentes a la ventana
		setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
		add(new JLabel("Número: "));
		add(campo);
		add(boton);
		add(area);
	}

	/**
	 * Método que implementa el botón
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// Control de errores
		try {
			if (e.getSource() == boton) {
				// Parseamos el String del campo para operar
				int num = Integer.parseInt(campo.getText());

				if (num < 0 || num > 10) {
					area.setText("Debes introducir un número entero entre 1 y 10.");
				} else {
					String cad = "";
					for (int i = 1; i < 11; i++) {
						cad = cad + num + " x " + i + " = " + (num * i) + "\n";
					}
					area.setText(cad);
				}
			}

		} catch (Exception e2) {
			area.setText("Debes introducir un número entero entre 1 y 10.");
		}
	}

	// Programa principal
	public static void main(String[] args) {

		// Instanciamos una clase
		GenerarTablaMultiplicar t = new GenerarTablaMultiplicar();

		// Configuramos
		t.setTitle("Tablas de multiplicar");
		t.setSize(320, 300);
		t.setLocationRelativeTo(null);
		t.setVisible(true);
		t.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
