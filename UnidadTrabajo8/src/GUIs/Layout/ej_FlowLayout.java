package GUIs.Layout;

import javax.swing.*;
import java.awt.*;

public class ej_FlowLayout extends JFrame {

	public ej_FlowLayout() {
		
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
		
		for (int i = 0; i <= 10; i++) {
			add(new JButton("Botón "+i));
		}
	}
	
	// Programa principal
	public static void main(String[] args) {

		// Creamos objeto
		
	}

}
