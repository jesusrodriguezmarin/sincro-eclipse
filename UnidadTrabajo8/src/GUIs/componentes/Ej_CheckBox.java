package GUIs.componentes;

import javax.swing.*;

public class Ej_CheckBox extends JFrame {

	// Componentes
	JCheckBox check1, check2;
	
	// Creamos ventana con dos controles
	public Ej_CheckBox() {
		setLayout(null);
		
		// Creamos los controles y los añadimos
		check1 = new JCheckBox("Pulsa para activar", true);
		check2 = new JCheckBox("Pulsa para desactivar");
		check1.setBounds(60, 20, 150, 25);
		check2.setBounds(60, 60, 150, 25);
		add(check1);
		add(check2);
	}
	
	// Programa principal
	public static void main(String[] args) {

		// Creamos la ventana y configuramos
		Ej_CheckBox c = new Ej_CheckBox();
		
		c.setTitle("Ejemplo checkBox");
		c.setBounds(100, 100, 300,150);
		c.setVisible(true);
		c.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
