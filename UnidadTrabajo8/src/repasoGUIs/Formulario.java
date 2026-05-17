package repasoGUIs;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Formulario extends JFrame {

	/**
	 * Constructor
	 */
	public Formulario() {
		
		// Creamos un panel para la izquierda
		JPanel panel1 = new JPanel(new GridLayout(0,1,15,20));
		
		// Creamos un panel para la derecha
		JPanel panel2 = new JPanel(new GridLayout(0,1,15,15));
		
		panel1.add(new JLabel("Nombre de usuario: "));
		panel2.add(new JTextField(""));
		panel1.add(new JLabel("Correo electrónico: "));
		panel2.add(new JTextField(""));
		panel1.add(new JLabel("Pais: "));
		String paises[] = {null, "España", "Francia"};
		panel2.add(new JComboBox<>(paises));
		panel1.add(new JCheckBox("Acepto"));
		panel2.add(new JButton("Aceptar"));
		
		// Añadimos los paneles a la ventana de izquierda a derecha
		setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
		add(panel1);
		add(panel2);
		
	}
	
	public static void main(String[] args) {

		// Instanciamos
		Formulario v = new Formulario();
		v.setTitle("Formulario");
		v.setSize(500, 300);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
