package GUIs.Layout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ej_GridLayout extends JFrame {

	public Ej_GridLayout() {

		// Alineación a la izquierda, 10px horizontal y vertical
		setLayout(new GridLayout(3, 2, 5, 5));

		add(new JButton("1"));
		add(new JButton("2"));
		add(new JButton("3"));
		add(new JButton("4"));
		add(new JButton("5"));
		add(new JButton("6"));

	}


	// Programa principal
	public static void main(String[] args) {

		// Creamos objeto
		Ej_GridLayout f = new Ej_GridLayout();

		f.setTitle("Ejemplo FlowLayout");
		f.setSize(500, 300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);

	}

}
