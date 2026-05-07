package GUIs.Layout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ej_Absoluto extends JFrame {

	public Ej_Absoluto() {

		// Desactivamos cualquier ayuda
		setLayout(null);
		
		// Creamos boton
		JButton b = new JButton("125x75");
		
		// Establecemos medidas
		// x , y, ancho, algo
		b.setBounds(100, 50, 125, 75);
		
		JButton c = new JButton("100x50");
		c.setBounds(300,100,100,50);
		
		
		// Añadimos
		add(b);
		add(c);

	}


	// Programa principal
	public static void main(String[] args) {

		// Creamos objeto
		Ej_Absoluto f = new Ej_Absoluto();

		f.setTitle("Ejemplo Absoluto");
		f.setSize(500, 200);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);

	}

}
