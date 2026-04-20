package GUIs.componentes;

import javax.swing.*;

public class RadioButton extends JFrame {

	// Componente
	JRadioButton radio1, radio2;
	ButtonGroup grupoBotones;
	
	// Creamos la ventana con dos botones
	public RadioButton() {
		setLayout(null);
		
		// Creamos el grupo de botones
		grupoBotones = new ButtonGroup();
		
		// Creamos los radioButton y añadimos al grupo
		radio1 = new JRadioButton("Hombre", true);
		radio1.setBounds(50, 20, 100, 25);
		grupoBotones.add(radio1);
		
		radio2 = new JRadioButton("Mujer");
		radio2.setBounds(50, 60, 100, 25);
		grupoBotones.add(radio2);
		
		// Añadimos los botones a la ventana
		add(radio1);
		add(radio2);
	}
	
	// Programa principal
	public static void main(String[] args) {

		// Cramos objeto
		RadioButton v = new RadioButton();
		
		v.setTitle("Ejempli RadioButton");
		v.setBounds(10, 10, 330, 150);
		v.setVisible(true);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
