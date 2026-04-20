package GUIs.componentes;

import javax.swing.*;

public class Ej_ComboBox extends JFrame {

	// Componentes
	JComboBox combo;
	
	// Creamos ventana
	public Ej_ComboBox() {
		setLayout(null);
		
		// Creamos el combo y sus items y añadimos
		combo = new JComboBox();
		combo.setBounds(10, 10, 120, 20);
		combo.addItem("Azul");
		combo.addItem("Rojo");
		combo.addItem("Verde");
		
		add(combo);
	}
	
	// Programa principal
	public static void main(String[] args) {

		// Creamos objeto
		Ej_ComboBox v = new Ej_ComboBox();
		
		// Configuramos
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);
		v.setTitle("Ejemplo ComboBox");
		v.setBounds(10, 10, 320, 150);
		v.setVisible(true);

	}

}
