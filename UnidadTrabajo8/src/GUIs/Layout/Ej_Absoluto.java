package GUIs.Layout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ej_Absoluto extends JFrame {

	public Ej_Absoluto() {

		// Desactivamos cualquier ayuda
		setLayout(null);
		
		// Creamos boton
		JButton b = new JButton("Soy libre");
		
		// Establecemos medidas
		// x , y, ancho, algo
		b.setBounds(200, 60, 100, 50);
		
		// Añadimos
		add(b);

	}


	// Programa principal
	public static void main(String[] args) {

		// Creamos objeto
		Ej_Absoluto f = new Ej_Absoluto();

		f.setTitle("Ejemplo FlowLayout");
		f.setSize(500, 200);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);

	}

}
