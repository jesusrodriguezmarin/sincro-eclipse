package GUIs.Layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ej_FlowLayoutUnSoloBoton extends JFrame {

	public Ej_FlowLayoutUnSoloBoton() {

		// Alineación a la izquierda, 10px horizontal y vertical
		setLayout(new FlowLayout(FlowLayout.CENTER, 50, 100));

		add(new JButton("Boton 1"));
	
	}


	// Programa principal
	public static void main(String[] args) {

		// Creamos objeto
		Ej_FlowLayoutUnSoloBoton f = new Ej_FlowLayoutUnSoloBoton();

		f.setTitle("Ejemplo FlowCenter");
		f.setSize(500, 300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);

	}

}
