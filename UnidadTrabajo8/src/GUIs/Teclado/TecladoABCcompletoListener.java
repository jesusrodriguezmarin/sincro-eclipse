package GUIs.Teclado;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TecladoABCcompletoListener extends JFrame implements ActionListener {

	public TecladoABCcompletoListener() {
		setLayout(new GridLayout(3,9,5,5));
		
		String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		
		JButton boton;
		
		for (int i = 0; i < abc.length(); i++) {
			boton = new JButton(""+abc.charAt(i));
			boton.addActionListener(this);	// Todos los botones usan el mismo listener
			add(boton);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		setTitle(b.getText());
	}
	
	// Programa principal
	public static void main(String[] args) {

		TecladoABCcompletoListener g = new TecladoABCcompletoListener();
		g.setTitle("Ejemplo Teclado");
		g.setSize(600, 250);
		g.setLocationRelativeTo(null);
		g.setVisible(true);
		g.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}


}
