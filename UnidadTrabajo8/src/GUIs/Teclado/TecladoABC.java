package GUIs.Teclado;

import java.awt.GridLayout;

import javax.swing.*;

public class TecladoABC extends JFrame {

	public TecladoABC() {
		setLayout(new GridLayout(3,9,5,5));
		
		for (int i = 'A'; i <= 'Z'; i++) {
			add(new JButton(""+(char)i));
		}
	}
	
	// Programa principal
	public static void main(String[] args) {

		TecladoABC g = new TecladoABC();
		g.setTitle("Ejemplo Teclado");
		g.setSize(300, 500);
		g.setLocationRelativeTo(null);
		g.setVisible(true);
		g.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
