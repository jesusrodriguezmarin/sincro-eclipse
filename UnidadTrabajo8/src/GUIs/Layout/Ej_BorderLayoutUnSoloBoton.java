package GUIs.Layout;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ej_BorderLayoutUnSoloBoton extends JFrame {

	public Ej_BorderLayoutUnSoloBoton() {

		// Alineación a la izquierda, 10px horizontal y vertical
		setLayout(new BorderLayout());

		add(new JButton("Centro"), BorderLayout.CENTER);
		


	}


	// Programa principal
	public static void main(String[] args) {

		// Creamos objeto
		Ej_BorderLayoutUnSoloBoton f = new Ej_BorderLayoutUnSoloBoton();

		f.setTitle("Ejemplo BorderLayout");
		f.setSize(500, 300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);

	}

}
