package GUIs.apariencia;

import javax.swing.*;
import java.awt.*;

public class FormularioMOTIF extends JFrame {

	public FormularioMOTIF() {
		
		setLayout(new GridLayout(4,2,10,10));
		
		add(new JLabel("Nombre de usuario: ", JLabel.RIGHT));
		add(new JTextField(""));
		add(new JLabel("Correo electrónico: ", JLabel.RIGHT));
		add(new JTextField(""));
		add(new JLabel("Indica tu pais de origen: ", JLabel.RIGHT));
		String[] paises = {null, "España", "Francia", "Italia", "Dinamarca"};
		add(new JComboBox<String>(paises));
		add(new JCheckBox("Acepto condiciones de uso"));
		add(new JButton("Aceptar"));
	}
	
	public static void main(String[] args) {

		// Establecemos un L&Y MOTIF
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		FormularioMOTIF f = new FormularioMOTIF();
		f.setTitle("L&F MOTIF");
		f.setBounds(100, 100, 400, 200);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
