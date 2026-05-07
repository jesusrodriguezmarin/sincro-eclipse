package GUIs.Layout;

import javax.swing.*;
import java.awt.*;

public class Ej_FlowLayoutArray extends JFrame {

	public Ej_FlowLayoutArray() {
		
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
		
		for (int i = 1; i <= 10; i++) {
			add(new JButton("Botón "+i));
		}
	}
	
	// Programa principal
	public static void main(String[] args) {

		// Creamos objeto
		Ej_FlowLayoutArray f = new Ej_FlowLayoutArray();
		
		f.setTitle("Ejemplo FlowLayout");
		f.setSize(500, 300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
	}

}
