package repasoGUIs;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Contenedor_ejemplo extends JFrame {

	/**
	 * Componentes
	 */
	private JPanel panel1, panel2;
	
	/**
	 * Constructor
	 */
	public Contenedor_ejemplo() {
		
		// Creamos el primer panel
		panel1 = new JPanel(new GridLayout(3,3));
		
		// Creamos un array de botones
		for (int i = 0; i < 9; i ++) {
			panel1.add(new JButton(""+i));
		}
		
		// Creamos el panel 2
		panel2 = new JPanel(new BorderLayout());
		
		// Al panel 2 le añadimos el panel 1 al centro
		panel2.add(panel1, BorderLayout.CENTER);
		
		// Al panel 2 le añadimos un botón al sur
		panel2.add(new JButton("CANCELAR"), BorderLayout.SOUTH);
		
		// --- Organizamos el contenido de la ventana principal ---
		
		// General
		setLayout(new BorderLayout());
		// Añadimos el panel 2 compuesto del 1 al east
		add(panel2, BorderLayout.EAST);
		// Añadimos un botón al genral al center
		add(new JButton("ACEPTAR"), BorderLayout.CENTER);
		
		
	}
	
	/**
	 * Programa principal
	 * @param args
	 */
	public static void main(String[] args) {
		Contenedor_ejemplo principal = new Contenedor_ejemplo();
		
		principal.setTitle("VENTANA PRINCIPAL");
		principal.setSize(600,300);
		principal.setLocationRelativeTo(null);
		principal.setVisible(true);
		principal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}
