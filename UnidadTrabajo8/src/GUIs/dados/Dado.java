package GUIs.dados;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Dado extends JFrame implements ActionListener {
	
	/**
	 * Componentes
	 */
	private JLabel tirada;
	private JButton boton;
	
	/**
	 * Constructor
	 */
	public Dado() {
		// Creamos la etiqueta con la tirada
		tirada = new JLabel("?");
		tirada.setFont(new Font("Joan", Font.BOLD, 180));
		tirada.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Creamos el botón y su listener
		boton = new JButton("Tirar dado");
		boton.addActionListener(this);
		
		// Añadimos los componentes a la ventana
		setLayout(new BorderLayout(0,0));
		add(tirada, BorderLayout.CENTER);
		add(boton, BorderLayout.SOUTH);
	}

	
	/**
	 * Método que implementa la función del botón
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==boton) {
			int num = (int)(Math.random()*6+1);
			
			String numero = String.valueOf(num);
			tirada.setText(numero);
		}
		
	}
	
	// Programa principal
	public static void main(String[] args) {
		Dado d = new Dado();
		d.setTitle("Dado");
		d.setSize(250, 250);
		d.setLocationRelativeTo(null);
		d.setVisible(true);
		d.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


}
