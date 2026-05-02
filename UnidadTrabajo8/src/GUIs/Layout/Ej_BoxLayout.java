package GUIs.Layout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ej_BoxLayout extends JFrame {

	public Ej_BoxLayout() {

		// Alineación a la izquierda, 10px horizontal y vertical
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		add(new JButton("Primero"));
		add(new JButton("Segundo"));
		add(new JButton("Tercero"));
	}


	// Programa principal
	public static void main(String[] args) {

		// Creamos objeto
		Ej_BoxLayout f = new Ej_BoxLayout();

		f.setTitle("Ejemplo FlowLayout");
		f.setSize(300, 150);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);

	}

}
