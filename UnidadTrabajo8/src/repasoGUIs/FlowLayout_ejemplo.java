package repasoGUIs;

import java.awt.FlowLayout;

import javax.swing.*;

public class FlowLayout_ejemplo extends JFrame {

	/**
	 * Constructor
	 */
	public FlowLayout_ejemplo() {
		
		// Establecemos el flow
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));	// Espacio x,y
		
		// Añadimos los botones
		for (int i = 0; i < 10; i ++) {
			add(new JButton("Boton "+i));
		}
	}
	
	public static void main(String[] args) {
		
		FlowLayout_ejemplo principal = new FlowLayout_ejemplo();
		
		principal.setTitle("VENTANA PRINCIPAL");
		principal.setSize(600,300);
		principal.setLocationRelativeTo(null);
		principal.setVisible(true);
		principal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

}
