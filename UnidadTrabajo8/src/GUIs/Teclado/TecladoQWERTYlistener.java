package GUIs.Teclado;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TecladoQWERTYlistener extends JFrame implements ActionListener {

	/**
	 * Constructor
	 */
	public TecladoQWERTYlistener() {
		
		// Condicionamos las columnas si o si 10
		setLayout(new GridLayout(0, 10, 5, 5)); 

		String abc = "QWERTYUIOPASDFGHJKLÑ ZXCVBNM";
		JButton boton;

		
		for (int i = 0; i < abc.length(); i++) {
			if (abc.charAt(i) == ' ') {
				add(new JLabel());
			} else {
				boton = new JButton(""+abc.charAt(i));
				boton.addActionListener(this);
				add(boton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			
		JButton b = (JButton)e.getSource();
		setTitle(b.getText());
		
	}
	
	// Programa principal
	public static void main(String[] args) {

		TecladoQWERTYlistener g = new TecladoQWERTYlistener();
		g.setTitle("Ejemplo Teclado");
		g.setSize(600, 250);
		g.setLocationRelativeTo(null);
		g.setVisible(true);
		g.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}


}
