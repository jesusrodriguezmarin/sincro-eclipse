package repasoGUIs;

import java.awt.GridLayout;

import javax.swing.*;

public class GridLayout_ejemplo extends JFrame {

	/**
	 * Contructor
	 */
	public GridLayout_ejemplo() {
		
		// Establecemos el grid
		setLayout(new GridLayout(3, 5, 5, 5));	// Filas, col, x, y
		
		for (int i = 0; i < 10; i++) {
			add(new JButton("Boton "+i));
		}
	}
	
	public static void main(String[] args) {
		
		GridLayout_ejemplo principal = new GridLayout_ejemplo();
		
		principal.setTitle("VENTANA PRINCIPAL");
		principal.setSize(600,300);
		principal.setLocationRelativeTo(null);
		principal.setVisible(true);
		principal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

}
