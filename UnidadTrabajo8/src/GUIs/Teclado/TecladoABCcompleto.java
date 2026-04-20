package GUIs.Teclado;

import java.awt.GridLayout;

import javax.swing.*;

public class TecladoABCcompleto extends JFrame {

	public TecladoABCcompleto() {
		setLayout(new GridLayout(3,9,5,5));
		
		String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWYZ";
		
		for (int i = 0; i < abc.length(); i++) {
			add(new JButton(""+abc.charAt(i)));
		}
	}
	
	// Programa principal
	public static void main(String[] args) {

		TecladoABCcompleto g = new TecladoABCcompleto();
		g.setTitle("Ejemplo Teclado");
		g.setSize(600, 250);
		g.setLocationRelativeTo(null);
		g.setVisible(true);
		g.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
