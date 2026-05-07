package pruebasCasa;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutPruebas extends JFrame {

	public FlowLayoutPruebas() {
		
		// Establecemos disposición
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		for (int i = 1; i <= 5; i++) {
			add(new JButton(""+i));
		}
	}
	
	public static void main(String[] args) {
		
		// Instanciamos y configuramos ventana
		FlowLayoutPruebas v = new FlowLayoutPruebas();
		v.setTitle("Pruebas");
		v.setSize(500, 250);
		v.setLocationRelativeTo(null);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);
		v.setVisible(true);

	}

}
