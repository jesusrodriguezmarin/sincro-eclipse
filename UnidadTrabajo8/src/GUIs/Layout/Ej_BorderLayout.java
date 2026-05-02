package GUIs.Layout;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ej_BorderLayout extends JFrame {

	public Ej_BorderLayout() {

		// Alineación a la izquierda, 10px horizontal y vertical
		setLayout(new BorderLayout());

		add(new JButton("Norte"), BorderLayout.NORTH);
		add(new JButton("Sur"), BorderLayout.SOUTH);
		add(new JButton("Este"), BorderLayout.EAST);
		add(new JButton("Oeste"), BorderLayout.WEST);
		add(new JButton("Centro"), BorderLayout.CENTER);


	}


	// Programa principal
	public static void main(String[] args) {

		// Creamos objeto
		Ej_BorderLayout f = new Ej_BorderLayout();

		f.setTitle("Ejemplo FlowLayout");
		f.setSize(500, 300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);

	}

}
