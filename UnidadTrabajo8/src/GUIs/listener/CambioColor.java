package GUIs.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambioColor extends JFrame implements ActionListener {
	
	JButton rojo, azul, verde, amarillo;
	
	public CambioColor() {
		
		setLayout(null);
		
		rojo =  new JButton("rojo");
		rojo.setBounds(25, 40, 100, 25);
		add(rojo);
		rojo.addActionListener(this);
		
		azul =  new JButton("azul");
		azul.setBounds(145, 40, 100, 25);
		add(azul);
		azul.addActionListener(this);
		
		verde =  new JButton("verde");
		verde.setBounds(25, 80, 100, 25);
		add(verde);
		verde.addActionListener(this);
		
		amarillo =  new JButton("amarillo");
		amarillo.setBounds(145, 80, 100, 25);
		add(amarillo);
		amarillo.addActionListener(this);
	}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()==rojo) {
				getContentPane().setBackground(Color.red);
			}
			if (e.getSource()==azul) {
				getContentPane().setBackground(Color.blue);
			}
			if (e.getSource()==verde) {
				getContentPane().setBackground(Color.green);
			}
			if (e.getSource()==amarillo) {
				getContentPane().setBackground(Color.yellow);
			}

	}

	public static void main(String[] args) {
		CambioColor v = new CambioColor();
		v.setTitle("Colores");
		v.setSize(280, 200);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}


}
