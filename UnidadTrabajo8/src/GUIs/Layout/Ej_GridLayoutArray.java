package GUIs.Layout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ej_GridLayoutArray extends JFrame {

	// Constanten para el número de botones
	public final static int TAM = 8;
	
	public Ej_GridLayoutArray() {

		// Alineación en rejilla
		setLayout(new GridLayout(2, 4, 5,5));
		
		for (int i = 1; i <= TAM; i++) {
			add(new JButton("Btn"+i));
		}
	}

	// Programa principal
	public static void main(String[] args) {

		// Creamos objeto
		Ej_GridLayoutArray f = new Ej_GridLayoutArray();

		f.setTitle("Ejemplo GridLayout");
		f.setSize(500, 300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);

	}

}
