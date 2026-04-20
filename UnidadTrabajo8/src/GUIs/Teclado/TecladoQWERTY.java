package GUIs.Teclado;

import java.awt.GridLayout;
import javax.swing.*;

public class TecladoQWERTY extends JFrame {

	public TecladoQWERTY() {
		setLayout(new GridLayout(0, 10, 5, 5)); // Condicionamos las columnas si o si 10

		String abc = "QWERTYUIOPASDFGHJKLÑ ZXCVBNM";

		for (int i = 0; i < abc.length(); i++) {
			if (abc.charAt(i) == ' ') {
				add(new JLabel());
			} else {
				add(new JButton("" + abc.charAt(i)));

			}
		}
	}

	// Programa principal
	public static void main(String[] args) {

		TecladoQWERTY g = new TecladoQWERTY();
		g.setTitle("Ejemplo Teclado");
		g.setSize(600, 250);
		g.setLocationRelativeTo(null);
		g.setVisible(true);
		g.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
