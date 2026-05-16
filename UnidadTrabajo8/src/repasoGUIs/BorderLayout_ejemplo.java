package repasoGUIs;

import java.awt.BorderLayout;

import javax.swing.*;

public class BorderLayout_ejemplo extends JFrame {

	/**
	 * Constructor
	 * @param args
	 */
	public BorderLayout_ejemplo() {
		
		// Establecemos el border
		setLayout(new BorderLayout(5,10));	// Espacio x,y
		
		// Añadimos botones
		add(new JButton("Uno"), BorderLayout.CENTER);
		add(new JButton("Dos"), BorderLayout.NORTH);
		add(new JButton("Tres"), BorderLayout.SOUTH);
		add(new JButton("Cuatro"), BorderLayout.WEST);
		add(new JButton("Cinco"), BorderLayout.EAST);
	}
	
	public static void main(String[] args) {
		
		BorderLayout_ejemplo principal = new BorderLayout_ejemplo();
		
		principal.setTitle("VENTANA PRINCIPAL");
		principal.setSize(600,300);
		principal.setLocationRelativeTo(null);
		principal.setVisible(true);
		principal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

}
