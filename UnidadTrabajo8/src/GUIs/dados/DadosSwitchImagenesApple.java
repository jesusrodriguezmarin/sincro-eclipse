package GUIs.dados;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DadosSwitchImagenesApple extends JFrame implements ActionListener {

	/**
	 * Declaración de componentes
	 */
	private JButton boton;

	/**
	 * Constructor que se ajecuta al hacer un new
	 */
	public DadosSwitchImagenesApple() {
		
		// Creamos el botón y le cargamos una imagen pasandole la ruta
		boton = new JButton(new ImageIcon("/Users/jesusrodriguezmarin/Documents/ficherosEclipse/dado/dados/uno.png"));
		
		// Configuramos el texto detrás de la imagen
		boton.setFont(new Font("Joan", Font.BOLD, 180));
		
		// Conecta el botón con el método actionPerformed de esta clase
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
			// Genera un número aleatorio
			int num = (int) (Math.random() * 6 + 1);

			// Filtra el número generado
			switch (num) {
			case 1:
				// Quita la imagen anterior y coloca esta en el botón
				boton.setIcon(new ImageIcon("/Users/jesusrodriguezmarin/Documents/ficherosEclipse/dado/dados/uno.png"));
				break;
			case 2:
				boton.setIcon(new ImageIcon("/Users/jesusrodriguezmarin/Documents/ficherosEclipse/dado/dados/dos.png"));
				break;
			case 3:
				boton.setIcon(new ImageIcon("/Users/jesusrodriguezmarin/Documents/ficherosEclipse/dado/dados/tres.png"));
				break;
			case 4:
				boton.setIcon(new ImageIcon("/Users/jesusrodriguezmarin/Documents/ficherosEclipse/dado/dados/cuatro.png"));
				break;
			case 5:
				boton.setIcon(new ImageIcon("/Users/jesusrodriguezmarin/Documents/ficherosEclipse/dado/dados/cinco.png"));
				break;
			case 6:
				boton.setIcon(new ImageIcon("/Users/jesusrodriguezmarin/Documents/ficherosEclipse/dado/dados/seis.png"));
				break;

			}
		}

	}

	// Programa principal
	public static void main(String[] args) {
		
		// Creamos la instancia y disparamos el constructor
		DadosSwitchImagenesApple d = new DadosSwitchImagenesApple();
		
		// Nombre en la barra superior
		d.setTitle("Dado");
		// Tamaño de la ventana en forma cuadrada
		d.setSize(150, 150);
		// Centra la ventana
		d.setLocationRelativeTo(null);
		// Restringe el cambio de tamaño de la ventana
		d.setResizable(false);
		
		// Cierra las funciones del programa con el cierre de la ventana
		d.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Muestra la ventana
		d.setVisible(true);
	}

}
