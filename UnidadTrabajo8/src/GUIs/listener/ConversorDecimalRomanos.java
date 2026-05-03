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

		// Inicializamos los componentes
		boton = new JButton("Convertir");
		campo1 = new JTextField(10);
		campo2 = new JTextField(10);
		panel = new JPanel();

		// Añadimos los componentes al panel definimos 2 filas, 3 columnas y distancias
		// 10
		panel.setLayout(new GridLayout(2, 3, 10, 10));
		// Primer componente del panel fila 1, columna 1
		panel.add(new JLabel("Nº decimal", JLabel.CENTER));
		// Segundo componente del panel fila 1, columna 2
		panel.add(new JLabel());
		// Tercer componente del panel fila 1, columna 3
		panel.add(new JLabel("Nº romano", JLabel.CENTER));
		// Cuarto componente fila 2, col 1
		panel.add(campo1);
		// Quinto componente fila 2, col 2
		panel.add(boton);
		// Sexto componente fila 2, col 3
		panel.add(campo2);

		// Añadimos el botón
		boton.addActionListener(this);

		// Añadimos el panel a la ventana definiendo su tamaño según los componentes
		setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		// Añadimos el panel a la ventana creada
		add(panel);
	}

	/**
	 * Función que realiza la acción del botón
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton) {
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
	 * 
	 * @param N - nº entero
	 * @return un nº en su equivalencia romana
	 */
	private static String decimalToRomano(int N) {

		// Variable para la cadena de texto
		String res = "";

		// Variable filtrar el número introducido por parámetro
		int num = Math.abs(N);

		// Bucle para concatenar
		while (num >= 1000) {
			num -= 1000;
			res += "M";
		}
		while (num >= 900) {
			num -= 900;
			res += "CM";
		}
		while (num >= 500) {
			num -= 500;
			res += "D";
		}
		while (num >= 400) {
			num -= 400;
			res += "CD";
		}
		while (num >= 100) {
			num -= 100;
			res += "C";
		}
		while (num >= 90) {
			num -= 90;
			res += "XC";
		}
		while (num >= 50) {
			num -= 50;
			res += "L";
		}
		while (num >= 40) {
			num -= 40;
			res += "XL";
		}
		while (num >= 10) {
			num -= 10;
			res += "X";
		}
		while (num >= 9) {
			num -= 9;
			res += "IX";
		}
		while (num >= 5) {
			num -= 5;
			res += "V";
		}
		while (num >= 4) {
			num -= 4;
			res += "IV";
		}
		while (num >= 1) {
			num -= 1;
			res += "I";
		}
		if (N < 0) {
			return res += " a.C";
		} else {
			return res;
		}
	}

	// Programa principal
	public static void main(String[] args) {
		// Creamos la clase
		ConversorDecimalRomanos c = new ConversorDecimalRomanos();
		
		// Configuramos la ventana
		c.setTitle("Conversor Decimal > Romano");
		c.pack();
		c.setLocationRelativeTo(null);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setVisible(true);

	}

}
