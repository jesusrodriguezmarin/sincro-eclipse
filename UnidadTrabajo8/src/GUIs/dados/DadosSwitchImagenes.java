package GUIs.dados;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DadosSwitchImagenes extends JFrame implements ActionListener {

	/**
	 * Componentes
	 */
	private JButton boton;

	/**
	 * Constructor
	 */
	public DadosSwitchImagenes() {
		
		// Creamos el botón y su listener
		boton = new JButton(new ImageIcon("C:\\proyectos\\dado\\dado1.png"));
		boton.setFont(new Font("Joan", Font.BOLD, 180));
		boton.addActionListener(this);

		// Añadimos los componentes a la ventana
		setLayout(new GridLayout(1,0));
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
				boton.setIcon(new ImageIcon("C:\\proyectos\\dado\\dado1.png"));
				break;
			case 2:
				boton.setIcon(new ImageIcon("C:\\proyectos\\dado\\dado2.png"));
				break;
			case 3:
				boton.setIcon(new ImageIcon("C:\\proyectos\\dado\\dado3.png"));
				break;
			case 4:
				boton.setIcon(new ImageIcon("C:\\proyectos\\dado\\dado4.png"));
				break;
			case 5:
				boton.setIcon(new ImageIcon("C:\\proyectos\\dado\\dado5.png"));
				break;
			case 6:
				boton.setIcon(new ImageIcon("C:\\proyectos\\dado\\dado6.png"));
				break;

			}
		}

	}

	// Programa principal
	public static void main(String[] args) {
		DadosSwitchImagenes d = new DadosSwitchImagenes();
		d.setTitle("Dado");
		d.setSize(250, 250);
		d.setLocationRelativeTo(null);
		d.setResizable(false);
		d.setDefaultCloseOperation(EXIT_ON_CLOSE);
		d.setVisible(true);
	}

}
