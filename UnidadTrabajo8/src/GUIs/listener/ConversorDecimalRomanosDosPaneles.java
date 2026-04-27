package GUIs.listener;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ConversorDecimalRomanosDosPaneles extends JFrame implements ActionListener {

	/**
	 * Declaración de componentes de la ventana
	 */
	private JButton boton;
	private JTextField campo1, campo2;
	private JPanel panel1, panel2;
	
	/**
	 * Constructor
	 */
	public ConversorDecimalRomanosDosPaneles() {
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(0, 1, 0, 10));
		panel1.add(new JLabel("Nº decimal", JLabel.CENTER));
		campo1 = new JTextField(10);
		panel1.add(campo1);
		
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(0, 1, 0, 10));
		panel2.add(new JLabel("Nº romano", JLabel.CENTER));
		campo2 = new JTextField(10);
		panel2.add(campo2);
		
	
		// Añadimos el botón
		boton = new JButton(new ImageIcon("C:/proyectos/flecha.png"));
		boton.setContentAreaFilled(false);
		boton.setBorder(null);
		boton.addActionListener(this);
		
		// Añadimos el panel a la ventana
		setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		add(panel1);
		add(boton);
		add(panel2);
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
		ConversorDecimalRomanosDosPaneles c = new ConversorDecimalRomanosDosPaneles();
		c.setTitle("Conversor Decimal > Romano");
		c.pack();
		c.setLocationRelativeTo(null);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setVisible(true);

	}


}
