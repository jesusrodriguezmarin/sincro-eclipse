package GUIs.dados;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DadosSwitchTodoEtiqueta extends JFrame implements ActionListener {

	/**
	 * Componentes
	 */
	private JButton boton;

	/**
	 * Constructor
	 */
	public DadosSwitchTodoEtiqueta() {
		
		// Creamos el botón y su listener
		boton = new JButton("?");
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
				boton.setText("1");
				break;
			case 2:
				boton.setText("2");
				break;
			case 3:
				boton.setText("3");
				break;
			case 4:
				boton.setText("4");
				break;
			case 5:
				boton.setText("5");
				break;
			case 6:
				boton.setText("6");
				break;

			default:
				break;
			}
		}

	}

	// Programa principal
	public static void main(String[] args) {
		DadosSwitchTodoEtiqueta d = new DadosSwitchTodoEtiqueta();
		d.setTitle("Dado");
		d.setSize(250, 250);
		d.setLocationRelativeTo(null);
		d.setDefaultCloseOperation(EXIT_ON_CLOSE);
		d.setVisible(true);
	}

}
