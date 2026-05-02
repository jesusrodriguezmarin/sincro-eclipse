package GUIs.dados;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DadosSwitch extends JFrame implements ActionListener {

	/**
	 * Componentes
	 */
	private JLabel tirada;
	private JButton boton;

	/**
	 * Constructor
	 */
	public DadosSwitch() {
		// Creamos la etiqueta con la tirada
		tirada = new JLabel(new ImageIcon("C:/proyectos/dado/uno.png"));
		

		// Creamos el botón y su listener
		boton = new JButton("Tirar dado");
		boton.addActionListener(this);

		// Añadimos los componentes a la ventana
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		add(tirada);
		add(boton);
	}

	/**
	 * Método que implementa la función del botón
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton) {
			int num = (int) (Math.random() * 6 + 1);

			switch (num) {
			case 1:
				tirada.setIcon(new ImageIcon("C:/proyectos/dado/uno.png"));
				break;
			case 2:
				tirada.setText("2");
				break;
			case 3:
				tirada.setText("3");
				break;
			case 4:
				tirada.setText("4");
				break;
			case 5:
				tirada.setText("5");
				break;
			case 6:
				tirada.setText("6");
				break;

			default:
				break;
			}
		}

	}

	// Programa principal
	public static void main(String[] args) {
		DadosSwitch d = new DadosSwitch();
		d.setTitle("Dado");
		d.setSize(250, 250);
		d.setLocationRelativeTo(null);
		d.setResizable(false);
		d.setDefaultCloseOperation(EXIT_ON_CLOSE);
		d.setVisible(true);
	}

}
