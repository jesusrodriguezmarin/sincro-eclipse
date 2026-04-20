package GUIs.Teclado;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class TecladoNumerico extends JFrame {

	/**
	 * Componentes gráficos
	 * Declaramos el array
	 */
	private JButton[] numeros;
	
	/**
	 * Constructor
	 * Crea todos los componentes del JFrame
	 */
	public TecladoNumerico() {
		
		// Creamos los botones inicializando el array
		numeros = new JButton[10];
		
		setLayout(new GridLayout(3,9,5,5));
		
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = new JButton(Integer.toString(i));
			numeros[i].setFont(new Font("Arial", Font.BOLD, 25));
			add(numeros[i]);
		}
	}
	
	/**
	 * Programa principal
	 * @param args
	 */
	public static void main(String[] args) {

		TecladoNumerico g = new TecladoNumerico();
		g.setTitle("Ejemplo Teclado");
		g.setSize(300, 300);
		g.setLocationRelativeTo(null);
		g.setVisible(true);
		g.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
