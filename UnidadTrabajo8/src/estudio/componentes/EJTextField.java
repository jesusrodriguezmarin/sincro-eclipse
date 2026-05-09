package estudio.componentes;

import javax.swing.*;
import java.awt.event.*;

public class EJTextField extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtDato;
	private JButton btnLeer;

	public EJTextField() {
		setTitle("Plantilla JTextField");
		setBounds(100, 100, 400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// El cuadro de texto
		txtDato = new JTextField();
		txtDato.setBounds(50, 50, 150, 30);
		contentPane.add(txtDato);

		// Botón para procesar el texto
		btnLeer = new JButton("Leer");
		btnLeer.setBounds(210, 50, 80, 30);
		btnLeer.addActionListener(this);
		contentPane.add(btnLeer);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLeer) {
			// TRUCO EXAMEN: .trim() quita espacios en blanco accidentales
			String contenido = txtDato.getText().trim();
			
			if (contenido.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Escribe algo primero");
			} else {
				System.out.println("El usuario escribió: " + contenido);
				txtDato.setText(""); // Limpiar después de leer
				txtDato.requestFocus(); // Volver a poner el cursor dentro
			}
		}
	}

	public static void main(String[] args) { new EJTextField().setVisible(true); }
}