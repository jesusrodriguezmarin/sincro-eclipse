package GUIs.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCerrar extends JFrame implements ActionListener {

	JButton boton;
	
	public VentanaCerrar() {
		setLayout(null);
		boton = new JButton("Cerrar");
		boton.setBounds(40, 40, 100, 25);
		add(boton);
		boton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==boton) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		VentanaCerrar v = new VentanaCerrar();
		v.setSize(200, 150);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
