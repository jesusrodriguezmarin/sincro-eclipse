package GUIs.Teclado;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class TecladoNumericoPanel extends JFrame {

	/**
	 * Componentes gráficos
	 * Declaramos el array
	 */
	private JButton[] numeros;
	
	/**
	 * Constructor
	 * Crea todos los componentes del JFrame
	 */
	public TecladoNumericoPanel() {
		
		// Creamos los botones inicializando el array
		numeros = new JButton[10];
		
		
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = new JButton(Integer.toString(i));
			numeros[i].setFont(new Font("Arial", Font.BOLD, 25));
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
	
	/**
	 * Programa principal
	 * @param args
	 */
	public static void main(String[] args) {

		TecladoNumericoPanel g = new TecladoNumericoPanel();
		g.setTitle("Ejemplo Teclado");
		g.setSize(300, 300);
		g.setLocationRelativeTo(null);
		g.setVisible(true);
		g.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
