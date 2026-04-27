package GUIs.listener;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ConversorDecimalRomanos extends JFrame implements ActionListener {

	/**
	 * Declaración de componentes de la ventana
	 */
	private JButton boton;
	private JTextField campo1, campo2;
	private JPanel panel;
	
	/**
	 * Constructor
	 */
	public ConversorDecimalRomanos() {
		// Creamos los componentes
		boton = new JButton("Convertir");
		campo1 = new JTextField(10);
		campo2 = new JTextField(10);
		panel = new JPanel();
		
		// Añadimos los componentes al panel
		panel.setLayout(new GridLayout(2, 3, 15, 10));
		panel.add(new JLabel("Nº decimal", JLabel.CENTER));
		panel.add(new JLabel());
		panel.add(new JLabel("Nº romano", JLabel.CENTER));
		panel.add(campo1);
		panel.add(boton);
		panel.add(campo2);
		
		// Añadimos el botón
		boton.addActionListener(this);
		
		// Añadimos el panel a la ventana
		setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		add(panel);
	}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==boton) {
				try {
					int a = Integer.parseInt(campo1.getText());		
					campo2.setText(decimalToRomano(a));
				} catch (Exception e2) {
					campo2.setText("ERROR");
				}
			}
		
	}
	
	/**
	 * Procedimiento que devuelve un nº en su forma romana
	 * @param N - nº entero
	 * @return un nº en su equivalencia romana
	 */
	private static String decimalToRomano (int N) {
		String res = "";
		int num = Math.abs(N);
		while (num >= 1000) {
			num-=1000;
			res+="M";
		}
		while (num >= 900) {
			num-=900;
			res+="CM";
		}
		while (num >= 500) {
			num-=500;
			res+="D";
		}
		while (num >= 400) {
			num-=400;
			res+="CD";
		}
		while (num >= 100) {
			num-=100;
			res+="C";
		}
		while (num >= 90) {
			num-=90;
			res+="XC";
		}
		while (num >= 50) {
			num-=50;
			res+="L";
		}
		while (num >= 40) {
			num-=40;
			res+="XL";
		}
		while (num >= 10) {
			num-=10;
			res+="X";
		}
		while (num >= 9) {
			num-=9;
			res+="IX";
		}
		while (num >= 5) {
			num-=5;
			res+="V";
		}
		while (num >= 4) {
			num-=4;
			res+="IV";
		}
		while (num >= 1) {
			num-=1;
			res+="I";
		}
		if (N < 0) {
			return res+=" a.C";
		} else {
			return res;
		}
	}
			
	public static void main(String[] args) {
		// Creamos la clase
		ConversorDecimalRomanos c = new ConversorDecimalRomanos();
		c.setTitle("Conversor Decimal > Romano");
		c.pack();
		c.setLocationRelativeTo(null);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setVisible(true);

	}


}
