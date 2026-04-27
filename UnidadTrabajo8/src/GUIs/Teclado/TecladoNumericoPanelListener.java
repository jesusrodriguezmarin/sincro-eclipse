package GUIs.Teclado;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TecladoNumericoPanelListener extends JFrame implements ActionListener {

	/**
	 * Componentes gráficos
	 * Declaramos el array
	 */
	private JButton[] numeros;
	
	/**
	 * Constructor
	 * Crea todos los componentes del JFrame
	 */
	public TecladoNumericoPanelListener() {
		
		// Creamos los botones inicializando el array
		numeros = new JButton[10];
		
		
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = new JButton(Integer.toString(i));
			numeros[i].setFont(new Font("Arial", Font.BOLD, 25));
			numeros[i].addActionListener(this);
		}
		
		// Metemos los botones uno a uno para localizar exactamene donde queremos
		setLayout(new GridLayout(4,3,5,5));
		add(numeros[7]);
		add(numeros[8]);
		add(numeros[9]);
		add(numeros[4]);
		add(numeros[5]);
		add(numeros[6]);
		add(numeros[1]);
		add(numeros[2]);
		add(numeros[3]);
		add(new JLabel());
		add(numeros[0]);


	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == numeros[0]) {
			setTitle("CERO");
		}
		if (e.getSource() == numeros[1]) {
			setTitle("UNO");
		}
		if (e.getSource() == numeros[1]) {
			setTitle("DOS");
		}
		if (e.getSource() == numeros[3]) {
			setTitle("TRES");
		}
		if (e.getSource() == numeros[4]) {
			setTitle("CUATRO");
		}
		if (e.getSource() == numeros[5]) {
			setTitle("CINCO");
		}
		if (e.getSource() == numeros[6]) {
			setTitle("SEIS");
		}
		if (e.getSource() == numeros[7]) {
			setTitle("SIETE");
		}
		if (e.getSource() == numeros[8]) {
			setTitle("OCHO");
		}
		if (e.getSource() == numeros[9]) {
			setTitle("NUEVE");
		}
		
	}
	
	/**
	 * Programa principal
	 * @param args
	 */
	public static void main(String[] args) {

		TecladoNumericoPanelListener g = new TecladoNumericoPanelListener();
		g.setTitle("Ejemplo Teclado");
		g.setSize(300, 300);
		g.setLocationRelativeTo(null);
		g.setVisible(true);
		g.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}


}
